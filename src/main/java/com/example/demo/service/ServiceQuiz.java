package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Question;
import com.example.demo.model.Formquiz;
import com.example.demo.repository.QuestionRepo;
import com.example.demo.repository.ResultRepo;

@Service
public class ServiceQuiz {
	
	@Autowired
	Question question;
	@Autowired
	Formquiz qForm;
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	Result result;
	@Autowired
	ResultRepo rRepo;
	/*private final QuestionRepo queRepository;

	public QuizService(QuestionRepo queRepository, ResultRepo reRepository) {
		this.queRepository = queRepository;
		this.reRepository = reRepository;
	}
	private final ResultRepo reRepository;*/

////methode sans verification causer erreur 500
	/*public QuestionForm getQuestions() {
		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);
		
		return qForm;
	}*/
	/*baçy khasani fct pour fair afficher les question correctes et fausses*/
	public Formquiz getQuestions() {
		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();

		if (!allQues.isEmpty()) { // Vérifie que la liste n'est pas vide
			Random random = new Random();

			for (int i = 0; i < 5; i++) {
				int rand = random.nextInt(allQues.size());
				qList.add(allQues.get(rand));
				allQues.remove(rand);
			}
		}

		qForm.setQuestions(qList);

		return qForm;
	}
	public static void deleteScore(int id) {

	}

/*	public int getResult(QuestionForm qForm) {
		int correct = 0;
		
		for(Question q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
	*/
public int getResultat(Formquiz qForm) {
	int correct = 0;

	List<Question> questions = qForm.getQuestions();

	if (questions != null) {
		for (Question q : questions) {
			if (q.getAns() == q.getChose()) {
				correct++;
			}
		}
	}

	return correct;
}

	public void saveScore(Result result) {
		Result saveResult = new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	public List<Result> getTopScore() {
		List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		
		return sList;
	}
}
