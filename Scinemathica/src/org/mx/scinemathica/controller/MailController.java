package org.mx.scinemathica.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mx.scinemathica.dto.UsuarioDTO;
import org.mx.scinemathica.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController 
{
	@RequestMapping(value="/contactoInico.htm")
	public ModelAndView contactoInico(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv;
		UsuarioDTO usuarioDTO = (UsuarioDTO)request.getSession().getAttribute("usuarioSession");
		
		if(usuarioDTO == null)
		{
			mv = new ModelAndView("index");
			return mv;
		}
		
		mv = new ModelAndView("contacto");
		
		return mv;
	}
	
	@RequestMapping(value="/enviaCorreo.htm")
	public ModelAndView enviaCorreo(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("+++++enviaCorreo Controller+++++");
		ModelAndView mv = new ModelAndView("contacto");
		
		String subject = request.getParameter("subject");
		String mensaje = request.getParameter("mensaje");
		String context = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/org/mx/resources/Connection.properties");
		
		MailService mailService = new MailService();
		String respuesta = mailService.enviaCorreoService(subject, mensaje,context);
		
		mv.addObject("respuestaCorreo", respuesta);
		
		return mv;
	}
}
