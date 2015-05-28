<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AgregaPelicula</title>
<script>
	function agregarPelicula(nombre,descripcion,linkTrailer,linkDescarga,ComboGenero)
	{
		if(descripcion.length < 500 )
		{
			$("#mainContent").load("agregarPelicula.htm",{nombre:nombre,descripcion:descripcion,linkTrailer:linkTrailer,linkDescarga:linkDescarga,ComboGenero:ComboGenero},function(){});
		}else
		{
			alert("Descripcion debe ser menor a 500 caracteres");
			return false;
		}
	}
</script>
</head>
<body>
	<h3>Agrega Pelicula Nueva</h3>
	
	<table>
		<tr>
			<td>Nombre de la Pelicula</td>
			<td><input type="text" id="nombre"/></td>
		</tr>
		<tr>
			<td>Descripción</td>
			<td>
				<textarea id="descripcion" rows="15" cols="25">
				
				</textarea>
			</td>
		</tr>
		<tr>
			<td>Link de Youtube(Trailer)</td>
			<td><input type="text" id="linkTrailer"/></td>
		</tr>
		<tr>
			<td>Link de Torrent</td>
			<td><input type="text" id="linkDescarga"/></td>
		</tr>
		<tr>
			<td>Genero</td>
			<td>
				<select id="ComboGenero">
					<option value="0" selected="selected">Genero</option>
					<option value="accion">Acción</option>
					<option value="terror">Terror</option>
					<option value="comedia">Comedia</option>
					<option value="scifi">Sci-Fi</option>
					<option value="documental">Documental</option>
					<option value="alternativo">Alternativo</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<br/>
			<td><input type="button" id="submit" value="Agregar" onclick="agregarPelicula($('#nombre').val(),$('#descripcion').val(),$('#linkTrailer').val(),$('#linkDescarga').val(),$('#ComboGenero').val());"/></td>
		</tr>
	</table>
</body>
</html>