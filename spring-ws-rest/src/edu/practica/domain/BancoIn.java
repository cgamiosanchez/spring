package edu.practica.domain;

public class BancoIn {
	private long id;
	private String nombre;
	private String descripcion;
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
	@Override
	public String toString() {
		return "BancoIn [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
