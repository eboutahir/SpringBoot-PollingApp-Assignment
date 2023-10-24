package com.example.polling.Services.ServicesImpl;

import com.example.polling.Repository.QuestionRepo;
import com.example.polling.Services.QuestionService;
import com.example.polling.domains.Answers;
import com.example.polling.domains.Questions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepo questionRepo;

    @Override
    public List<Questions> createQuestionsForForm(Long id, List<Questions> questions) {
        for (Questions question : questions) {
            question.setFormId(id);
        }

        return questionRepo.saveAll(questions);

    }

}

