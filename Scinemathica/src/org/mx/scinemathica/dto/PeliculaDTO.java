package org.mx.scinemathica.dto;

import java.io.Serializable;

public class PeliculaDTO implements Serializable 
{
	private int idPelicula;
	private String nombre;
	private String descripcion;
	private String linkTrailer;
	private String linkDescarga;
	private String usuario;
	private String genero;
	
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLinkTrailer() {
		return linkTrailer;
	}
	public void setLinkTrailer(String linkTrailer) {
		this.linkTrailer = linkTrailer;
	}
	public String getLinkDescarga() {
		return linkDescarga;
	}
	public void setLinkDescarga(String linkDescarga) {
		this.linkDescarga = linkDescarga;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
