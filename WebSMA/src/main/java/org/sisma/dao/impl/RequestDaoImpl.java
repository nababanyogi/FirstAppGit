package org.sisma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.sisma.dao.RequestDao;
import org.sisma.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequestDaoImpl implements RequestDao {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	@Override
	public List<Request> getAllRequest() {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from Request", Request.class).getResultList();
	}

	@Override
	public Request saveOrUpdate(Request request) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Request saved = em.merge(request);
		em.getTransaction().commit();
		return saved;
	}
	@Override
	public List<Request> getAllRequestByStatus(String status) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from Request where status='"+status+"'", Request.class).getResultList();
	}
	@Override
	public void updateStatusRequestById(int id) {
		Request request = findRequestById(id);
		request.setStatus("YES");
		request = saveOrUpdate(request);		
	}
	@Override
	public Request findRequestById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		return em.find(Request.class, id);
	}
	@Override
	public List<Request> getAllRequestByIdMahasiswa(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.createQuery("from Request where id_mahasiswa="+id, Request.class).getResultList();
	}
	

}
