<%@page import="beans.EmpleadoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Insert title here</title>
</head>
<body>
	<%
	EmpleadoDTO obj = (EmpleadoDTO) request.getAttribute("Empleado");
	%>
	<form id="formagregar" action="ServletEmpleado?tipo=actualizar" method="post">
		<input type="hidden" name="txtid" value="${requestScope.Empleado.idEmpleado }">
		<label for="txtnombre">Nombre:</label>
		<input type="text" name="txtnombre" value="${requestScope.Empleado.nombre }">
		<label for="txtappaterno">Ap. Paterno:</label>
		<input type="text" name="txtappaterno" value="${requestScope.Empleado.primerAp }">
		<label for="txtapmaterno">Ap. Materno:</label>
		<input type="text" name="txtapmaterno" value="${requestScope.Empleado.segundoAp }">
		<label for="txtfechanac">Fecha de Nac.:</label>
		<input type="text" name="txtfechanac" value="${requestScope.Empleado.fechaNac }">
		<label for="txtfecingreso">Fecha de ingreso:</label>
		<input type="text" name="txtfecingreso" value="${requestScope.Empleado.fechaIngreso }">
		<label for=""txtusuario"">Usuario:</label>
		<input type="text" name="txtusuario" value="${requestScope.Empleado.usuario }">
		<label for="txtclave">Clave:</label>
		<input type="text" name="txtclave" value="${requestScope.Empleado.clave }">
		<label for="txtcargo">Cargo:</label>
		<input type="text" name="txtcargo" value="${requestScope.Empleado.cargo.idCargo }">
		<label for="txttelefono">Teléfono:</label>
		<input type="text" name="txttelefono" value="${requestScope.Empleado.telefono }">
		
		<input type="submit" value="Actualizar">
	</form>
</body>
</html>