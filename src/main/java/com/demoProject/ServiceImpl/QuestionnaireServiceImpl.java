package com.demoProject.ServiceImpl;

import com.demoProject.Models.Questionnaire;
import com.demoProject.Repository.QuestionnaireRepository;
import com.demoProject.Services.QuestionnaireService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository quesRepository;

    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return quesRepository.findAll();
    }

    @Override
    public Questionnaire createQuestionnaire(Questionnaire questionnaire) {
        // Vous pouvez ajouter des validations ici.
        return quesRepository.save(questionnaire);
    }
}
