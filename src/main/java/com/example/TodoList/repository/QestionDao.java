package com.example.TodoList.repository;


import com.example.TodoList.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM questio q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);

}
