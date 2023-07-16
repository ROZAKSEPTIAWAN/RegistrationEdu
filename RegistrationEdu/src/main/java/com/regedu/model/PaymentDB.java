package com.regedu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "PAYMENT")
public class PaymentDB {
	
	@Id
	private String no_invoice;
	
	
	
	
	private int angsuran_kedua;
	private int angsuran_pertama;
	private int total_bayar;
	
	private int uang_pangkal;
	private int  formulir;
	
	
	public String getNo_invoice() {
		return no_invoice;
	}

	public void setNo_invoice(String no_invoice) {
		this.no_invoice = no_invoice;
	}

	public int getAngsuran_kedua() {
		return angsuran_kedua;
	}

	public void setAngsuran_kedua(int angsuran_kedua) {
		this.angsuran_kedua = angsuran_kedua;
	}

	public int getAngsuran_pertama() {
		return angsuran_pertama;
	}

	public void setAngsuran_pertama(int angsuran_pertama) {
		this.angsuran_pertama = angsuran_pertama;
	}

	public int getTotal_bayar() {
		return total_bayar;
	}

	public void setTotal_bayar(int total_bayar) {
		this.total_bayar = total_bayar;
	}

	public int getUang_pangkal() {
		return uang_pangkal;
	}

	public void setUang_pangkal(int uang_pangkal) {
		this.uang_pangkal = uang_pangkal;
	}

	public int getFormulir() {
		return formulir;
	}

	public void setFormulir(int formulir) {
		this.formulir = formulir;
	}

	public String getMetodeBayar() {
		return metodeBayar;
	}

	public void setMetodeBayar(String metodeBayar) {
		this.metodeBayar = metodeBayar;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	private String metodeBayar;
	
	private String keterangan;
	
	
	

}
