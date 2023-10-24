package com.example.polling.Services;

import com.example.polling.domains.Answers;
import com.example.polling.domains.Form;
import com.example.polling.domains.Questions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface FormService {

    public Form createForm(Form form);
    public Form getForm(Long id);
    public List<Form> getAllForms();
    public List<Questions> getFormWithQuestions(Long formid);
    public List<Answers> getFormWithAnswers(Long formid);

}
