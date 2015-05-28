package org.mx.scinemathica.dao;

import java.util.ArrayList;
import java.util.List;

import org.mx.scinemathica.dto.PeliculaDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class PeliculaDAO 
{
	public boolean AgregaPelicula(PeliculaDTO peliculaDTO)
	{
		System.out.println("+++++Agrega Pelicula+++++");
		boolean exitoso = false;
		
		try
		{
			Key peliculaKey = KeyFactory.createKey("Pelicula",peliculaDTO.getNombre());
			Entity pelicula = new Entity("Pelicula",peliculaKey);
			pelicula.setProperty("nombre",peliculaDTO.getNombre());
			pelicula.setProperty("descripcion",peliculaDTO.getDescripcion());
			pelicula.setProperty("linkTrailer",peliculaDTO.getLinkTrailer());
			pelicula.setProperty("linkDescarga",peliculaDTO.getLinkDescarga());
			pelicula.setProperty("usuario",peliculaDTO.getUsuario());
			pelicula.setProperty("genero",peliculaDTO.getGenero());
			
			DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
			dataStore.put(pelicula);
			
			exitoso = true;
			
		}catch(Exception ex)
		{
			exitoso = false;
			ex.printStackTrace();
		}
		
	return exitoso;
	}
	
	
	public List<PeliculaDTO> obtienePeliculas()
	{
		System.out.println("+++++Obtiene Peliculas+++++");
		List<PeliculaDTO> listaPeliculas = new ArrayList<PeliculaDTO>();
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Pelicula");
		List<Entity> peliculas = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		try
		{
			for (Entity entity : peliculas) 
			{
				PeliculaDTO peliculaDTO = new PeliculaDTO();
				peliculaDTO.setNombre(entity.getProperty("nombre").toString());
				peliculaDTO.setDescripcion(entity.getProperty("descripcion").toString());
				peliculaDTO.setLinkTrailer(entity.getProperty("linkTrailer").toString());
				peliculaDTO.setLinkDescarga(entity.getProperty("linkDescarga").toString());
				peliculaDTO.setGenero(entity.getProperty("genero").toString());
				peliculaDTO.setUsuario(entity.getProperty("usuario").toString());
				listaPeliculas.add(peliculaDTO);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaPeliculas;
	}
	
	public List<PeliculaDTO> obtienePeliculaByUser(String usuario)
	{
		System.out.println("+++++Obtiene Peliculas por usuario+++++");
		List<PeliculaDTO> listaPeliculas = new ArrayList<PeliculaDTO>();
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Pelicula");
		query.addFilter("usuario",Query.FilterOperator.EQUAL,usuario);
		List<Entity> peliculas = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		for (Entity entity : peliculas) 
		{
			PeliculaDTO peliculaDTO = new PeliculaDTO();
			peliculaDTO.setNombre(entity.getProperty("nombre").toString());
			peliculaDTO.setDescripcion(entity.getProperty("descripcion").toString());
			peliculaDTO.setLinkTrailer(entity.getProperty("linkTrailer").toString());
			peliculaDTO.setLinkDescarga(entity.getProperty("linkDescarga").toString());
			peliculaDTO.setGenero(entity.getProperty("genero").toString());
			peliculaDTO.setUsuario(entity.getProperty("usuario").toString());
			listaPeliculas.add(peliculaDTO);
		}
		
		for (PeliculaDTO PeliculaDTO : listaPeliculas) 
		{
			System.out.println(PeliculaDTO.getNombre());
		}
		return listaPeliculas;
	}
	
	public void borrarPelicula(String peliculaBorrar)
	{
		System.out.println("+++++ Borrar pelicula +++++");
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService(); 
		
		Query query = new Query("Pelicula");
		query.addFilter("nombre",Query.FilterOperator.EQUAL,peliculaBorrar);
		
		Entity pelicula = datastoreService.prepare(query).asSingleEntity();
		Key peliculaKey = pelicula.getKey();

		datastoreService.delete(peliculaKey);
	}
}
