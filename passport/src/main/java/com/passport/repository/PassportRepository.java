package com.passport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passport.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{
//	 Optional<Passport> findByPassportId(String passportId);
}



//package com.passport.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.passport.model.Passport;
//
//@Repository
//public interface PassportRepository extends JpaRepository<Passport, Long> {
//    Optional<Passport> findByPassportId(String passportId);
//}
