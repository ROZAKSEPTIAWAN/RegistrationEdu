package com.regedu.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegiststudentVo {

	private String idRegistrasi;
	
	
	private String no_ujian;
	
	private String lokasi_ujian;
	
	private Date tanggal_ujian;
	private String nama;
	private String tempat_lahir;
	private Date tanggal_lahir;
	private String gender;
	private String no_telepon;
	
}
