package edu.practica.domain;

public class OrdenMonedaIn {

	private long idsucursal;
	private String moneda;
	public OrdenMonedaIn() {
	}
	public long getIdsucursal() {
		return idsucursal;
	}
	public void setIdsucursal(long idsucursal) {
		this.idsucursal = idsucursal;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	@Override
	public String toString() {
		return "OrdenMonedaIn [idsucursal=" + idsucursal + ", moneda=" + moneda + "]";
	}
	
}
