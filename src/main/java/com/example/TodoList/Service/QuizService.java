package com.example.TodoList.Service;

import com.example.TodoList.model.Question;
import com.example.TodoList.model.QuestionC;
import com.example.TodoList.model.Quiz;
import com.example.TodoList.model.Response;
import com.example.TodoList.repository.QestionDao;
import com.example.TodoList.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QestionDao qestionDao;


    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions = qestionDao.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "succes";


    }


    public List<QuestionC> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionC> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionC qc = new QuestionC(q.getId(),q.getTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qc);

        }
        return questionsForUser;

    }


    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findBy(id).get();
        List<Question> questions = quiz.getQuestions();
        int correct = 0;
        int i = 0;
        for(Response response : responses){
            if (response.getResponse().equals(questions.get(i).getCorrect()))
                correct++;

            i++;

        }
        return  correct;
    }

}
