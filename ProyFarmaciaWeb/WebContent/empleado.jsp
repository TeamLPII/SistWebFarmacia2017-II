<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.EmpleadoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="WEB-INF/validar.jsp"></jsp:include>
    
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Lista de Empleados</title>
</head>
<body>
<%
	List<EmpleadoDTO> lista = (ArrayList<EmpleadoDTO>) request.getAttribute("empleados");
%>
	
	<table border="2" align="center" width="75%">
		<tr>
			<th>CODIGO</th>
			<th>NOMBRES</th>
			<th>FECHA INGRESO</th>
			<th>CARGO</th>
			<th>USUARIO</th>
			<th colspan="2">ACCIONES</th>
		</tr>
		<%
			if(lista!=null){
				for(EmpleadoDTO xEmp : lista){
					out.println("<tr>");
					out.println("<td>"+xEmp.getIdEmpleado()+"</td>");
					out.println("<td>"+xEmp.getNombre()+"</td>");
					out.println("<td>"+xEmp.getFechaIngreso()+"</td>");
					out.println("<td>"+xEmp.getCargo().getNombre()+"</td>");
					out.println("<td>"+xEmp.getUsuario()+"</td>");
					out.println("<td><a href='ServletEmpleado?tipo=buscar&cod="+xEmp.getIdEmpleado()+"'>"+"Editar"+"</a></td>");
					out.println("<td><a href='ServletEmpleado?tipo=eliminar&cod="+xEmp.getIdEmpleado()+"'>"+"Eliminar"+"</a></td>");
					out.println("</tr>");
				}
			}
		%>
	</table>
</body>
</html>