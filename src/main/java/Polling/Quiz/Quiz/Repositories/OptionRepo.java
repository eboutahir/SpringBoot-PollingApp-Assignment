package Polling.Quiz.Quiz.Repositories;

import Polling.Quiz.Quiz.Models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<Option,Integer> {

}
