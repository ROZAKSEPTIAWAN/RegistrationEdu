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
import com.regedu.model.StudentsDB;
import com.regedu.model.User;
import com.regedu.service.userService;
import org.springframework.web.server.ResponseStatusException;
import com.regedu.vo.RegiststudentVo;
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
			return null;
		}

	}

	@Override
	public void registerData(RegistStudentDB regist) {

		if (regist.getIdRegistrasi() == null || regist.getIdRegistrasi().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nama mahasiswa tidak boleh kosong");
		} else {
			daoregistrasi.save(regist);
		}

	}

	@Override
	public List<RegistStudentDB> getAllRegistrationData() {

		return daoregistrasi.findAll();
	}

	@Override
	public String dataId() {
		int seqId = 000;
		List<RegistStudentDB> totalId = daoregistrasi.findAll();
		int dataid = totalId.size() + 1;
		seqId = dataid;

		String idSiswa = "R-" + String.valueOf(seqId);

		return idSiswa;
	}

	@Override
	public String dataUjian() {
		int seqId = 000;
		List<RegistStudentDB> totalId = daoregistrasi.findAll();
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
			int angsuranPertama = PaymentsPay.getAngsuranPertama();
			int angsuranKedua = PaymentsPay.getAngsuranKedua();
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
			String noInvoice = PaymentsPay.getNoInvoice();
			int dataTotalDb = paymentproces.findDataTotal(noInvoice);
			int dataTotal = PaymentsPay.getTotal_bayar();
			
			if (dataTotalDb == dataTotal)
			{
				PaymentsPay.setKeterangan("LUNAS");
			}
		}
		


	}

	@Override
	public void students(StudentsDB StudentsAdd) {
		// TODO Auto-generated method stub

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
