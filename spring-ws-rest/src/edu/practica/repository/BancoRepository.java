package edu.practica.repository;

import java.util.List;

import edu.practica.entity.BancoEntity;
import edu.practica.entity.OrdenEntity;
import edu.practica.entity.SucursalEntity;

public interface BancoRepository {

	public BancoEntity getOne(Long id);

	void saveOne(BancoEntity newin);

	SucursalEntity getOneSucursal(Long id);
	
	void saveSucursal(SucursalEntity newin);

	List<SucursalEntity> listarSucursal(Long id);

	List<OrdenEntity> listarOrdenBySucursalMoneda(Long idsucursal, String moneda);

	OrdenEntity getOneOrden(Long id);

	void saveOrden(OrdenEntity newin);
}
