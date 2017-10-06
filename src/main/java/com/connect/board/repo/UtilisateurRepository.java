package com.connect.board.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect.board.model.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
	Utilisateur findByUsername(String username);
}
