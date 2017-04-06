package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.GuruDao;
import org.sisma.models.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuruDaoImpl implements GuruDao{
	private EntityManagerFactory emf;
	
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
	@Override
	public List<Guru> listGuru() {
		EntityManager em  = emf.createEntityManager();
		return em.createQuery("from guru", Guru.class).getResultList();
	}
	
	@Override
	public Guru saveOrUpdate(Guru guru) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		Guru saved = em.merge(guru);
		em.getTransaction().commit();
		return saved;
	}

	
	
	@Override
	public Guru getIdGuru(String id) {
		EntityManager em  = emf.createEntityManager();
		return em.find(Guru.class, id);
	}

	
	@Override
	public void hapusGuru(String id) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Guru.class, id));
		em.getTransaction().commit(); 		
	}




}
