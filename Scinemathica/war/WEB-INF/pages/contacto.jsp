<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacto</title>
<script type="text/javascript">
	function enviaCorreo(subject,mensaje)
	{
		//alert("entro envia correo");
		$("#mainContent").load("enviaCorreo.htm",{subject:subject,mensaje:mensaje},function(){});
	}
</script>
</head>
<body>
	<h3>Contacto</h3>
	<table>
		<tr>
			<td><strong>${respuestaCorreo}</strong></td>
		</tr>
		<tr>
			<td>Asunto</td>
			<td><input type="text" id="subject"/></td>
		</tr>
		<tr>
			<td>Mensaje</td>
			<td><textarea id="mensaje" rows="15" cols="25"></textarea>></td>
		</tr>
	</table>
	<input type="button" id="enviarCorreo" value="enviar" onclick="enviaCorreo($('#subject').val(),$('#mensaje').val());"/>
</body>
</html>