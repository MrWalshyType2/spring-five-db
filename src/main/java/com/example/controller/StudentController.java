package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository sRepo;
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Optional<Student> getStudent(@PathVariable int id) {
		return sRepo.findById(id);
	}

	@PostMapping(produces="application/json")
	public Student createStudent(@RequestBody Student acc) {
		return sRepo.saveAndFlush(acc);
	}
	
	@PutMapping(produces="application/json")
	public Student updateStudent(@RequestBody Student acc) {
		Optional<Student> tmp = sRepo.findById(acc.getRegno());
		Student account = tmp.get();
		account.setName(acc.getName());
		account.setAddress(acc.getAddress());
		return sRepo.save(account);
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteStudent(@PathVariable int id) {
		sRepo.deleteById(id);
		return "Student deleted";
	}
}
