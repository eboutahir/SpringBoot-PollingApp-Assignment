package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.Option;
import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Repositories.OptionRepo;
import Polling.Quiz.Quiz.Repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OptionServImp implements OptionServ {

    @Autowired
    private OptionRepo optionRepo;
    @Autowired
    QuestionRepo questionRepository;

    @Override
    public Option createOption ( Option option ) {
        return optionRepo.save(option);
    }

    @Override
    public Optional<Option> getById ( Integer id ) {
        return optionRepo.findById(id);
    }

    @Override
    public List<Option> getAllOptions () {
        return optionRepo.findAll();
    }

    @Override
    public void updateOption (Option option) {
        optionRepo.save(option);
    }

    @Override
    public void deleteOption ( Integer id ) {
        optionRepo.deleteById (id);
    }

    @Override
    public List<Option> getOptionsByQuestion ( Integer question_id ) {
        // This method retrieves options associated with a specific question

        Question question = questionRepository.findById(question_id).orElse(null);
        if (question != null) {
            return question.getOptions();
        }
        return new ArrayList<> (); // Handle cases where the question doesn't exist
    }
}
