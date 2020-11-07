<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Administración de autos</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Administración de autos</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Autos</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${auto != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${auto == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${auto != null}">
                                    Editar Auto
                                </c:if>
                                <c:if test="${auto == null}">
                                    Agregar Nuevo Auto
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${auto != null}">
                            <input type="hidden" name="id" value="<c:out value='${auto.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Marca de Auto</label> <input type="text" value="<c:out value='${auto.marca}' />" class="form-control" name="marca" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Modelo de Auto</label> <input type="text" value="<c:out value='${auto.modelo}' />" class="form-control" name="modelo">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Color de Auto</label> <input type="text" value="<c:out value='${auto.color}' />" class="form-control" name="color">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>