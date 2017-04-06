package org.sisma.dao;

import java.util.List;

import org.sisma.models.Kelas;




public interface KelasDao {

    List <Kelas> listKelas();
    Kelas saveOrUpdate(Kelas kelas);
    Kelas getIdKelas(Integer id);
    void hapusKelas (Integer id);
}


