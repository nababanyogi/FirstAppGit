package org.sisma.dao;

import java.util.List;

import org.sisma.models.Request;

public interface RequestDao {
	List<Request> getAllRequest();
	List<Request> getAllRequestByIdMahasiswa(int id);
	List<Request> getAllRequestByStatus(String status);
	Request saveOrUpdate(Request request);
	Request findRequestById(int id);
	void updateStatusRequestById(int id);

}
