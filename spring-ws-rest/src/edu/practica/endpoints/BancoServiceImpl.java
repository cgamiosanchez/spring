package edu.practica.endpoints;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.practica.domain.BancoIn;
import edu.practica.domain.OrdenIn;
import edu.practica.domain.SucursalIn;
import edu.practica.domain.SucursalOut;
import edu.practica.service.BancoLogicService;

@Service
@WebService
public class BancoServiceImpl {

	@Autowired
	BancoLogicService bancoLogicService;
	
	@WebMethod
	public String createBanco(BancoIn in) {
		return bancoLogicService.saveBanco(in);
	}
	
	@WebMethod
	public String createSucursal(SucursalIn in) {
		return bancoLogicService.saveSucursal(in);
	}
	
	@WebMethod
	public String createOrden(OrdenIn in) {
		return bancoLogicService.saveOrden(in);
	}
	
	@WebMethod
	public List<SucursalOut> lista(Long idbanco) {
		return bancoLogicService.listarSucursal(idbanco);
	}
}
