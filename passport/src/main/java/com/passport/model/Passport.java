
package com.passport.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Passport {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String passportId;
   private String issuePlace;
   private LocalDate issueDate;
   
   
   @OneToOne(mappedBy="passport")
//   @JoinColumn(referencedColumnName="id") 
   @JsonBackReference
  private Person person;
 
public Passport() {}   

public Passport( String passportId, String issuePlace, LocalDate issueDate) {
//	this.id = id;
	this.passportId = passportId;
	this.issuePlace = issuePlace;
	this.issueDate=issueDate;
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPassportId() {
	return passportId;
}

public void setPassportId(String passportId) {
	this.passportId = passportId;
}

public String getIssuePlace() {
	return issuePlace;
}

public void setIssuePlace(String issuePlace) {
	this.issuePlace = issuePlace;
}




public LocalDate getIssueDate() {
	return issueDate;
}

public void setIssueDate(LocalDate issueDate) {
	this.issueDate = issueDate;
}

public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}
   
   
   
   
   
   
   
   
   
}






















//package com.passport.model;


//import java.time.LocalDate;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;

//@Entity
//public class Passport {
//	
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String passportId;
//    private String issuePlace;
//    private LocalDate issueDate;
//
//    @OneToOne(mappedBy = "passport")
//    @JsonBackReference  
//    private Person person;
//
//    // Constructors, Getters, and Setters
//    public Passport() {}
//
//    public Passport(String passportId, String issuePlace, LocalDate issueDate) {
//        this.passportId = passportId;
//        this.issuePlace = issuePlace;
//        this.issueDate = issueDate;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    
//    public String getPassportId() { return passportId; }
//    public void setPassportId(String passportId) { this.passportId = passportId; }
//    
//    public String getIssuePlace() { return issuePlace; }
//    public void setIssuePlace(String issuePlace) { this.issuePlace = issuePlace; }
//    
//    public LocalDate getIssueDate() { return issueDate; }
//    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
//}