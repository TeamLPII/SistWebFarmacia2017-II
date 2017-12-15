
<%@page import="beans.EmpleadoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String item = request.getParameter("item");
%>

<%
EmpleadoDTO usuario= null;
	if(session.getAttribute("usuario") != null){
		usuario = (EmpleadoDTO) session.getAttribute("usuario");
	}
%>

<!--HEADER-->
    <header class="container-fluid mb-3">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Menú SysFarma">
                <span class="navbar-toggler-icon"></span>

            </button>
            <a href="home.jsp" class="navbar-brand"><img src="img/color/logo.svg"> SysFarma</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                <% if(usuario.getCargo().getNombre().equalsIgnoreCase("Administrador")){ %>
                    <li class="<% out.print(item.equals("empleados")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="ServletEmpleado?tipo=listar">Empleados</a>
                    </li>
                    <li class="<% out.print(item.equals("productos")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="ServletProducto?tipo=listar">Productos</a>
                    </li>
<%--                     <li class="<% out.print(item.equals("ventas")?"nav-item active":"nav-item");%>"> --%>
<!--                     	<a class="nav-link" href="#">Ventas</a> -->
<!--                     </li> -->
                    <li class="<% out.print(item.equals("nueva venta")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="nuevaventa.jsp">Nueva Venta</a>
                    </li>
                    <li class="<% out.print(item.equals("clientes")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="ServletCliente?tipo=listar">Clientes</a>
                    </li>
                    <li class="<% out.print(item.equals("realizarPago")?"nav-item active":"nav-item");%>"><a class="nav-link" 
					href="realizarPago.jsp">Realizar Pago</a>
					</li>
					<li class="<% out.print(item.equals("reportes")?"nav-item active":"nav-item");%>"><a class="nav-link" href="ServletReportes?tipo=listarVendedor">Reportes</a>
					</li>
                 <%}else if(usuario.getCargo().getNombre().equalsIgnoreCase("almacenero")){ %>
                 	 <li class="<% out.print(item.equals("productos")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="ServletProducto?tipo=listar">Productos</a>
                    </li>
                    <li class="<% out.print(item.equals("reportes")?"nav-item active":"nav-item");%>"><a class="nav-link" href="ServletReportes?tipo=listarVendedor">Reportes</a>
					</li>
                 <%}else if(usuario.getCargo().getNombre().equalsIgnoreCase("vendedor")){ %>
                 	<%-- <li class="<% out.print(item.equals("ventas")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="#">Ventas</a>
                    </li> --%>
                    <li class="<% out.print(item.equals("nueva venta")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="nuevaventa.jsp">Nueva Venta</a>
                    </li>
                    <li class="<% out.print(item.equals("clientes")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="ServletCliente?tipo=listar">Clientes</a>
                    </li>
                    <li class="<% out.print(item.equals("realizarPago")?"nav-item active":"nav-item");%>"><a class="nav-link" 
					href="realizarPago.jsp">Realizar Pago</a>
					</li>
					<li class="<% out.print(item.equals("reportes")?"nav-item active":"nav-item");%>"><a class="nav-link" href="ServletReportes?tipo=listarVendedor">Reportes</a>
					</li>
                 <%}else{ %>
                 	<li class="<% out.print(item.equals("ventas")?"nav-item active":"nav-item");%>">
                    	<a class="nav-link" href="#">Ventas</a>
                    </li>
                 <%} %>
                </ul>
                <div class="form-inline btn-group my-2 my-lg-0">
                    <button class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="img/color/user-f.svg"> Bienvenido <%=usuario.getPrimerAp() %>
                    </button>
                    <div class="usuario dropdown-menu">
                        <button class="dropdown-item"><a href="ServletEmpleado?tipo=buscaruser&cod=<%=usuario.getIdEmpleado()%>">Cuenta</a></button>

                        <button class="dropdown-item"><a href="ServletEmpleado?tipo=cerrarSesion" class="">Salir</a></button>

                    </div>
                </div>
            </div>
        </nav>


    </header>
    <!--END HEADER-->