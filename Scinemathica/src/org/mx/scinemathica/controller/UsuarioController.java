package org.mx.scinemathica.controller;

import java.io.PrintStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mx.scinemathica.dao.UsuariosDAO;
import org.mx.scinemathica.dto.UsuarioDTO;
import org.mx.scinemathica.service.UsuarioService;
import org.mx.scinemathica.util.Utilidades;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author ilaurrabaquio
 *
 */

@Controller
public class UsuarioController
{
	
  @RequestMapping(value="/index.htm")
  public ModelAndView index(HttpServletRequest request , HttpServletResponse response)
  {
	  ModelAndView mv = new ModelAndView("index");
	  System.out.println("entro controller index redirect");
	  return mv;
  }
	
  @RequestMapping(value="/inicio.htm")
  public ModelAndView incio(HttpServletRequest request, HttpServletResponse response)
  {
    ModelAndView mv = new ModelAndView("inicio");
    
    System.out.println("entro Controller inicio");
    
    mv.addObject("mensaje", "entro a controller spring y esto es login");
    return mv;
  }
  
  
  @RequestMapping(value="/registro.htm")
  public ModelAndView registro(HttpServletRequest request, HttpServletResponse response)
  {
	  ModelAndView mv = new ModelAndView("registro");
	  System.out.println("entro Controller registro");
//	  mv.addObject("respuesta","");
//	  mv.addObject("mensaje", "entro a controller spring y esto es registro");
	  return mv;
  }
  
  @RequestMapping(value="/registrarUsuario.htm")
  public ModelAndView registrarUsuario(HttpServletRequest request,HttpServletResponse response)
  {
	  System.out.println("+++++++++ entro registrarUsuario ++++++++++");
	  
	  ModelAndView mv = new ModelAndView("inicio");
	  
	  String passEcriptado = null;
	  String respuesta = null;
	  
	  String nombreUsuario = request.getParameter("nombreUsuario");
	  String password =  request.getParameter("password");
	  String mail = request.getParameter("mail");
	  
	  passEcriptado = Utilidades.codificaPassword(password);
	  
	  UsuarioDTO usuarioDTO = new UsuarioDTO();
	  usuarioDTO.setNombre(nombreUsuario);
	  usuarioDTO.setPassword(passEcriptado);
	  usuarioDTO.setMail(mail);
    
	  String context = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/org/mx/resources/Connection.properties");
	  
	  UsuarioService usuarioService = new UsuarioService();
	  respuesta = usuarioService.registraUsuario(usuarioDTO,context);

//    usuariosDAO.obtieneUsuarios();
	  
	  mv.addObject("respuesta",respuesta);
	  
	  System.out.println("VALOREs+++ " + nombreUsuario + password + mail + respuesta);
	  
	  return mv;
  } 
  
  @RequestMapping("/inicioLogin.htm")
  public ModelAndView inicioLogin(HttpServletRequest request ,HttpServletResponse response)
  {
	  ModelAndView mv = new ModelAndView("login");
	  //System.out.println("Entro a inicio Login");
	  return mv;
  }
  
  @RequestMapping("/login.htm")
  public ModelAndView login(HttpServletRequest request , HttpServletResponse response)
  {
	  ModelAndView mv;
	  int respuestaLogin;
	  
	  System.out.println("+++++ login-Controller +++++");
	  
	  String nombreUsuario = request.getParameter("nombreUsuario");
	  String password =  request.getParameter("password");
	  
	  UsuarioDTO usuarioDTO = new UsuarioDTO();
	  usuarioDTO.setNombre(nombreUsuario);
	  usuarioDTO.setPassword(password);
	  
	  UsuarioService usuarioService = new UsuarioService();
	  respuestaLogin = usuarioService.validaLogin(usuarioDTO);
	  
	  if(respuestaLogin == 4)
	  {
		  mv = new ModelAndView("menu");
		  request.getSession().setAttribute("usuarioSession",(Object)usuarioDTO);
		  
	  }else if(respuestaLogin == 5)
	  {
		  mv = new ModelAndView("login");
		  mv.addObject("respuesta","Usuario No existe");
	  }else
	  {
		  mv = new ModelAndView("login");
		  mv.addObject("respuesta","Contraseña Incorrecta");
		  mv.addObject("nombreUsuario",nombreUsuario);
	  }
	  
	  return mv;
  }
  
  @RequestMapping(value="/salir.htm")
  public ModelAndView salir(HttpServletRequest request,HttpServletResponse response)
  {
	  ModelAndView mv = new ModelAndView("index");
	  request.getSession().setAttribute("usuarioSession",null);
	  return mv;
  }
}