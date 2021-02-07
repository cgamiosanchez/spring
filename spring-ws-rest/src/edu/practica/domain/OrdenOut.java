package edu.practica.domain;

import java.math.BigDecimal;

public class OrdenOut {

	private long id;
	private BigDecimal monto;
	private String moneda;
	private String estado;
	private long idsucursal;
	private String fecharegistro;
	public OrdenOut() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getIdsucursal() {
		return idsucursal;
	}
	public void setIdsucursal(long idsucursal) {
		this.idsucursal = idsucursal;
	}
	public String getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	@Override
	public String toString() {
		return "OrdenOut [id=" + id + ", monto=" + monto + ", moneda=" + moneda + ", estado=" + estado + ", idsucursal="
				+ idsucursal + ", fecharegistro=" + fecharegistro + "]";
	}
	
}
