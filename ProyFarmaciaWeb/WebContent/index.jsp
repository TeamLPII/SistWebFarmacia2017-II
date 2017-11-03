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
	<form action="ServletEmpleado?tipo=login" name="frmsesion"
		method="post">
		<table border="1" align="center">
			<tr>
				<td>Login</td>
				<td><input type="text" name="txtusuario"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="txtclave"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">${requestScope.msg}</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Iniciar"></td>
			</tr>
		</table>
	</form>
</body>
</html>