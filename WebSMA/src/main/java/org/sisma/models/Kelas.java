
package org.sisma.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author YOGI-PC
 */

@Entity
@Table(name = "Kelas")
public class Kelas {
    
	@Id
	private int idKelas;
	private String namaKelas;
	private String idWali;
	
	public int getIdKelas() {
		return idKelas;
	}
	public void setIdKelas(int idKelas) {
		this.idKelas = idKelas;
	}
	public String getNamaKelas() {
		return namaKelas;
	}
	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
	}
	public String getIdWali() {
		return idWali;
	}
	public void setIdWali(String idWali) {
		this.idWali = idWali;
	}
	
	
	
}