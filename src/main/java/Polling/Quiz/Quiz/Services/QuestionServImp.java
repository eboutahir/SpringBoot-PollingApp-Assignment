package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.Option;
import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Repositories.QuestionRepo;
import Polling.Quiz.Quiz.Repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServImp implements QuestionServ{
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    QuizRepo quizRepo;
    @Override
    public Question createQuestion ( Question question ) {
        return questionRepo.save(question);
    }

    @Override
    public Optional<Question> getByIdQues ( Integer id ) {
        return questionRepo.findById (id);
    }

    @Override
    public List<Question> getAllQuestions () {
        return questionRepo.findAll ();
    }

    @Override
    public void updateQuestion ( Question question ) {
        questionRepo.save (question);
    }

    @Override
    public void deleteQuestion ( Integer id ) {
        questionRepo.deleteById (id);
    }
    public List<Option> getOptionsForQuestion( Integer questionId) {
        Optional<Question> question = getByIdQues(questionId);
        if (question.isPresent ()) {
            return question.get().getOptions ();
        }
        return null;
    }

}
