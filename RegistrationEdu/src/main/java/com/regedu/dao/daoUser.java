package com.regedu.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.regedu.model.User;






public interface daoUser extends JpaRepository<User,String>
{
	


	   	
	   	User findByUsername (String username);
	
	
}
