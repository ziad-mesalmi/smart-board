package com.connect.board.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect.board.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
}
