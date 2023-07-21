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

import com.ugaz.infraccionservice.entity.Infraccion;
import com.ugaz.infraccionservice.entity.user;
import com.ugaz.infraccionservice.service.infraccionService;
import com.ugaz.infraccionservice.service.userService;

@RestController
@RequestMapping("/api/infraciones")
public class infraccionApi {
    @Autowired
	private infraccionService service;
	
	@Autowired
	private userService serviceUser;
	
	@GetMapping()
	public ResponseEntity<List<Infraccion>> getAll(){
		List<Infraccion> infraccion= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(infraccion);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Infraccion> getById(@PathVariable("id") int id) {
		Infraccion infraccion = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(infraccion);
	}
	
	@PostMapping
	public ResponseEntity<Infraccion> create(@RequestBody Infraccion user) {
		Infraccion infraccionDb=service.create(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(infraccionDb);
	}
	
	@PutMapping
	public ResponseEntity<Infraccion> update(@RequestBody Infraccion user) {
		Infraccion infraccionDb=service.update(user);
		return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}

    @GetMapping("/users")
    public List<user> getSocios() {
        return serviceUser.findAll();
    }
}
