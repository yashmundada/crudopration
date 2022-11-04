package com.mobiloitte.com.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mobiloitte.com.dto.CrudOperation;
import com.mobiloitte.com.model.SignUpModel;

public interface CrudService {

	ResponseEntity<String> saveUser(CrudOperation crudOperation);

	SignUpModel getByFirstName(String firstName);

	

	Optional<SignUpModel> getByLastName(String lastName);
//
	ResponseEntity<String> updateUser(Long userId, CrudOperation crudOperation);

	ResponseEntity<String> deleteUser(Long userId);

	Optional<SignUpModel> getByUserId(Long userId);

	java.util.List<SignUpModel> listAll();

	




}
