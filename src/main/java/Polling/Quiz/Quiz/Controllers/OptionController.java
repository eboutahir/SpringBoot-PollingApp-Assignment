package Polling.Quiz.Quiz.Controllers;

import Polling.Quiz.Quiz.Models.Option;
import Polling.Quiz.Quiz.Services.OptionServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Options")
public class OptionController {
    @Autowired
    OptionServ optionServ;
    @PostMapping("/{id}")
    public Option createOption (@RequestBody Option option ) {
        return optionServ.createOption(option);
    }

   @GetMapping("/{id}")
    public Optional<Option> getById (@PathVariable Integer id ) {
        return optionServ.getById(id);
    }

   @GetMapping
    public List<Option> getAllOptions () {
        return optionServ.getAllOptions();
    }

    @PutMapping("/{id}")
    public void updateOption (@PathVariable Option option) {
        optionServ.updateOption(option);
    }

   @DeleteMapping("/{id}")
    public void deleteOption (@PathVariable Integer id ) {
       optionServ.deleteOption (id);
    }
}
