package com.mobiloitte.com.controller;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobiloitte.com.dto.CrudOperation;
import com.mobiloitte.com.model.SignUpModel;
import com.mobiloitte.com.service.CrudService;



@RestController
public class SignUp {
	@Autowired
	private  CrudService crudService;
	
	
	//insert user data
	@PostMapping("/saveuser")
	public ResponseEntity<String>save(@RequestBody CrudOperation crudOperation)
	{
		return crudService.saveUser(crudOperation);
		
	}

	//get all user data
	@GetMapping("/users")
	public List<SignUpModel> listAll()
	{
		return crudService.listAll();
     }
	
	//get user data by first name
	@GetMapping("/getbyfname/{firstName}")
	public SignUpModel fname (@PathVariable("firstName") String firstName){
		return crudService.getByFirstName(firstName);
	}
	
	//get user data by last name
	@GetMapping("/getByLname/{lastName}")
	public Optional<SignUpModel>lname(@PathVariable("lastName")String lastName){
		return crudService.getByLastName(lastName);
}
	
	// get user data using user id
	@GetMapping("/getById/{userId}")
	public Optional<SignUpModel> idData(@PathVariable("userId")Long userId){
		return crudService.getByUserId(userId);
}
	
//	//update user details
	@PutMapping("/update/{userId}")
	public ResponseEntity<String>updateUser(@PathVariable("userId")Long userId, @RequestBody CrudOperation crudOperation){
		return crudService.updateUser(userId,crudOperation);
}
//	//delete user details
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String>deleteUser(@PathVariable("userId")Long userId){
		return crudService.deleteUser(userId);
}
	
}
