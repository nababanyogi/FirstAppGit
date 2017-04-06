package org.sisma.dao;

import java.util.List;

import org.sisma.models.Guru;




public interface GuruDao {

    List <Guru> listGuru();
    Guru saveOrUpdate(Guru guru);
    Guru getIdGuru(String id);
    void hapusGuru (String id);
}


