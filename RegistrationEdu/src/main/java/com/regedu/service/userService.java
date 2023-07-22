package com.regedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regedu.dao.daoUser;
import com.regedu.model.ParentsDB;
import com.regedu.model.PaymentDB;
import com.regedu.model.RegistStudentDB;
//import com.regedu.model.StudentsDB;
import com.regedu.model.User;
import com.regedu.vo.RegiststudentVo;
import com.regedu.vo.registTemp;
import com.regedu.vo.voUser;





public interface userService {
	


	
	User authenticate(String username, String password);
	public void registerData (RegistStudentDB Idregist);
	public void registParents (ParentsDB parentsRegist);
	public void payments (PaymentDB PaymentsPay,  String idData);
//	public void students (StudentsDB StudentsAdd);
	public List<registTemp> getAllRegistrationData();
	public String dataId();
	public String dataUjian();
} 
