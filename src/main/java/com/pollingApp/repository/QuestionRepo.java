package com.pollingApp.repository;

import com.pollingApp.Entite.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}