package org.mx.scinemathica.service;

import java.util.List;

import org.mx.scinemathica.dao.PeliculaDAO;
import org.mx.scinemathica.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService 
{
	public boolean agregaMovieVal(PeliculaDTO peliculaDTO)
	{
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		
		return peliculaDAO.AgregaPelicula(peliculaDTO);
	}
	
	public List<PeliculaDTO> peliculasById(String usuario)
	{
		PeliculaDAO peliculaDao = new PeliculaDAO();
		List<PeliculaDTO> listaPeliculas = peliculaDao.obtienePeliculaByUser(usuario);
		return listaPeliculas;
	}
	
	public void borrar(String peliculaBorrar)
	{
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		peliculaDAO.borrarPelicula(peliculaBorrar);
	}
}
