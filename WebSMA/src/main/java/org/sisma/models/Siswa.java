
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
@Table(name = "siswa")
public class Siswa {
    
	@Id
	private String nisn;
	@Column(name = "username")
	private String userName;
	private String namaSiswa;
	private String tempatLahir;
	private String tanggalLahir;
	private String jenisKelamin;
	private String agama;
	private String alamat;
	private String kelas;
	private String asalSekolah;
	private String noTelp;
	

 
	public String getNisn() {
		return nisn; 
	}
	public void setNisn(String nisn) {
		this.nisn = nisn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNamaSiswa() {
		return namaSiswa;
	}
	public void setNamaSiswa(String namaSiswa) {
		this.namaSiswa = namaSiswa;
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
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public String getAsalSekolah() {
		return asalSekolah;
	}
	public void setAsalSekolah(String asalSekolah) {
		this.asalSekolah = asalSekolah;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	
	
}