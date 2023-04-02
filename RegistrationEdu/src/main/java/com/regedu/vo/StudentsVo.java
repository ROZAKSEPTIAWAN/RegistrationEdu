package com.regedu.vo;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsVo {
	
	private int nis;
	private String nama,namaPanggilan,tempatLahir,agama,JenisKelamin,alamat,hobi,studiFav,olahraga,namaSekolahBef,alamatSekolahBef;
	private Date tanggalLahir;
}
