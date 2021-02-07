package edu.practica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sucursal")
public class SucursalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence-sucursal")
	@SequenceGenerator(name = "sequence-sucursal",sequenceName = "CountSucursalBy", allocationSize=1)
	private long id;
	private String nombre;
	private String descripcion;
	@ManyToOne
    @JoinColumn(name="idbanco")
    private BancoEntity banco;
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public BancoEntity getBanco() {
		return banco;
	}
	public void setBanco(BancoEntity banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return "SucursalEntity [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", banco=" + banco + ", fechaRegistro="
				+ fechaRegistro + "]";
	}
	
}
