
package org.sisma.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author YOGI-PC
 */

@Entity
@Table(name = "matapelajaran")
public class MataPelajaran {
    
	@Id
	private int idMataPelajaran;	
	private String namaMataPelajaran;
	private String kategori;
	private int jamPerMinggu;
	
	
	public int getIdMataPelajaran() {
		return idMataPelajaran;
	}
	public void setIdMataPelajaran(int idMataPelajaran) {
		this.idMataPelajaran = idMataPelajaran;
	}
	public String getNamaMataPelajaran() {
		return namaMataPelajaran;
	}
	public void setNamaMataPelajaran(String namaMataPelajaran) {
		this.namaMataPelajaran = namaMataPelajaran;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public int getJamPerMinggu() {
		return jamPerMinggu;
	}
	public void setJamPerMinggu(int jamPerMinggu) {
		this.jamPerMinggu = jamPerMinggu;
	}
	
	
}