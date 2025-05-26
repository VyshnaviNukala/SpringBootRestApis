
package com.passport.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passport.model.Passport;
import com.passport.model.Person;
import com.passport.repository.PassportRepository;
import com.passport.repository.PersonRepository;

@Service
public class PersonService{
	
	@Autowired
	private PersonRepository personrepo;
	
//	@Autowired
//	private PassportRepository passportrepo;
//	
	
	
	public PersonService(PersonRepository personrepo) {
		this.personrepo=personrepo;
		
	}
	
//	public List<Person> create (List<Person> p) {
//		return personrepo.saveAll(p);
//	}
	
// for sending dtat from postpam 	
//	public void create(List<Person> p) {
//		personrepo.saveAll(p);
//	}
//	
//	


//for harcode 
	public void create() {
		List<Person> persons = List.of(
		  createPersons("vyshu",LocalDate.of(2003,11,26), "mummidivaram", "AAFGF6", "Kakinada", LocalDate.of(2024,05,03)),
		 createPersons("swathi", LocalDate.of(2001,12,13), "nagarkarnool", "JFGHFIG8", "Hyderbad", LocalDate.of(2024, 05, 04)),
		 createPersons("hari", LocalDate.of(2001,12,13), "karnool", "JFGHFIG8", "Hyderbad", LocalDate.of(2024, 05, 04)),
		 createPersons("shruu", LocalDate.of(2001,12,13), "nagar", "JFGHFIG8", "Hyderbad", LocalDate.of(2024, 05, 04))
		 );
	
		 personrepo.saveAll(persons);
		 	System.out.println("saved 5 details");	
	}
	
	private Person createPersons( String name, LocalDate dateOfBirth, String birthPlace, String passportId, String issuePlace, LocalDate issueDate) {
		Passport  passport = new Passport(passportId, issuePlace, issueDate);
		Person person=new Person( name,  dateOfBirth, birthPlace,passport);
		passport.setPerson(person);
		return person;
		 
	}
	
	
//	
//
	public List<Person> getAllPersons() {
		
		return personrepo.findAll();
	}
	
	public Person getPersonsByPassportId(String passportId) {
		return personrepo.findByPassport_passportId(passportId);
		
	}
	
}




























//package com.passport.service;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.passport.model.Passport;
//import com.passport.model.Person;
//import com.passport.repository.PassportRepository;
//import com.passport.repository.PersonRepository;
//
//import java.util.List;
//
//
//@Service
//public class PersonService {
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Autowired
//   private PassportRepository passportRepository;
//
//
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    public List<Person> createPersons(List<Person> persons) {
//        return personRepository.saveAll(persons);
//    }
//
//
//	public Person getPersonByPassportId(String passportId) {
//        Optional<Passport> passportOpt = passportRepository.findByPassportId(passportId);
//        return passportOpt.map(passport -> passport.getPerson()).orElse(null);
//    }
//
//    public List<Person> getAllPersons() {
//        return personRepository.findAll();
//    }
//}