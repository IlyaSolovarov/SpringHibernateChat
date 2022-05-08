package com.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}