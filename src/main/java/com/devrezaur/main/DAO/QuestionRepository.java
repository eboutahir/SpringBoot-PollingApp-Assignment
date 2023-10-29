package com.devrezaur.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devrezaur.main.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}