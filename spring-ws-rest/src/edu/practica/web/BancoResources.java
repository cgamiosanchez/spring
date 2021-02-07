package edu.practica.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import edu.practica.domain.BancoOut;
import edu.practica.domain.OrdenMonedaIn;
import edu.practica.domain.OrdenOut;
import edu.practica.service.BancoLogicService;


@Service
@Path("/banco")
public class BancoResources {

	@Autowired
	BancoLogicService bancoLogicService;
	
	@GET
	@Path("/get/{idBank}")
	@Produces(MediaType.APPLICATION_JSON)
	public BancoOut getBancoById(@PathParam("idBank") long id) {
		return bancoLogicService.getBanco(id);
	}
	
	@POST
	@Path("/ordenes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrdenOut> getBancoById(@RequestBody OrdenMonedaIn in) {
		return bancoLogicService.listarOrden(in);
	}
	
}