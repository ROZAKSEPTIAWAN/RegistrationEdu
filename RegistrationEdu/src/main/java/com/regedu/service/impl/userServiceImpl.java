package com.regedu.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regedu.dao.daoUser;
import com.regedu.model.User;
import com.regedu.service.userService;
import com.regedu.vo.voUser;


@Service
public class userServiceImpl implements userService {

	@Autowired
	daoUser daouser;

	@Override
	public com.regedu.model.User authenticate (String user, String pass) {


		
		 User users = daouser.findByUsername(user);
	        if (users != null && users.getPassword().equals(pass)) {
	            return users;
	        } else {
	            return null;
	        }

		
	}

}
