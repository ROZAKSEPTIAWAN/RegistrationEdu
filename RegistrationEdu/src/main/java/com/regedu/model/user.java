package com.regedu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "USER")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long Id;
	
	  private String username;
	
	private String password;
	
	private String role;
	
	
}
