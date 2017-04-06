package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.AkunDao;
import org.sisma.models.Akun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AkunDaoImpl implements AkunDao {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Akun> getAllAkun() {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from Akun", Akun.class).getResultList();
	}

	@Override
	public Akun login(String username, String password) {
		List<Akun> allAkun = getAllAkun();
		Akun akunFind = null;		
		for (Akun akun : allAkun) {
			if(akun.getUsername().equals(username) && akun.getPassword().equals(password)){
				akunFind = akun;
				break;
			}
		}
		return akunFind;
	}

	@Override
	public Akun saveOrUpdate(Akun akun) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Akun saved = em.merge(akun);
		em.getTransaction().commit();
		return saved;
	}

}
