<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Scinemathica</title>

<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="../css/css_pirobox/white/style.css" media="screen" title="shadow" rel="stylesheet" type="text/css" />
<link href="../css/css_pirobox/white/style.css" media="screen" title="shadow" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/piroBox.1_2.js"></script>

<script type="text/javascript">

	var json;
	
	function goInicio()
	{
		$("#mainContent").load("index.htm",function(){$("#inicioBotones").hide();});
	}
	
	function goRecomendar()
	{
		$("#mainContent").load("agregarPeliculaInicio.htm",function(){});
	}
	
	function goCatalogo()
	{
		$("#mainContent").load("mostrar.htm",function()
		{
			$.getJSON("generaJsonPeliculas.htm",function(data)
			{
				generaLista(data);
			});
		});		
	}

	function goMisPeliculas()
	{
		$("#mainContent").load("peliculasByUserInicio.htm",function()
		{
			$.getJSON("generaJsonPropias.htm",function(data)
			{
				generaListaPropias(data);
			});
		});
	}
	
	function goContacto()
	{
		$("#mainContent").load("contactoInico.htm",function(){});
	}
	
	function goSalir()
	{
		$("#mainContent").load("salir.htm",function(){$("#inicioBotones").hide();});
	}
</script>

<script type="text/javascript">

$(document).ready(function() {

	$().piroBox({

			my_speed: 600, //animation speed

			bg_alpha: 0.5, //background opacity

			radius: 4, //caption rounded corner

			scrollImage : false, // true == image follows the page, false == image remains in the same open position

			pirobox_next : 'piro_next', // Nav buttons -> piro_next == inside piroBox , piro_next_out == outside piroBox

			pirobox_prev : 'piro_prev',// Nav buttons -> piro_prev == inside piroBox , piro_prev_out == outside piroBox

			close_all : '.piro_close',// add class .piro_overlay(with comma)if you want overlay click close piroBox

			slideShow : 'slideshow', // just delete slideshow between '' if you don't want it.

			slideSpeed : 4 //slideshow duration in seconds(3 to 6 Recommended)

	});

});

</script>

<script type="text/javascript">

	$(document).ready(function(){
		$("#mainContent").load("inicio.htm",function(){$("#inicioBotones").hide();});
	});
	
</script>

<!--////// END  \\\\\\\-->


</head>
<body>
<div id="templatemo_wrapper">

	<div id="templatmeo_header">
    
        <div id="templatemo_menu">
            <ul>
 				<!--<li><a href="#home">Inico</a></li>-->   
                <li><a href="#catalogo" onclick="goCatalogo();">Catalogo</a></li>
                <li><a href="#recomendar" onclick="goRecomendar();">Recomendar</a></li>
				<li><a href="#MisPelis" onclick="goMisPeliculas();">Mis Pelis</a></li>
                <li><a href="#contacto" onclick="goContacto();">Contacto</a></li>	
				<li class="last"><a href="#" onclick="goSalir();">Salir</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
    	<div id="site_title">
        	<h1><a href="#">Scinemathica<span>Compartiendo Cine</span></a></h1>
            <div id="social_box">
            	<a href="https://www.facebook.com/groups/cinemathica" target="_blank"><img src="../images/facebook.jpg" alt="facebook" /></a>
            </div>
        </div>
    </div> <!-- end of header -->
    
    <div id="templatemo_main">
	        <div class="content_box" id="mainContent"><div id="home"></div>
        	<div class="content_box_content">            
                <h2>Scinemathica</h2>
                <div class="cleaner h30">
				<div id="contact_form">
                    </div> 
                </div>
                <div class="cleaner h30"></div>
                <div class="cleaner"></div>
            </div> <!-- end of content box content -->
        </div> <!-- end of a content box -->
        <div id="aboutus"></div> 
    
    <div id="templatemo_footer">
    
        Copyright © 2013 <a href="#">Scinemathica</a> | Designed by <a href="https://www.facebook.com/isaac.laurrabaquio" target="_blank">Isaac Laurrabaquio</a>
    
    </div> <!-- end of templatemo_footer -->

</div> <!-- end of wrapper -->

</body>
</html>