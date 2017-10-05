package com.connect.board.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.connect.board.service.RestaurentService;

@RestController
@CrossOrigin("*")
public class TestController {

	@Autowired
	RestaurentService restaurentService;

	@GetMapping("/name")
	public @ResponseBody List<String> findAll() {
		return restaurentService.findAll().stream().map(x -> x.getNom()).collect(Collectors.toList());
	}
}
