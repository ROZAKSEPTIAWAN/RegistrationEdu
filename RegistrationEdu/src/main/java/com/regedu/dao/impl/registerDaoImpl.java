package com.regedu.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.regedu.dao.daoRegistrasi;
import com.regedu.vo.RegiststudentVo;
import com.regedu.vo.registTemp;
import com.regedu.vo.validasiVo;


@Repository
public class registerDaoImpl implements daoRegistrasi{

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public registerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<registTemp> findAlls() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT idRegistrasi,nama,no_telepon FROM registrasi";
		 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		 List<registTemp> listResult = new ArrayList<>();
		 for (Map<String,Object> row : rows)
		 {
			 registTemp obj = new registTemp();
			 
			 obj.setIdRegistrasi((String) row.get("idRegistrasi"));
			 obj.setNama((String) row.get("nama"));
			 obj.setNo_telepon((String) row.get("no_telepon"));
			 listResult.add(obj);
		 }
		 
		 
		return listResult;
	}

	@Override
	public List<registTemp> findTemp() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT username,password FROM PARENTS";
		 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		 List<registTemp> listResult = new ArrayList<>();
		 for (Map<String,Object> row : rows)
		 {
			 registTemp obj = new registTemp();
			 
			 obj.setUsername((String) row.get("username"));
			 obj.setPassword((String) row.get("password"));
			 listResult.add(obj);
		 }
		 
		 
		return listResult;
	}

	@Override
	public List<validasiVo> validasi(String id) {
		String sql = "SELECT username,password,role FROM USER where username = ?";
		 List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,id);
		 List<validasiVo> listResult = new ArrayList<>();
		 for (Map<String,Object> row : rows)
		 {
			 validasiVo obj = new validasiVo();
			 
			 obj.setUserid((String) row.get("userid"));
			 listResult.add(obj);
		 }
		 
		return listResult;
	}

}
