package com.passport.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private String birthPlace;
	
//	@OneToOne(mappedBy="person",cascade=CascadeType.ALL)
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport_id", referencedColumnName="id")
	@JsonManagedReference
	private Passport passport;
	
	public Person() {}
	public Person( String name, LocalDate dateOfBirth, String birthPlace,Passport passport) {
//		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.passport=passport;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
	
}
















//package com.passport.model;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//
//import java.time.LocalDate;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//public class Person {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String name;
//    private LocalDate dateOfBirth;
//    private String birthPlace;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference 
//    @JoinColumn(name = "passport_id", referencedColumnName = "id")
//    private Passport passport;
//
//    // Constructors, Getters, and Setters
//    public Person() {}
//
//    public Person(String name, LocalDate dateOfBirth, String birthPlace, Passport passport) {
//        this.name = name;
//        this.dateOfBirth = dateOfBirth;
//        this.birthPlace = birthPlace;
//        this.passport = passport;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    
//    public LocalDate getDateOfBirth() { return dateOfBirth; }
//    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
//    
//    public String getBirthPlace() { return birthPlace; }
//    public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }
//    
//    public Passport getPassport() { return passport; }
//    public void setPassport(Passport passport) { this.passport = passport; }
//}