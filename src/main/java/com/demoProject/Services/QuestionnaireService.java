package com.demoProject.Services;

import com.demoProject.Models.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionnaireService {
    List<Questionnaire> getAllQuestionnaires();
    Questionnaire createQuestionnaire(Questionnaire questionnaire);
}
