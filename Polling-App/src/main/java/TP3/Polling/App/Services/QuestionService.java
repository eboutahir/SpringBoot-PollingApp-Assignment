package TP3.Polling.App.Services;

import TP3.Polling.App.Models.Question;
import TP3.Polling.App.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }


    public Question createQuestion(Question question) {

       return questionRepository.save(question);
    }


    public Question updateQuestion(Long questionId, Question question) {

        Question existingQuestion = questionRepository.findById(questionId).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setContent(question.getContent());
            //existingQuestion.setOptions(question.getOptions());
            existingQuestion.setPoll(question.getPoll());
          Question updatedQuestion=  questionRepository.save(existingQuestion);
        }
        return null;
    }


    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getQuestionsByPollId(Long pollId) {
        return questionRepository.findByPollId(pollId);
    }



}
