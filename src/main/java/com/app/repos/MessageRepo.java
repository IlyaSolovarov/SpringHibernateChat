package com.app.repos;

import org.springframework.data.repository.CrudRepository;
import com.app.domain.Message;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MessageRepo extends CrudRepository<Message, Integer> {

}