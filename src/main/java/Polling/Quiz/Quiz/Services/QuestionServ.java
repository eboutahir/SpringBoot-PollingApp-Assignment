package Polling.Quiz.Quiz.Services;



import Polling.Quiz.Quiz.Models.Option;
import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Models.Quiz;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;
import java.util.Optional;

public interface QuestionServ {
    Question createQuestion( Question question);
    Optional<Question> getByIdQues( Integer id);
    List<Question> getAllQuestions();
    void updateQuestion(Question question);
    void deleteQuestion(Integer id);
    List<Option> getOptionsForQuestion( Integer questionId);
}
