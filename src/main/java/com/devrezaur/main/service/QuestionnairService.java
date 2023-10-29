package com.devrezaur.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.devrezaur.main.models.Question;
import com.devrezaur.main.models.QuestionChoix;
import com.devrezaur.main.models.Resultat;
import com.devrezaur.main.DAO.QuestionRepository;
import com.devrezaur.main.DAO.ResultatRepository;

@Service
public class QuestionnairService {

	@Autowired
	Question question;
	@Autowired
	QuestionChoix qForm;
	@Autowired
	QuestionRepository qRepo;
	@Autowired
	Resultat result;
	@Autowired
	ResultatRepository rRepo;

	public QuestionChoix getQuestions() {
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
	}

	public int getResult(QuestionChoix qForm) {
		int correct = 0;

		for(Question q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;

		return correct;
	}

	public void saveScore(Resultat result) {
		Resultat saveResult = new Resultat();
		saveResult.setUsername(result.getUsername());
		saveResult.setEmail(result.getEmail());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}

	public List<Resultat> getTopScore() {
		List<Resultat> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
		return sList;
	}
}
