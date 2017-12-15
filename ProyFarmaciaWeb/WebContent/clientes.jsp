<%@page import="beans.EmpleadoDTO"%>
<%@page import="beans.ClientesDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	EmpleadoDTO empleado = null;
	if(session.getAttribute("usuario")!=null){
		empleado = (EmpleadoDTO) session.getAttribute("usuario");
	}else{
		response.sendRedirect("login.jsp");
	}
%>

<!-- Encabezado -->
<jsp:include page="WEB-INF/head.jsp">
	<jsp:param value="Clientes" name="title" />
</jsp:include>
<!-- Menú -->
<jsp:include page="WEB-INF/menu-navegacion.jsp">
	<jsp:param value="clientes" name="item" />
</jsp:include>

<main class="container">
	<div class="row">
		<div class="col">
			<h2 class="titulo bg-info text-white py-2" style="text-align: center">LISTADO DE
				CLIENTES</h2>
				
			<form class="form-inline" action="ServletCliente?tipo=buscarNombre"
				method="post">
				
				<input name="txtBuscar" class="form-control " type="text"
					placeholder="Buscar por Nombres y/o Apellidos" aria-label="Search"
					size="50px">
				<button class="btn btn-success" type="submit">
					<img src="svg/si-glyph-magnifier.svg" width="16px" height="16px">Buscar
				</button>
				
			</form>
			
		</div>
	</div>
	<div class="row">
		<div class="col-md-10"></div>
		<div class="col-md-2">
			<button class="btn btn-success" type="submit" data-toggle="modal"
				data-target="#exampleModal">
				<img src="svg/si-glyph-person-plus.svg" width="16px" height="16px">Nuevo
			</button>
		</div>
	</div>
	
	<br>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-hover table-striped table-responsive">
				<tr>
					<th scope="row">IdCliente</th>
					<th scope="row">Nombres y Apellidos</th>
					<th scope="row">DNI</th>
					<th scope="row">Fecha de Registro</th>
					<th scope="row">Sexo </th>
					<th scope="row" colspan="2">Acciones</th>

				</tr>
				<%
					ArrayList<ClientesDTO> lista = (ArrayList<ClientesDTO>) request.getAttribute("dataCliente");
					if (lista != null) {
						for (ClientesDTO tempCli : lista) {
							out.println("<tr>");
							out.println("<td>" + tempCli.getIdCliente() + "</td>");
							out.println("<td>" + tempCli.getNombre() + "  " + tempCli.getPrimerApellido() + "  "+ tempCli.getSegundoApellido() + "</td>");
							out.println("<td>" + tempCli.getDNI() + "</td>");
							out.println("<td>" + tempCli.getFechaRegistro() + "</td>");
							if(tempCli.getSexo().equals("M"))
							out.println("<td>" + tempCli.getSexo() + " <img  src='svg/si-glyph-male.svg' width='16px' height='16px'></td>");
							else if(tempCli.getSexo().equals("F"))
							out.println("<td>" + tempCli.getSexo() + " <img  src='svg/si-glyph-female.svg' width='16px' height='16px'></td>");
							
							out.println("<td align='center'><a href='#' class='btn btn-primary' data-toggle='modal' data-target='#frm-editar-cliente'"
								+" onclick=\"cargarCliente(\'"+tempCli.getIdCliente()+"\', \'"+tempCli.getNombre()+"\', \'"+tempCli.getPrimerApellido()+"\', \'"
								+tempCli.getSegundoApellido()+"\', \'"+tempCli.getDNI()+"\', \'"+tempCli.getFechaRegistro()+"\',  \'"+tempCli.getSexo()+"\')\""
								+ " id='editar'><img src='svg/si-glyph-pencil.svg' width='16px' height='16px'>Editar</a></td>");
							
							out.println("<td align?'center'><a  href='#' class='btn btn-danger' data-toggle='modal' data-target='#frm-eliminar-cliente'"
									+" onclick=\"eliminarCliente(\'"+tempCli.getIdCliente()+"\', \'"+tempCli.getNombre()+" "+tempCli.getPrimerApellido()+"\')\" id='eliminar'>"
									+ "<img src='svg/si-glyph-delete.svg' width='16px' height='16px'>Eliminar</a></td>");
							out.println("</tr>");
						}
					}
				%>				
			</table>
			<jsp:include page="actualizarCliente.jsp"></jsp:include>
			<jsp:include page="eliminarCliente.jsp"></jsp:include>
			<jsp:include page="agregarCliente.jsp"></jsp:include>			
		</div>
	</div>
</main>


<!-- Pie de página -->
<%@include file="WEB-INF/footer.jsp"%>
