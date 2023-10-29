package TP3.Polling.App.Services;

import TP3.Polling.App.Models.Option;
import TP3.Polling.App.Models.Poll;
import TP3.Polling.App.Repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService
{
    private final OptionRepository optionRepository;

    @Autowired
    public OptionService (OptionRepository optionRepository)
    {
        this.optionRepository= optionRepository;
    }

    public List<Option> getAllOptions()
    {
        return optionRepository.findAll();
    }

    public Option getOptionById(Long id)
    {
        return optionRepository.findById(id).orElse(null);
    }

    public Option creatOption(Option option)
    {
        return optionRepository.save(option);
    }


    public Option updateOption(Long id , Option option)
    {
        Option existingOption=optionRepository.findById(id).orElse(null);
        if (existingOption!=null)
        {
            existingOption.setContent(option.getContent());
            existingOption.setQuestions(option.getQuestions());
        }
        return null;
    }


    public void deleteOption (Long id)
    {
        optionRepository.deleteById(id);
    }

    public List<Option> getOptionsByQuestionId(Long questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

}
