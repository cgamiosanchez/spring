package edu.practica.service;

import java.util.List;

import edu.practica.domain.BancoIn;
import edu.practica.domain.BancoOut;
import edu.practica.domain.OrdenIn;
import edu.practica.domain.OrdenMonedaIn;
import edu.practica.domain.OrdenOut;
import edu.practica.domain.SucursalIn;
import edu.practica.domain.SucursalOut;

public interface BancoLogicService {

	public String saveBanco(BancoIn in);

	public BancoOut getBanco(long id);

	List<SucursalOut> listarSucursal(long idbanco);

	SucursalOut getSucursal(long id);

	String saveSucursal(SucursalIn in);

	OrdenOut getOrden(long id);

	String saveOrden(OrdenIn in);

	List<OrdenOut> listarOrden(OrdenMonedaIn in);
}
