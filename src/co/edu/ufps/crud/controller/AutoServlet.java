package co.edu.ufps.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.crud.dao.AutoDao;
import co.edu.ufps.crud.model.Auto;

/**
 * Servlet implementation class CamisaServlet
 */
@WebServlet("/")
public class AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AutoDao autoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.autoDao = new AutoDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertarAuto(request, response);
			break;
		case "/delete":
			 eliminarAuto(request, response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			actualizarAuto(request,response);
			break;

		default:
			listAutos(request,response);
			break;
		}
		  }
		catch(SQLException e) {
			throw new ServletException(e);
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}
	
private void insertarAuto(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, SQLException, IOException {
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		
		Auto auto = new Auto (marca,modelo,color);
		autoDao.insert(auto);
		
		response.sendRedirect("listAutos");
		
				
	}

private void eliminarAuto(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        autoDao.delete(id);
	        response.sendRedirect("listAutos");

	    }

private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Auto autoActual = autoDao.select(id);
	        request.setAttribute("auto", autoActual);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
	        dispatcher.forward(request, response);

	    }

private void actualizarAuto(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	String color = request.getParameter("color");
	
	Auto auto = new Auto (id,marca,modelo,color);
	autoDao.update(auto);
	
	response.sendRedirect("listAutos");
	       
	    }

private void listAutos(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Auto > autos = autoDao.selectAll();
	        request.setAttribute("autos", autos);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	    }




}
