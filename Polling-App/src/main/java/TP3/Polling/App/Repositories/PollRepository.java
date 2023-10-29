package TP3.Polling.App.Repositories;

import TP3.Polling.App.Models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>
{


}
