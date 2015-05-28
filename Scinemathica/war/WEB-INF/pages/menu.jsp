<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript">
	function agregar()
	{
		$("#mainContent").load("agregarPeliculaInicio.htm",function(){});
	}
	
</script>
</head>
<body>
	<h3>Agrega Pelicula</h3>
	<table>
		<tr>
			<td><input type="button" name="agregar" value="Agregar" onclick="agregar();"/></td>
		</tr>
		<tr>
			<td><input type="button" name="mostrar" value="Mostrar" onclick="goCatalogo();"/></td>
		</tr>
	</table>
</body>
</html>