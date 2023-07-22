package com.regedu.vo;

import java.util.Date;

public class registTemp implements Cloneable{
	
private String username;

@Override
public registTemp clone() {
   try {
       // Panggil metode clone() dari kelas Object
	   registTemp cloned = (registTemp) super.clone();
       return cloned;
   } catch (CloneNotSupportedException e) {
       // Jika terjadi kesalahan dalam cloning, tangkap dan tangani exception jika perlu
       e.printStackTrace();
       return null;
   }
}

	
	private String password;
	
	private String Role;
	
	private String idRegistrasi;
	
	
	private String no_ujian;
	
	private String lokasi_ujian;
	
	private Date tanggal_ujian;
	private String nama;
	private String tempat_lahir;
	private Date tanggal_lahir;
	private String gender;
	private String no_telepon;
	

	public String getIdRegistrasi() {
		return idRegistrasi;
	}

	public void setIdRegistrasi(String idRegistrasi) {
		this.idRegistrasi = idRegistrasi;
	}

	public String getNo_ujian() {
		return no_ujian;
	}

	public void setNo_ujian(String no_ujian) {
		this.no_ujian = no_ujian;
	}

	public String getLokasi_ujian() {
		return lokasi_ujian;
	}

	public void setLokasi_ujian(String lokasi_ujian) {
		this.lokasi_ujian = lokasi_ujian;
	}

	public Date getTanggal_ujian() {
		return tanggal_ujian;
	}

	public void setTanggal_ujian(Date tanggal_ujian) {
		this.tanggal_ujian = tanggal_ujian;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
