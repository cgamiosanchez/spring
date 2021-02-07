package edu.practica.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.practica.entity.BancoEntity;
import edu.practica.entity.OrdenEntity;
import edu.practica.entity.SucursalEntity;

@Repository
public class BancoRepositoryImpl implements BancoRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public BancoEntity getOne(Long id) {
		return em.find(BancoEntity.class, id);
	}

	@Override
	@Transactional
	public void saveOne(BancoEntity newin) {
		em.persist(newin);
	}
	
	@Override
	public SucursalEntity getOneSucursal(Long id) {
		return em.find(SucursalEntity.class, id);
	}

	@Override
	@Transactional
	public void saveSucursal(SucursalEntity newin) {
		em.persist(newin);
	}
	
	@Override
	public OrdenEntity getOneOrden(Long id) {
		return em.find(OrdenEntity.class, id);
	}

	@Override
	@Transactional
	public void saveOrden(OrdenEntity newin) {
		em.persist(newin);
	}
	
	@Override
	public List<SucursalEntity> listarSucursal(Long id) {
		String query ="select e from SucursalEntity e where e.banco.id = :idbanco";
		List<SucursalEntity> lista = em.createQuery(query,SucursalEntity.class)
				.setParameter("idbanco", id)
				.getResultList();
		return lista;
	}
	
	@Override
	public List<OrdenEntity> listarOrdenBySucursalMoneda(Long idsucursal, String moneda) {
		String query ="select e from OrdenEntity e where e.sucursal.id = :idsucursal and e.moneda = :idmoneda";
		List<OrdenEntity> lista = em.createQuery(query,OrdenEntity.class)
				.setParameter("idsucursal", idsucursal)
				.setParameter("idmoneda", moneda)
				.getResultList();
		return lista;
	}
}
