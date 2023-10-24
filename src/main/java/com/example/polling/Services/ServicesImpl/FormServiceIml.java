package com.example.polling.Services.ServicesImpl;

import com.example.polling.Repository.AnswersRepo;
import com.example.polling.Repository.FormRepo;
import com.example.polling.Repository.QuestionRepo;
import com.example.polling.Services.FormService;
import com.example.polling.domains.Answers;
import com.example.polling.domains.Form;
import com.example.polling.domains.Questions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class FormServiceIml implements FormService {

    private FormRepo formRepo;


    private QuestionRepo questionRepo;

    private AnswersRepo answersRepo;


    public Form createForm(Form form) {
        return formRepo.save(form);
    }

    public Form getForm(Long id) {
        return formRepo.getFormById(id);
    }

    public List<Form> getAllForms() {
        return formRepo.findAll();
    }

    public List<Questions> getFormWithQuestions(Long formId) {
        Form form = formRepo.findById(formId).orElse(null);

        if (form != null) {
            return questionRepo.getQuestionsByformId(formId);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Answers> getFormWithAnswers(Long formid) {
        Form form = formRepo.findById(formid).orElse(null);

        if (form != null) {
            return answersRepo.getAnswersByformId(formid);
        } else {
            return Collections.emptyList();
        }    }

}
