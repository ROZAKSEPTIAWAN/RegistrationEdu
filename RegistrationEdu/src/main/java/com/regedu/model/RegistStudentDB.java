package com.regedu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "REGISTRASI")
public class RegistStudentDB {
	
	@Id
	private String id_registrasi;
	
	private String gender;
	
	private String no_telepon;
	
	private Date tanggal_lahir;
	
	private Date tanggal_ujian;
	
	public String getId_registrasi() {
		return id_registrasi;
	}

	public void setId_registrasi(String id_registrasi) {
		this.id_registrasi = id_registrasi;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNo_telepon() {
		return no_telepon;
	}

	public void setNo_telepon(String no_telepon) {
		this.no_telepon = no_telepon;
	}

	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public Date getTanggal_ujian() {
		return tanggal_ujian;
	}

	public void setTanggal_ujian(Date tanggal_ujian) {
		this.tanggal_ujian = tanggal_ujian;
	}

	public String getLokasi_ujian() {
		return lokasi_ujian;
	}

	public void setLokasi_ujian(String lokasi_ujian) {
		this.lokasi_ujian = lokasi_ujian;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNo_ujian() {
		return no_ujian;
	}

	public void setNo_ujian(String no_ujian) {
		this.no_ujian = no_ujian;
	}

	private String lokasi_ujian;
	
	private String nama;
	
	private String no_ujian;
	
	

}
