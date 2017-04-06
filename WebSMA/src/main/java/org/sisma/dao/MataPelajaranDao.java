package org.sisma.dao;

import java.util.List;

import org.sisma.models.MataPelajaran;




public interface MataPelajaranDao {

    List <MataPelajaran> listMataPelajaran();
    MataPelajaran saveOrUpdate(MataPelajaran mataPelajaran);
    MataPelajaran getIdMataPelajaran(Integer id);
    void hapusMataPelajaran (Integer id);
}


