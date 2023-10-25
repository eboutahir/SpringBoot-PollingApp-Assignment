package com.example.polling_application.repositories;


import com.example.polling_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}