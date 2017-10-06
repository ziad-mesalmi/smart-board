package com.connect.board.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.connect.board.service.RestaurentService;

@RestController
@CrossOrigin("*")
public class TestController {

	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	RestaurentService restaurentService;

	@GetMapping("/name")
	public @ResponseBody List<String> findAll() {
		logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
		return restaurentService.findAll().stream().map(x -> x.getNom()).collect(Collectors.toList());
	}
}
