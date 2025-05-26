package com.passport.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.passport.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Person findByPassport_passportId(String passportId);
	
}






//package com.passport.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.passport.model.Person;
//
//public interface PersonRepository extends JpaRepository<Person, Long> {
//
//
//
//	List<Person> save(List<Object> persons);
//}