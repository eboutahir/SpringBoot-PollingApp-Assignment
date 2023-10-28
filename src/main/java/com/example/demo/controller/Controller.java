package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Formquiz;
import com.example.demo.model.Result;
import com.example.demo.service.ServiceQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@org.springframework.stereotype.Controller

public class Controller {
	
	@Autowired
	Result result;
	@Autowired
	ServiceQuiz qService;
	
	Boolean submitted = false;
	//retourner la page html index
	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	/*private final QuizService quizService;

	public MainController(QuizService quizService) {
		this.quizService = quizService;
	}*/

	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	

	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		if(username.equals("")) {
			ra.addFlashAttribute("warning", "Champs obligatoire ,entrer votre nom");
			return "redirect:/";
		}
		submitted =false;
		result.setUsername(username);

		Formquiz qForm = qService.getQuestions();
		m.addAttribute("qForm", qForm);
		return "pagequiz.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute Formquiz qForm, Model m) {
		if(!submitted) {
			result.setTotalCorrect(qService.getResultat(qForm));
			qService.saveScore(result);
			submitted = true;
		}
		
		return "resultat.html";
	}
	
	@GetMapping("/score")
	public String score(Model m) {
		List<Result> sList = qService.getTopScore();
		m.addAttribute("sList", sList);
		
		return "pagescore.html";
	}
	@DeleteMapping ("/{id}/delete")
	public String deleteScore(@PathVariable int id) {
		ServiceQuiz.deleteScore(id);
		return "redirect:/score";
	}

}
