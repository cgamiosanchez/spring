package edu.practica.entity;

import java.math.BigDecimal;
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
@Table(name="orden")
public class OrdenEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence-orden")
	@SequenceGenerator(name = "sequence-orden",sequenceName = "CountOrdenBy", allocationSize=1)
	private long id;
	private BigDecimal monto;
	private String moneda;
	private String estado;
	@ManyToOne
    @JoinColumn(name="idsucursal")
    private SucursalEntity sucursal;
	@Column(name="FECHA_PAGO")
	private Date fechaPago;
	
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

	public SucursalEntity getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "SucursalEntity [id=" + id + ", monto=" + monto + ", moneda=" + moneda + ", sucursal=" + sucursal + ", estado=" + estado + ", fechaPago="
				+ fechaPago + "]";
	}
	
}
