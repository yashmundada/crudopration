package com.mobiloitte.com.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobiloitte.com.dao.CrudRepository;
import com.mobiloitte.com.dto.CrudOperation;
import com.mobiloitte.com.model.SignUpModel;
import com.mobiloitte.com.service.CrudService;



@Service
public class CrudServiceimpl implements CrudService {

	@Autowired
	private CrudRepository crudRepository;

	@Override
	public ResponseEntity<String> saveUser(CrudOperation crudOperation) {
		SignUpModel signUpModel = new SignUpModel();

		// check user id present
		Optional<SignUpModel> userid = crudRepository.findById(crudOperation.getUserId());
		if (!userid.isPresent()) {
			signUpModel.setUserId(crudOperation.getUserId());

		} else {
			return new ResponseEntity<>("user id not available...", HttpStatus.OK);

		}

		// check first name and last name available
		Optional<SignUpModel> firstname = Optional.ofNullable(crudRepository.findByFirstName(crudOperation.getFirstName()));
		Optional<SignUpModel> lastName = crudRepository.findByLastName(crudOperation.getLastName());
		if (!firstname.isPresent() && !lastName.isPresent()) {
			signUpModel.setFirstName(crudOperation.getFirstName());
			signUpModel.setLastName(crudOperation.getLastName());
		}

		// check user name availble
		Optional<SignUpModel> username = crudRepository.findByUserName(crudOperation.getUserName());
		if (!username.isPresent()) {
			signUpModel.setUserName(crudOperation.getUserName());
		} else {
			return new ResponseEntity<>("username is not availble...", HttpStatus.OK);

		}
		// check email is present
		Optional<SignUpModel> email = crudRepository.findByEmail(crudOperation.getEmail());
		System.out.println(email);
		if (!email.isPresent()) {
			signUpModel.setEmail(crudOperation.getEmail());

		} else {

			return new ResponseEntity<>("Email already used...", HttpStatus.OK);
		}

		// check contact available
		Optional<SignUpModel> contact = crudRepository.findByContact(crudOperation.getContact());
		if (!contact.isPresent()) {

			signUpModel.setDob(crudOperation.getDob());
			signUpModel.setContact(crudOperation.getContact());
			signUpModel.setPassword(crudOperation.getPassword());
			crudRepository.save(signUpModel);
			return new ResponseEntity<>("user registered successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("contact already registered", HttpStatus.OK);

		}

	}
	
	@Override
	public SignUpModel getByFirstName(String firstName) {

		return crudRepository.findByFirstName(firstName);
	}
//data get by user id
	@Override
	public Optional<SignUpModel> getByUserId(Long userId) {
		return crudRepository.findById(userId);
	}
//update by user id
	@Override
	public ResponseEntity<String> updateUser(Long userId, CrudOperation crudOperation) {
		ResponseEntity<String>msg=new ResponseEntity<>("",HttpStatus.OK);
		Optional<SignUpModel>value=crudRepository.findByUserId(userId);
		if (value.isPresent()) {
			SignUpModel signUpModel = crudRepository.getByUserId(userId);
			signUpModel.setFirstName(crudOperation.getFirstName());
			signUpModel.setLastName(crudOperation.getLastName());
			signUpModel.setDob(crudOperation.getDob());
			crudRepository.save(signUpModel);
			msg = new ResponseEntity<>("User Data Updated Successfully... ", HttpStatus.OK);
		} else {
			msg = new ResponseEntity<>("User Not Exist...", HttpStatus.OK);
		}
		return msg;
	}

	
//find by last name
	@Override
	public Optional<SignUpModel> getByLastName(String lastName) {
		return crudRepository.findByLastName(lastName);
		
	}
//delete by user id 
	@Override
	public ResponseEntity<String> deleteUser(Long userId) {
	crudRepository.deleteById(userId);
	
		return new ResponseEntity<>("user data deleted successfully...",HttpStatus.OK);
	}
@Override
public List<SignUpModel> listAll() {

	return crudRepository.findAll();
}



	




	}

	

