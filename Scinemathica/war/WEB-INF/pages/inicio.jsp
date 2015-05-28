<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	$(document).ready(function(){
		
	});
	
	function registro()
	{
		$("#mainContent").load("registro.htm",function(){});
	}
	
	function login()
	{
		$("#mainContent").load("inicioLogin.htm",function(){});
	}
	
</script>
<title>Scinemathica</title>
</head>
<body>
	<h3>Acceso Scinemathica</h3>
	<table>
		<tr>
			<td>${respuesta}</td>
		</tr>
		<tr class="contact_form">
			<td><input type="button" class="submit_btn float_l" value="Registrarse" onclick="registro();"/></td>
		</tr>
		<tr class="contact_form">
			<td><input type="button" class="submit_btn float_l" value="Login" onclick="login();"/></td>			
		</tr>
	</table>

</body>
</html>