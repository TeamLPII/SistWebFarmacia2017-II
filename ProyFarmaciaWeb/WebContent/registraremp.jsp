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
	<h1>Registrar Empleado</h1>
	
	<form id="formagregar" action="ServletEmpleado?tipo=registrar" method="post">
		<input type="hidden" name="txtid" >
		<label for="txtnombre">Nombre:</label>
		<input type="text" name="txtnombre" >
		<label for="txtappaterno">Ap. Paterno:</label>
		<input type="text" name="txtappaterno" >
		<label for="txtapmaterno">Ap. Materno:</label>
		<input type="text" name="txtapmaterno" >
		<label for="txtfechanac">Fecha de Nac.:</label>
		<input type="text" name="txtfechanac" >
		<label for="txtfecingreso">Fecha de ingreso:</label>
		<input type="text" name="txtfecingreso" >
		<label for=""txtusuario"">Usuario:</label>
		<input type="text" name="txtusuario" >
		<label for="txtclave">Clave:</label>
		<input type="text" name="txtclave" >
		<label for="txtcargo">Cargo:</label>
		<input type="text" name="txtcargo" >
		<label for="txttelefono">Teléfono:</label>
		<input type="text" name="txttelefono" >
		
		<input type="submit" value="Grabar">
	</form>
	
</body>
</html>