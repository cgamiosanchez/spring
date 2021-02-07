package edu.practica.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.practica.domain.BancoIn;
import edu.practica.domain.BancoOut;
import edu.practica.domain.OrdenIn;
import edu.practica.domain.OrdenMonedaIn;
import edu.practica.domain.OrdenOut;
import edu.practica.domain.SucursalIn;
import edu.practica.domain.SucursalOut;
import edu.practica.entity.BancoEntity;
import edu.practica.entity.OrdenEntity;
import edu.practica.entity.SucursalEntity;
import edu.practica.repository.BancoRepository;
import edu.practica.service.BancoLogicService;

@Service
public class BancoLogicServiceImpl implements BancoLogicService{

	@Autowired
	BancoRepository bancoRepository;
	
	@Override
	public BancoOut getBanco(long id) {
		BancoEntity o = bancoRepository.getOne(id);
		BancoOut out = new BancoOut();
		out.setId(o.getId());
		out.setNombre(o.getNombre());
		out.setDireccion(o.getDescripcion());
		out.setFechaRegistro(o.getFechaRegistro());
		System.out.println("id: "+o.getId());
		System.out.println("nombre: "+o.getNombre());
		return out;
	}
	
	@Override
	public String saveBanco(BancoIn in) {
		BancoEntity be = new BancoEntity();
		be.setDescripcion(in.getDescripcion());
		be.setFechaRegistro(new Date());
		be.setNombre(in.getNombre());
		bancoRepository.saveOne(be);
		return "OK BANCO";
	}
	
	@Override
	public SucursalOut getSucursal(long id) {
		SucursalEntity o = bancoRepository.getOneSucursal(id);
		SucursalOut out = new SucursalOut();
		out.setId(o.getId());
		out.setNombre(o.getNombre());
		out.setDescripcion(o.getDescripcion());
		out.setIdbanco(o.getBanco().getId());
		out.setFecharegistro(new SimpleDateFormat("MM-dd-yyyy").format(o.getFechaRegistro()));
		System.out.println("id: "+o.getId());
		System.out.println("nombre: "+o.getNombre());
		return out;
	}
	
	@Override
	public String saveSucursal(SucursalIn in) {
		BancoEntity o = bancoRepository.getOne(in.getIdbanco());
		SucursalEntity be = new SucursalEntity();
		be.setDescripcion(in.getDescripcion());
		be.setFechaRegistro(new Date());
		be.setNombre(in.getNombre());
		be.setBanco(o);
		bancoRepository.saveSucursal(be);
		return "OK SUCURSAL";
	}

	@Override
	public OrdenOut getOrden(long id) {
		OrdenEntity o = bancoRepository.getOneOrden(id);
		OrdenOut out = new OrdenOut();
		out.setId(o.getId());
		out.setMoneda(o.getMoneda());
		out.setEstado(o.getEstado());
		out.setMonto(o.getMonto());
		out.setIdsucursal(o.getSucursal().getId());
		out.setFecharegistro(new SimpleDateFormat("MM-dd-yyyy").format(o.getFechaPago()));
		System.out.println("id: "+o.getId());
		System.out.println("monto: "+o.getMonto());
		return out;
	}
	
	@Override
	public String saveOrden(OrdenIn in) {
		SucursalEntity o = bancoRepository.getOneSucursal(in.getIdsucursal());
		OrdenEntity be = new OrdenEntity();
		be.setMonto(in.getMonto());
		be.setFechaPago(new Date());
		be.setMoneda(in.getMoneda());
		be.setEstado(in.getEstado());
		be.setSucursal(o);
		bancoRepository.saveOrden(be);
		return "OK ORDEN";
	}
	
	@Override
	public List<SucursalOut> listarSucursal(long idbanco) {
		List<SucursalOut> lista = new ArrayList<>();
		List<SucursalEntity> listaEntity = bancoRepository.listarSucursal(idbanco);
		for (SucursalEntity e : listaEntity) {
			SucursalOut out = new SucursalOut();
			out.setDescripcion(e.getDescripcion());
			out.setId(e.getId());
			out.setNombre(e.getNombre());
			out.setIdbanco(idbanco);
			lista.add(out);
		}
		return lista;
	}

	@Override
	public List<OrdenOut> listarOrden(OrdenMonedaIn in) {
		List<OrdenOut> lista = new ArrayList<>();
		List<OrdenEntity> listaEntity = bancoRepository.listarOrdenBySucursalMoneda(in.getIdsucursal(), in.getMoneda());
		for (OrdenEntity o : listaEntity) {
			OrdenOut out = new OrdenOut();
			out.setId(o.getId());
			out.setMoneda(o.getMoneda());
			out.setEstado(o.getEstado());
			out.setMonto(o.getMonto());
			out.setIdsucursal(in.getIdsucursal());
			out.setFecharegistro(new SimpleDateFormat("MM-dd-yyyy").format(o.getFechaPago()));
			lista.add(out);
		}
		return lista;
	}
}
