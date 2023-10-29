package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.Option;

import java.util.List;
import java.util.Optional;

public interface OptionServ {
 Option createOption(Option option);
 Optional<Option> getById( Integer id);
 List<Option> getAllOptions();
 void updateOption(Option option);
 void deleteOption(Integer id);
 //Method to get all options associated with a specific question.
 List<Option> getOptionsByQuestion(Integer question_id);
}
