package com.example.rediswithsql.repository;

import com.example.rediswithsql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
