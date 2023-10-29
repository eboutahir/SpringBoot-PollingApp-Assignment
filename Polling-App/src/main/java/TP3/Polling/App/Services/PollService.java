package TP3.Polling.App.Services;

import TP3.Polling.App.Models.Option;
import TP3.Polling.App.Models.Poll;
import TP3.Polling.App.Models.Question;
import TP3.Polling.App.Repositories.OptionRepository;
import TP3.Polling.App.Repositories.PollRepository;
import TP3.Polling.App.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService
{
    private final PollRepository pollRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public PollService(PollRepository pollRepository, QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.pollRepository = pollRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    public List<Poll> getAllPolls() {
        List<Poll> polls = pollRepository.findAll();

        for (Poll poll : polls) {
            List<Question> questions = questionRepository.findByPollId(poll.getId());
            for (Question question : questions) {
                List<Option> options = optionRepository.findByQuestionId(question.getId());
                question.setOptions(options);
            }
            poll.setQuestions(questions);
        }

        return polls;
    }


    public Poll getPollById(Long id) {
        return pollRepository.findById(id).orElse(null);
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }


    public Poll updatePoll(Long pollId, Poll poll) {
        Poll existingPoll = pollRepository.findById(pollId).orElse(null);
        if (existingPoll != null) {
        existingPoll.setTitle(poll.getTitle());
        existingPoll.setDescription(poll.getDescription());
           Poll updatedPoll= pollRepository.save(existingPoll);
        }
        return null;
    }


    public void deletePoll(Long id) {

        pollRepository.deleteById(id);
    }
}
