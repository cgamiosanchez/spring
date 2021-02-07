package edu.practica.domain;

import java.math.BigDecimal;

public class OrdenIn {

	private long id;
	private BigDecimal monto;
	private String moneda;
	private String estado;
	private long idsucursal;
	public OrdenIn() {
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
	@Override
	public String toString() {
		return "OrdenIn [id=" + id + ", monto=" + monto + ", moneda=" + moneda + ", estado=" + estado + ", idsucursal="
				+ idsucursal + "]";
	}
	
}
