package com.passport.controller;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passport.model.Person;
//import com.passport.model.Person;
import com.passport.service.PersonService;
 
@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
    private PersonService personservice;
	
	public PersonController(PersonService personservice ) {
		this.personservice=personservice;
	}
	
	
		@PostMapping("/create")
	     public void create() {
		personservice.create();
		
	}
	
		@GetMapping("/getall")
		public List<Person> getAllPersons(){
			return personservice.getAllPersons();
		}
		
		
		@GetMapping("/passport/{passportId}")
		public ResponseEntity<Person> getPersonByPassport(@PathVariable String passportId){
			Person persons=personservice.getPersonsByPassportId(passportId);
			if(persons==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(persons);
		}
		
		
		
		
		
		
		
		
	
	//if use List<Person> as rtuen type in service
//	@PostMapping("/create")
//	public ResponseEntity<List<Person>> create (@RequestBody List<Person> p){
//		return ResponseEntity.ok(personservice.create(p));
//	}
	
	//this way without responsentity  and giving data from requestbody
//	@PostMapping("/create")
//	public void createPerson(@RequestBody List<Person> p) {
//		personservice.create(p);
//		return ;
//	}
//	
	
	
}	
	
	//if we want handel errors easily by gettting status code we can write it in responseentity
//	@PostMapping("/create")
//	public ResponseEntity<Void> createPerson(List<Person> p) {
//		personservice.create(p);
//		return ResponseEntity.ok().build();
//		
//	}
	







//package com.passport.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.passport.model.Person;
//import com.passport.service.PersonService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/persons")
//public class PersonController {
//
//	    @Autowired
//	    private PersonService personService;
//	 
//	 public PersonController(PersonService personService) {
//	        this.personService = personService;
//	    }
//
//
//	  @PostMapping
//	    public ResponseEntity<List<Person>> createPersons(@RequestBody List<Person> persons) {
//	        List<Person> savedPersons = personService.createPersons(persons);
//	        return new ResponseEntity<>(savedPersons, HttpStatus.CREATED);
//	    }
//
//    @GetMapping("/passport/{passportId}")
//    public ResponseEntity<Person> getPersonByPassportId(@PathVariable String passportId) {
//        Person person = personService.getPersonByPassportId(passportId);
//        return person != null ? new ResponseEntity<>(person, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Person>> getAllPersons() {
//        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
//    }
//}
