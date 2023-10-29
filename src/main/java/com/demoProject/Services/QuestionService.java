package com.demoProject.Services;

import com.demoProject.Models.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<Question> getAllQuestions();

    Question saveQuestion(Question question);

}
