package com.regedu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.regedu.model.RegistStudentDB;
import com.regedu.model.User;
import com.regedu.service.userService;
import com.regedu.vo.voUser;

@Controller
public class Rest {
	

    @Autowired
    userService UserService;
    

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody voUser voUsers) {
        User user = UserService.authenticate(voUsers.getUsername(), voUsers.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/maulogin")
    public String logins (Model model)
    {

		return "Login";
    }
    
    @GetMapping("/Dashboard")
    public String DASHBOARD (Model model)
    {
    	String idsequence =  UserService.dataId();
    	String noUjian =  UserService.dataUjian();
    	model.addAttribute("idsequence",idsequence);
    	model.addAttribute("noUjian",noUjian);
		return "Dashboard";
    }
    
    @PostMapping("/Save")
    public ResponseEntity <Void> save (@RequestBody  RegistStudentDB registStudentDB) 
    {
		 UserService.registerData(registStudentDB);
		 return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @GetMapping("/allRegistrationDatas")
    public ResponseEntity  <List <RegistStudentDB>>  getAllRegistration ()
    {

		return new ResponseEntity<List <RegistStudentDB>> (UserService.getAllRegistrationData(),HttpStatus.OK);
    }

    


}
