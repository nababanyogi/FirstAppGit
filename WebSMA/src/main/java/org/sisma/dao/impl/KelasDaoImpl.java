package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.KelasDao;
import org.sisma.models.Kelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KelasDaoImpl implements KelasDao{
	private EntityManagerFactory emf;
	
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
	@Override
	public List<Kelas> listKelas() {
		EntityManager em  = emf.createEntityManager();
		return em.createQuery("from kelas", Kelas.class).getResultList();
	}
	
	@Override
	public Kelas saveOrUpdate(Kelas kelas) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		Kelas saved = em.merge(kelas);
		em.getTransaction().commit();
		return saved;
	}

	
	
	@Override
	public Kelas getIdKelas(Integer id) {
		EntityManager em  = emf.createEntityManager();
		return em.find(Kelas.class, id);
	}

	
	@Override
	public void hapusKelas(Integer id) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Kelas.class, id));
		em.getTransaction().commit(); 		
	}




}
