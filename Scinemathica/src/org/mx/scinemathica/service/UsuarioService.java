package org.mx.scinemathica.service;

import java.util.Properties;

import org.mx.scinemathica.dao.UsuariosDAO;
import org.mx.scinemathica.dto.UsuarioDTO;
import org.mx.scinemathica.util.Constantes;
import org.mx.scinemathica.util.Utilidades;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ilaurrabaquio
 *
 */

@Service
public class UsuarioService 
{
	public String registraUsuario (UsuarioDTO usuarioDTO,String context)
	{
	  System.out.println("++++++++Entro Usuario Service++++++");
	  
	  UsuariosDAO usuariosDAO = new UsuariosDAO();
	  UsuarioDTO usuario = usuariosDAO.getUserByName(usuarioDTO);
	  String respuestaService = null;
	  
	  if(usuario == null)
	  {
		  respuestaService = usuariosDAO.agregaUsuario(usuarioDTO);
	  
		  Properties p = new Properties();
		  p = Utilidades.leerArchivo(context);
		
		  MailService mailService = new MailService();
		  mailService.enviaCorreoService(p.getProperty("mensaje.welcome.subject"), p.getProperty("mensaje.welcome"), context,usuarioDTO.getMail());
	  }else
	  {
		  respuestaService = Constantes.usuarioExistente;
	  }
	  return respuestaService;
	}
	
	public int validaLogin(UsuarioDTO usuarioDTO)
	{
		int respuesta;
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		UsuarioDTO usuario = usuariosDAO.getUserByName(usuarioDTO);
		
		if(usuario == null)
		{
			respuesta = Constantes.usuarioNoExiste; 
		}else
		{
			if(usuario.getPassword().equals(Utilidades.codificaPassword(usuarioDTO.getPassword())))
			{
				respuesta = Constantes.datosCorrectos;
			}else
			{
				respuesta = Constantes.contraseñaIncorect;
			}
		}
		
		return respuesta;
	}
}
