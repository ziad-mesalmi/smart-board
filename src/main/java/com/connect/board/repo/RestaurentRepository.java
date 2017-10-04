package com.connect.board.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.connect.board.model.Restaurent;

public interface RestaurentRepository extends MongoRepository<Restaurent, String> {
	
//	Restaurent findFirstByName(String nom);
//
//	Restaurent findByNomAndAdresse(String nom, String Adresse);
//
//    //Supports native JSON query string
//    @Query("{restaurent:'?0'}")
//    Restaurent findCustomByNom(String nom);
//
//    @Query("{restaurent: { $regex: ?0 } })")
//    List<Restaurent> findCustomByRegExNom(String nom);
	
	List<Restaurent> findByNom(@Param("nom") String nom);
}
