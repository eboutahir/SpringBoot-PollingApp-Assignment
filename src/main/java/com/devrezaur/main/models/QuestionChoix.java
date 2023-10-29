package com.devrezaur.main.models;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionChoix {

	private List<Question> questions;
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
