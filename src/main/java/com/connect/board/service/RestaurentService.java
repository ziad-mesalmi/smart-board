package com.connect.board.service;

import java.util.List;

import com.connect.board.model.Restaurent;

public interface RestaurentService {
	
	List<Restaurent> findByNom(String nom);
	
	List<Restaurent> findAll();

	Restaurent updateRestaurent(String nom, Restaurent restaurent);

	Restaurent save(Restaurent restaurent);

}
