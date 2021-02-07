package edu.practica.domain;

public class SucursalIn {

	private long id;
	private String nombre;
	private String descripcion;
	private long idbanco;
	public SucursalIn() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getIdbanco() {
		return idbanco;
	}
	public void setIdbanco(long idbanco) {
		this.idbanco = idbanco;
	}
	@Override
	public String toString() {
		return "SucursalIn [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idbanco=" + idbanco
				+ "]";
	}
	
}
