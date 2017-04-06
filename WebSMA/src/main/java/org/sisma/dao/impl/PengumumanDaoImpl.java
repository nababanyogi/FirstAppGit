package org.sisma.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import org.sisma.dao.PengumumanDao;
import org.sisma.models.Pengumuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PengumumanDaoImpl implements PengumumanDao{

	
	private EntityManagerFactory entityManagerFactory;
	
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}



	@Override
	public Pengumuman saveOrUpdate(Pengumuman pengumuman) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Pengumuman saved = em.merge(pengumuman);
		em.getTransaction().commit();
		return saved;
	}

}
