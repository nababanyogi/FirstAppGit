package org.sisma.dao;

import java.util.List;

import org.sisma.models.Siswa;


public interface SiswaDao {

    List <Siswa> listSiswa();
    
    Siswa saveOrUpdate(Siswa siswa);
    Siswa getIdSiswa(String id);
    void hapusSiswa (String id);	
	List<Siswa> getAllRequestByStatus(String status); 
}


