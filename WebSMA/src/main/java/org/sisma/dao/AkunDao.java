package org.sisma.dao;

import java.util.List;

import org.sisma.models.Akun;

public interface AkunDao {
	List<Akun> getAllAkun();
	Akun saveOrUpdate(Akun akun);
	Akun login(String username, String password);
}
