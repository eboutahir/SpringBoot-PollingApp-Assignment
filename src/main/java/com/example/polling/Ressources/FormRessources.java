package com.example.polling.Ressources;

import com.example.polling.Services.FormService;
import com.example.polling.domains.Answers;
import com.example.polling.domains.Form;
import com.example.polling.domains.Questions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/Form")
public class FormRessources {

    private FormService formService;

    @PostMapping(value = "create")
    public Form createForm(@RequestBody  Form form){
        return formService.createForm(form);
    }
    @GetMapping("/get/{id}")
    public Form getForm(@PathVariable  Long id){
        return formService.getForm(id);
    }
    @GetMapping(value = "getAll")
    public List<Form> getAllForm(){
        return formService.getAllForms();
    }
    @GetMapping(value = "getFormWithQuestions/{formId}")
    public List<Questions> getFormWithQuestions(@PathVariable Long formId){
        return formService.getFormWithQuestions(formId);
    }
    @GetMapping(value = "getFormWithAnswers/{formId}")
    public List<Answers> getFormWithAnswers(@PathVariable Long formId){
        return formService.getFormWithAnswers(formId);
    }
}
