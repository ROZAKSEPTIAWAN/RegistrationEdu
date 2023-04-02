package com.regedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regedu.dao.daoUser;
import com.regedu.model.User;
import com.regedu.vo.voUser;





public interface userService {
	


	
	User authenticate(String username, String password);
	

}
