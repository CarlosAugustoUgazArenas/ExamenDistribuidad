package com.ugaz.infraccionservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ugaz.infraccionservice.entity.user;
import com.ugaz.infraccionservice.service.userService;

@RestController
@RequestMapping("/api/usuarios")
public class userApi {
    @Autowired
	private userService service;
	
	@GetMapping()
	public ResponseEntity<List<user>> getAll(){
		List<user> user= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<user> getById(@PathVariable("id") int id) {
		user user = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<user> create(@RequestBody user user) {
		user userDb=service.create(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDb);
	}
	
	@PutMapping
	public ResponseEntity<user> update(@RequestBody user user) {
		user userDb=service.update(user);
		return ResponseEntity.status(HttpStatus.OK).body(userDb);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
