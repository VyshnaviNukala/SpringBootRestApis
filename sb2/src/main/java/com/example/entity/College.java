package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long  cid;
private String name;

College() {}

College(Long cid, String name){
	this.cid=cid;
	this.name=name;
}
public Long getId() {
	return cid;
}
public String getName() {
	return name;
}
public void setId(Long cid) {
	this.cid=cid;
}
public void setName(String name) {
	this.name=name;
}
}
