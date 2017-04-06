package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.MataPelajaranDao;
import org.sisma.models.MataPelajaran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MataPelajaranDaoImpl implements MataPelajaranDao{
	private EntityManagerFactory emf;
	
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
	@Override
	public List<MataPelajaran> listMataPelajaran() {
		EntityManager em  = emf.createEntityManager();
		return em.createQuery("from matapelajaran", MataPelajaran.class).getResultList();
	}
	
	@Override
	public MataPelajaran saveOrUpdate(MataPelajaran mataPelajaran) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		MataPelajaran saved = em.merge(mataPelajaran);
		em.getTransaction().commit();
		return saved;
	}
		
	@Override
	public MataPelajaran getIdMataPelajaran(Integer id) {
		EntityManager em  = emf.createEntityManager();
		return em.find(MataPelajaran.class, id);
	}

	
	@Override
	public void hapusMataPelajaran(Integer id) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(MataPelajaran.class, id));
		em.getTransaction().commit(); 		
	}




}
