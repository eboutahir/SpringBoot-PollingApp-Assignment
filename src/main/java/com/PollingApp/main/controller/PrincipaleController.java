package com.PollingApp.main.controller;

import java.util.List;

import com.PollingApp.main.models.QuestionChoix;
import com.PollingApp.main.models.Resultat;
import com.PollingApp.main.service.QuestionnairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PrincipaleController {
	
	@Autowired
	Resultat result;
	@Autowired
	QuestionnairService qService;
	
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Resultat getResult() {
		return result;
	}
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, String email, Model m, RedirectAttributes ra) {
		if(username.equals("") || email.equals("")) {
			ra.addFlashAttribute("warning", "You must enter your name");
			return "redirect:/";
		}
		
		submitted = false;
		result.setUsername(username);

		
		QuestionChoix qForm = qService.getQuestions();
		m.addAttribute("qForm", qForm);
		
		return "Questionnaire.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionChoix qForm, Model m) {
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted = true;
		}
		return "result.html";
	}
	
	@GetMapping("/score")
	public String score(Model m) {
		List<Resultat> sList = qService.getTopScore();
		m.addAttribute("sList", sList);
		
		return "scoreboard.html";
	}

}
