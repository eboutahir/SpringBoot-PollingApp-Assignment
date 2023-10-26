package com.example.polling_application.repositories;

import com.example.polling_application.entities.Question;
import com.example.polling_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
