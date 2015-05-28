<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function login(nombreUsuario,password)
	{
		$.post("login.htm",{nombreUsuario:nombreUsuario,password:password});
		$("#mainContent").load("login.htm",{nombreUsuario:nombreUsuario,password:password},function(){});
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>${respuesta}</td>
		</tr>
		<tr>
			<td>Nombre Usuario:</td>
			<td><input type="text" id="nombreUsuario" value="${nombreUsuario}"/></td>
		</tr>
		<tr>
			<td>Contraseña:</td>
			<td><input type="password" id="password"/></td>
		</tr>
	</table>
	<input type="button" id="enviar" value="enviar" onclick="login($('#nombreUsuario').val(),$('#password').val());"/>
</body>
</html>