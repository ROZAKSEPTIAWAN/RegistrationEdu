package com.regedu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regedu.model.RegistStudentDB;
import com.regedu.model.User;
import com.regedu.vo.RegiststudentVo;
import com.regedu.vo.registTemp;
import com.regedu.vo.validasiVo;


//public interface daoRegistrasi  extends JpaRepository<RegistStudentDB,String> {

public interface daoRegistrasi  {
	
	 List<registTemp> findAlls();
	 
	 List<registTemp> findTemp();
	 
	 List<validasiVo> validasi (String id);

}
