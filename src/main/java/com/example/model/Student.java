package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int regno;
	String name;
	String address;
	
	public Student() {
		super();
	}
	
	public Student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Student(int id, String name, String address) {
		super();
		this.regno = id;
		this.name = name;
		this.address = address;
	}
	
	public int getRegno() {
		return regno;
	}
	
	public void setRegno(int regno) {
		this.regno = regno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
