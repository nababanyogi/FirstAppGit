package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.SiswaDao;
import org.sisma.models.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiswaDaoImpl implements SiswaDao{
	private EntityManagerFactory emf;
	
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
	@Override
	public List<Siswa> listSiswa() {
		EntityManager em  = emf.createEntityManager();
		return em.createQuery("from siswa", Siswa.class).getResultList();
	}
	
	@Override
	public Siswa saveOrUpdate(Siswa siswa) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		Siswa saved = em.merge(siswa);
		em.getTransaction().commit();
		return saved;
	}

	
	
	@Override
	public Siswa getIdSiswa(String id) {
		EntityManager em  = emf.createEntityManager();
		return em.find(Siswa.class, id);
	}

	
	@Override
	public void hapusSiswa(String id) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Siswa.class, id));
		em.getTransaction().commit(); 		
	}


	@Override
	public List<Siswa> getAllRequestByStatus(String status) {
//		EntityManager em = entityManagerFactory.createEntityManager();
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from siswa where status='"+status+"'", Siswa.class).getResultList();
	}
		

}
