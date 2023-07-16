package com.regedu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regedu.model.RegistStudentDB;
import com.regedu.model.User;

public interface daoRegistrasi  extends JpaRepository<RegistStudentDB,String> {

}
