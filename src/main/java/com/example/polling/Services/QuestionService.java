package com.example.polling.Services;

import com.example.polling.domains.Questions;

import java.util.List;

public interface QuestionService {


    public List<Questions> createQuestionsForForm(Long id, List<Questions> questions);



}
