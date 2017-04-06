package org.sisma.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_mahasiswa;
	private String nama_mahasiswa;
	private String nama_perangkat;
	private String tgl_pembawaan;
	private String tgl_kembali;
	private String status;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_mahasiswa() {
		return id_mahasiswa;
	}
	public void setId_mahasiswa(int id_mahasiswa) {
		this.id_mahasiswa = id_mahasiswa;
	}
	public String getNama_mahasiswa() {
		return nama_mahasiswa;
	}
	public void setNama_mahasiswa(String nama_mahasiswa) {
		this.nama_mahasiswa = nama_mahasiswa;
	}
	public String getNama_perangkat() {
		return nama_perangkat;
	}
	public void setNama_perangkat(String nama_perangkat) {
		this.nama_perangkat = nama_perangkat;
	}
	public String getTgl_pembawaan() {
		return tgl_pembawaan;
	}
	public void setTgl_pembawaan(String tgl_pembawaan) {
		this.tgl_pembawaan = tgl_pembawaan;
	}
	public String getTgl_kembali() {
		return tgl_kembali;
	}
	public void setTgl_kembali(String tgl_kembali) {
		this.tgl_kembali = tgl_kembali;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
