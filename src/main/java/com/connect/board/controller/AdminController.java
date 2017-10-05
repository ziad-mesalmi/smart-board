package com.connect.board.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AdminController {

  /* Maps to all HTTP actions by default (GET,POST,..)*/
  @RequestMapping("/admin")
  public @ResponseBody String getUsers() {
    return "{\"admins\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
           "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
  }
  
  @GetMapping("/aboutme")
	public @ResponseBody String about() {
		return "about admins";
	}
}
