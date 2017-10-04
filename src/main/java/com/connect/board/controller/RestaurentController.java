package com.connect.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connect.board.model.Restaurent;
import com.connect.board.service.RestaurentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RestaurentController {

	@Autowired
	RestaurentService restaurentService;

	@GetMapping("/restaurents")
	List<Restaurent> findAll() {
		return restaurentService.findAll();
	}
	
	@PostMapping("/restaurent")
	public ResponseEntity<Restaurent> createNote(@Valid @RequestBody Restaurent restaurent) {
		Restaurent restaurentData = restaurentService.save(restaurent);
		return new ResponseEntity<>(restaurentData, HttpStatus.OK);
	}

	@PostMapping("/restaurentUpdate/{nom}")
	public ResponseEntity<Restaurent> updateRestaurent(@PathVariable("nom") String nom, @Valid @RequestBody Restaurent restaurent) {
		Restaurent restaurentData = restaurentService.updateRestaurent(nom, restaurent);
		if(restaurentData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(restaurentData, HttpStatus.OK);
	}

}
