package org.mx.scinemathica.dao;

import java.util.List;

import org.mx.scinemathica.dto.UsuarioDTO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class UsuariosDAO 
{	
	public String agregaUsuario(UsuarioDTO usuarioDTO)
	{
		System.out.println("++++++++agregaUsuario ++++++");
		String respuesta = null;
		try
		{
			Key usuarioKey = KeyFactory.createKey("Usuario", usuarioDTO.getNombre());
			Entity usuario = new Entity("Usuario",usuarioKey);
			usuario.setProperty("nombre", usuarioDTO.getNombre());
			usuario.setProperty("password", usuarioDTO.getPassword());
			usuario.setProperty("mail", usuarioDTO.getMail());
		
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(usuario);
			
			respuesta = "El registro fue exitoso";
			
		}catch(Exception ex)
		{
			respuesta = "Fallo el registro";
			ex.printStackTrace();
//			throw new RuntimeException(ex);
		}
		
		return respuesta;
	}
	
	public void obtieneUsuarios()
	{
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Usuario");
		List<Entity> usuarios = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());

		for (Entity entity : usuarios) 
		{
			System.out.println(entity.getKey().getId());
			System.out.println(entity.getProperty("nombre"));
			System.out.println(entity.getProperty("password"));
			System.out.println(entity.getProperty("mail"));
		}
	}
	
	public UsuarioDTO getUserByName(UsuarioDTO usuarioDTO)
	{
		UsuarioDTO usuarioEncontrado = null;
		
		try
		{
			DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
			Query query = new Query("Usuario");
			List<Entity> usuarios = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
			
			for (Entity entity : usuarios) 
			{
				if(entity.getProperty("nombre").toString().equals(usuarioDTO.getNombre()))
				{
					usuarioEncontrado = new UsuarioDTO();
					usuarioEncontrado.setIdUsuario((int)entity.getKey().getId());
					usuarioEncontrado.setNombre(entity.getProperty("nombre").toString());
					usuarioEncontrado.setPassword(entity.getProperty("password").toString());
					usuarioEncontrado.setMail(entity.getProperty("mail").toString());
				}
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return usuarioEncontrado;
	}
}
