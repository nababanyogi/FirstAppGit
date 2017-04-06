 
package org.sisma.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author YOGI-PC
 */

@Entity
@Table(name = "guru")
public class Guru {
    
	@Id
	private String nip;
	@Column(name = "username")
	private String userName;
	private String namaGuru;
	private String tempatLahir;
	private String tanggalLahir;
	private String jenisKelamin;
	private int idMataPelajaran;
	private String agama;
	private String alamat;
	private String pendidikanTerakhir;
	private String noTelp;
	private String golongan;
	
	public int getIdMataPelajaran() {
		return idMataPelajaran;
	}
	public void setIdMataPelajaran(int idMataPelajaran) {
		this.idMataPelajaran = idMataPelajaran;
	}	
	
	public String getGolongan() {
		return golongan;
	}
	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getNip() {
		return nip;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNamaGuru() {
		return namaGuru;
	}
	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public String getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getAgama() {
		return agama;
	}
	public void setAgama(String agama) {
		this.agama = agama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getPendidikanTerakhir() {
		return pendidikanTerakhir;
	}
	public void setPendidikanTerakhir(String pendidikanTerakhir) {
		this.pendidikanTerakhir = pendidikanTerakhir;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	
	
}