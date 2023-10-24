package com.example.polling.Services.ServicesImpl;

import com.example.polling.Repository.AnswersRepo;
import com.example.polling.Services.AnswerService;
import com.example.polling.domains.Answers;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private AnswersRepo answersRepo;

    @Override
    public List<Answers> createAnswersForForm(Long id, List<Answers> answers) {
        for (Answers answer : answers) {
            answer.setFormId(id);
        }

         return answersRepo.saveAll(answers);

    }
}
