package com.regedu.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.regedu.dao.daoRegistrasi;
import com.regedu.dao.daoUser;
import com.regedu.dao.paymentprocess;
import com.regedu.model.ParentsDB;
import com.regedu.model.PaymentDB;
import com.regedu.model.RegistStudentDB;
import com.regedu.model.User;
import com.regedu.service.userService;
import org.springframework.web.server.ResponseStatusException;
import com.regedu.vo.RegiststudentVo;
import com.regedu.vo.registTemp;
import com.regedu.vo.validasiVo;
import com.regedu.vo.voUser;

@Service
@Transactional
public class userServiceImpl implements userService {

	@Autowired
	daoUser daouser;

	@Autowired
	daoRegistrasi daoregistrasi;

	@Autowired
	paymentprocess paymentproces;

	@Override
	public User authenticate(String user, String pass) {

		User users = daouser.findByUsername(user);
		if (users != null && users.getPassword().equals(pass)) {
			return users;
		} else {
			return null;		}

	}

	@Override
	public void registerData(RegistStudentDB regist) {
		
		if (regist.getIdRegistrasi()== null || regist.getIdRegistrasi().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nama mahasiswa tidak boleh kosong");
		} else {
			daoregistrasi.findAlls();
		}

	}

	@Override
	public List<registTemp> getAllRegistrationData() {
		String role = "";
		List<registTemp> datasFix = daoregistrasi.findAlls();
		List<registTemp> dataTemp  = daoregistrasi.findTemp();
		for (registTemp obj :dataTemp)
		{
			System.out.println("MASUK SINI 1");
			obj.setUsername(obj.getUsername());
			obj.setPassword(obj.getPassword());
			String user = obj.getUsername();
			System.out.println("ISI USER _________"+user);
			List <validasiVo> dataValidasi = daoregistrasi.validasi(user);
			System.out.println("ISI dataValidasi _________"+dataValidasi.size());
			if (dataValidasi.size()>0)
			{
				role = "ACTIVE";
			}
			else
			{
				role = "NOT ACTIVE";
			}
			obj.setRole(role);
			
		}
		
		for (registTemp objFinal :datasFix )
		{
			System.out.println("MASUK SINI 1");
			for (registTemp objTemp : dataTemp)
			{
				System.out.println("MASUK SINI 2");
				if(objFinal.getIdRegistrasi().equals(objTemp.getUsername()))
				{
					System.out.println("MASUK SINI 3");
					String isi = objTemp.getRole();
					System.out.println("isi ROLE 3"+isi);
					objFinal.setNo_telepon(objTemp.getRole());
					break;
				}
			}
		}
		
		for (registTemp objTemp : dataTemp)
		{
			System.out.println("MASUK SINI 4");
			String isi = objTemp.getRole();
			System.out.println("isi ROLE 4"+isi);
			 boolean isExist = false;
			 for (registTemp objFinal :datasFix)
			 {
				 System.out.println("MASUK SINI 5");
				 if (objFinal.getNo_telepon().equals(objTemp.getRole()))
				 {
					 System.out.println("MASUK SINI 6");
					 isExist = true;
					 break;
				 }
			 }
             if (!isExist) {
            	 System.out.println("MASUK SINI 7");
            	 datasFix.add(objTemp.clone());
             }
		}
		return datasFix;
	}

	@Override
	public String dataId() {
		int seqId = 000;
		List<registTemp> totalId = daoregistrasi.findAlls();
		int dataid = totalId.size() + 1;
		seqId = dataid;

		String idSiswa = "R-" + String.valueOf(seqId);

		return idSiswa;
	}

	@Override
	public String dataUjian() {
		int seqId = 000;
		List<registTemp> totalId = daoregistrasi.findAlls();
		int dataid = totalId.size() + 1;
		seqId = dataid;

		String idSiswa = "U-" + String.valueOf(seqId);

		return idSiswa;
	}

	@Override
	public void registParents(ParentsDB parentsRegist) {
		// TODO Auto-generated method stub
		
		

	}

	@Override
	public void payments(PaymentDB PaymentsPay, String idData) {
		
		Optional<PaymentDB> dataSiswa = paymentproces.findById(idData);
		
		if (dataSiswa != null)
		{
			int uang_pangkal = PaymentsPay.getUang_pangkal();
			int formulir = PaymentsPay.getFormulir();
			int angsuranPertama = PaymentsPay.getAngsuran_pertama();
			int angsuranKedua = PaymentsPay.getAngsuran_kedua();
			int totalbayar = uang_pangkal+angsuranPertama+angsuranKedua+formulir;
			if (totalbayar == 12000000)
			{
				PaymentsPay.setKeterangan("LUNAS");
			}
			else
			{
				PaymentsPay.setKeterangan("BELUM LUNAS");
			}

			PaymentsPay.setTotal_bayar(totalbayar);
			paymentproces.save(PaymentsPay);
		}
		else
		{
			String noInvoice = PaymentsPay.getNo_invoice();
//			int dataTotalDb = paymentproces.findDataTotal(noInvoice);
			int dataTotalDb = 0;
			int dataTotal = PaymentsPay.getTotal_bayar();
			
			if (dataTotalDb == dataTotal)
			{
				PaymentsPay.setKeterangan("LUNAS");
			}
		}
		


	}


	
//	<!DOCTYPE html>
//	<html>
//	<head>
//	    <title>User Form</title>
//	    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
//	</head>
//	<body>
//	    <form>
//	        <label for="name">Name:</label>
//	        <input type="text" id="name" />
//	        <button type="button" id="fetchData">Fetch Data</button>
//	    </form>
//
//	    <script>
//	        $(document).ready(function() {
//	            $("#fetchData").click(function() {
//	                // Make an AJAX request to retrieve data from the backend
//	                $.ajax({
//	                    url: "/user",
//	                    method: "GET",
//	                    success: function(data) {
//	                        // Fill the input field with the retrieved data
//	                        $("#name").val(data.userName);
//	                    },
//	                    error: function() {
//	                        console.log("Failed to fetch data from the backend.");
//	                    }
//	                });
//	            });
//	        });
//	    </script>
//	</body>
//	</html>


}
