<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Scinemathica here</title>
<script type="text/javascript">
	
	function registrar(nombreUsuario,password,mail)
	{
		$("#mainContent").load("registrarUsuario.htm",{nombreUsuario:nombreUsuario,password:password,mail:mail});
	}
</script>
</head>
<body>
	<h3>Registro Scinemathica</h3>
	
	<table>
		<tr>
			<td>Nombre de Usuario:</td>
			<td><input type="text" id="nombreUsuario"/></td>
		</tr>
			<td>Contraseña:</td>
			<td><input type="password" id="password"/></td>
		<tr>
		</tr>
		<tr>
			<td>Mail de Usuario:</td>
			<td><input type="text" id="mail"/></td>
		</tr>
	</table> 
	<input type="button" id="enviar" value="enviar" onclick="registrar($('#nombreUsuario').val(),$('#password').val(),$('#mail').val());">
	
</body>
</html>