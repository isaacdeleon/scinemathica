<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Recomendacion</title>
<script type="text/javascript">;
	
	function generaLista(data)
	{
		json = data.peliculasJson;
		//alert(dataRow.peliculasJson);
		
		if(json[0] != null)
		{
		
			for (var i = 0; i < json.length; i++) 
			{
				$("#dataRow").append('<tr>' 
								+ '<td>' + json[i].nombre + '</td>' 
								+ '<td>' + json[i].descripcion + '</td>' 
								+ '<td><iframe width="180" height="130" src="http://www.youtube.com/embed/' + json[i].linkTrailer + '"frameborder="0" allowfullscreen></iframe></td>' 
								+ '<td><a href="' + json[i].linkDescarga + '" target="_new" title="Link de Descarga">Torrent Link</a></td>' 
								+ '<td>' + json[i].genero + '</td>' 
								+ '<td>' + json[i].usuario + '</td>' 
								+ '</tr>');
			}	
		}else
		{
			$("#dataRow").append('<tr>' 
								+ '<td>' + json.nombre + '</td>' 
								+ '<td>' + json.descripcion + '</td>' 
								+ '<td><iframe width="180" height="130" src="http://www.youtube.com/embed/' + json.linkTrailer + '"frameborder="0" allowfullscreen></iframe></td>' 
								+ '<td><a href="' + json.linkDescarga + '" target="_new" title="Link de Descarga">Torrent Link</a></td>' 
								+ '<td>' + json.genero + '</td>' 
								+ '<td>' + json.usuario + '</td>' 
								+ '</tr>');
		}		
	}
	
</script>
</head>
<body>
	<h3>Catalogo de Peliculas</h3>
	<table id="dataRow">
		<tr>
			<td>Pelicula</td>
			<td>Descripcion</td>
			<td>Link Youtube (Trailer)</td>
			<td>Link Torrent</td>
			<td>Genero</td>
			<td>Usuario</td>
		</tr>
	</table>
</body>
</html>