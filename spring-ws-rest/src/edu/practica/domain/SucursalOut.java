package edu.practica.domain;

public class SucursalOut {

	private long id;
	private String nombre;
	private String descripcion;
	private long idbanco;
	private String fecharegistro;
	public SucursalOut() {
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
	public String getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	@Override
	public String toString() {
		return "SucursalOut [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecharegistro=" + fecharegistro + ", idbanco=" + idbanco
				+ "]";
	}
}
