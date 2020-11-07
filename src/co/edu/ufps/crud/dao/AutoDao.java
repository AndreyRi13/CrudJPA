package co.edu.ufps.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import co.edu.ufps.crud.model.Auto;
import co.edu.ufps.crud.util.Conexion;

public class AutoDao {

	private Conexion<Auto> conexion= new Conexion();
	
	
	public AutoDao() {
		this.conexion = new Conexion(Auto.class);
	}
	
	public Auto select(int id) {
		
		return conexion.find(id);
		
	}
	
	public List<Auto> selectAll(){
		
		
		return conexion.list();
	}
	
	
	public void insert(Auto o) {
		
		conexion.insert(o);
		
		
	}
	public void update(Auto o) {
		
		conexion.update(o);
		
	}
	public void delete(int id) {
		
		conexion.delete(conexion.find(id));
		
	}
}
