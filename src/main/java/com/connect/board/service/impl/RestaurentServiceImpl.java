package com.connect.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect.board.model.Restaurent;
import com.connect.board.repo.RestaurentRepository;
import com.connect.board.service.RestaurentService;

@Service
public class RestaurentServiceImpl implements RestaurentService {

	@Autowired
	RestaurentRepository restaurentRepo;

	@Override
	public List<Restaurent> findByNom(String nom) {
		return restaurentRepo.findByNom(nom);
	}

	@Override
	public List<Restaurent> findAll() {
		return restaurentRepo.findAll();
	}

	public RestaurentRepository getRestaurentRepo() {
		return restaurentRepo;
	}

	@Override
	public Restaurent updateRestaurent(String nom, Restaurent restaurent) {

		Restaurent restaurentData = restaurentRepo.findOne(nom);
		restaurentData.setNom(restaurent.getNom());
		restaurentData.setAdresse(restaurent.getAdresse());
		Restaurent updatedTodo = restaurentRepo.save(restaurentData);
		return updatedTodo;
	}

	@Override
	public Restaurent save(Restaurent restaurent) {
		return restaurentRepo.save(restaurent);
	}
}
