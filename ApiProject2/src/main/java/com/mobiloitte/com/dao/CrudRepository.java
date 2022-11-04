package com.mobiloitte.com.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobiloitte.com.model.SignUpModel;

public interface CrudRepository extends JpaRepository<SignUpModel,Long> {

	SignUpModel findByFirstName(String firstName);

	Optional<SignUpModel> findByContact(Long contact);

	Optional<SignUpModel> findByLastName(String lastName);

	Optional<SignUpModel> findByUserName(String userName);

	Optional<SignUpModel> findByEmail(String email);

//	SignUpModel getByUserId(Long userId);

	Optional<SignUpModel> findByUserId(Long userId);

	SignUpModel getByUserId(Long userId);

}
