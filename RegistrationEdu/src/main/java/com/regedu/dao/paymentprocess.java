package com.regedu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regedu.model.PaymentDB;
import com.regedu.model.User;

public interface paymentprocess  extends JpaRepository<PaymentDB,String >{

}
