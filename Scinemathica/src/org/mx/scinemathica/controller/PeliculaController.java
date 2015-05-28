package org.mx.scinemathica.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.mx.scinemathica.dao.PeliculaDAO;
import org.mx.scinemathica.dto.PeliculaDTO;
import org.mx.scinemathica.dto.UsuarioDTO;
import org.mx.scinemathica.service.PeliculaService;
import org.mx.scinemathica.util.Utilidades;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Response;

@Controller
public class PeliculaController 
{
	@RequestMapping(value="/agregarPeliculaInicio")
	public ModelAndView agregarPeliculaInicio(HttpServletRequest request , HttpServletResponse response)
	{
		ModelAndView mv;
		
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			mv = new ModelAndView("index");
			return mv;
		}
		
		mv = new ModelAndView("agregaPelicula");
		
		return mv;
	}
	
	@RequestMapping(value="/agregarPelicula.htm")
	public ModelAndView agregarPelicula(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv;
		
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			mv = new ModelAndView("index");
			return mv;
		}
		
		mv = new ModelAndView("menu");
		
		PeliculaService peliculaService = new PeliculaService();
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		peliculaDTO.setNombre(request.getParameter("nombre"));
		peliculaDTO.setDescripcion(request.getParameter("descripcion"));
		peliculaDTO.setLinkDescarga(request.getParameter("linkDescarga"));
		peliculaDTO.setUsuario(usuarioDTO.getNombre());
		peliculaDTO.setGenero(request.getParameter("ComboGenero"));
		
		String linkTrailer = request.getParameter("linkTrailer");
		
		//validacion youtubeLink
		peliculaDTO.setLinkTrailer(Utilidades.convierteYoutubeLink(linkTrailer));
		
		peliculaService.agregaMovieVal(peliculaDTO);
		
		return mv;
	}
	
	
	@RequestMapping(value="/mostrar.htm")
	public ModelAndView mostrar(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv;
		
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			mv = new ModelAndView("index");
			return mv;
		}
		
		mv = new ModelAndView("mostrar");
		
		
		return mv;
	}
	
	@RequestMapping(value="/generaJsonPeliculas.htm")
	public ModelAndView generaJsonPeliculas(HttpServletRequest request, HttpServletResponse response)
	{

		JSONObject json = new JSONObject();
		JSONObject peliculasJson = new JSONObject();
		OutputStream out;
		
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		
		List<PeliculaDTO> listaPeliculas = peliculaDAO.obtienePeliculas();
		
		for (PeliculaDTO peliculaDTO : listaPeliculas) 
		{
			json.put("nombre", peliculaDTO.getNombre());
			json.put("descripcion", peliculaDTO.getDescripcion());
			json.put("linkTrailer", peliculaDTO.getLinkTrailer());
			json.put("linkDescarga",peliculaDTO.getLinkDescarga());
			json.put("genero",peliculaDTO.getGenero());
			json.put("usuario",peliculaDTO.getUsuario());
			
			//peliculasJson.put("peliculasJson",json);
			peliculasJson.accumulate("peliculasJson", json);
		}
		
		try
		{
			out = (OutputStream) response.getOutputStream();
			out.write(peliculasJson.toString().getBytes("UTF-8"));
			out.close();
			//System.out.println(peliculasJson.size() + "++" +peliculasJson);

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/generaJsonPropias.htm")
	public ModelAndView generaJsonPropias(HttpServletRequest request , HttpServletResponse response)
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		JSONObject json = new JSONObject();
		JSONObject propiasJson = new JSONObject();
		OutputStream out;
		
		String usuario = usuarioDTO.getNombre();;
		
		PeliculaService peliculaService = new PeliculaService();
		List<PeliculaDTO> listaPeliculas = peliculaService.peliculasById(usuario);
		
		for (PeliculaDTO peliculaDTO : listaPeliculas) 
		{
			json.put("nombre", peliculaDTO.getNombre());
			json.put("descripcion", peliculaDTO.getDescripcion());
			json.put("linkTrailer", peliculaDTO.getLinkTrailer());
			json.put("linkDescarga", peliculaDTO.getLinkDescarga());
			json.put("genero", peliculaDTO.getGenero());
			json.put("usuario", peliculaDTO.getUsuario());
			
			propiasJson.accumulate("propiasJson",json);
		}
		
		try
		{
			out = (OutputStream) response.getOutputStream();
			out.write(propiasJson.toString().getBytes("UTF-8"));
			out.close();
			//System.out.println(propiasJson.size() + "++" + propiasJson);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/peliculasByUserInicio.htm")
	public ModelAndView peliculasByUserInicio(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv;
		
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			mv = new ModelAndView("index");
			return mv;
		}
		
		mv = new ModelAndView("peliculasPropias");
		
		return mv;
	}
	
	@RequestMapping(value="/borrar.htm")
	public ModelAndView borrar(HttpServletRequest request,HttpServletResponse response)
	{	
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		
		String peliculaBorrar = request.getParameter("peliculaBorrar");
		PeliculaService peliculaService = new PeliculaService();
		peliculaService.borrar(peliculaBorrar);
		
		return null;
	}
}
