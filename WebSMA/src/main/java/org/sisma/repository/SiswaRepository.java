package org.sisma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.sisma.models.Siswa;;

@Repository("siswaRepository")
public interface SiswaRepository extends JpaRepository<Siswa, Long> {
	Siswa findByUserName(String UserName);
}