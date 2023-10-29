package TP3.Polling.App.Repositories;

import TP3.Polling.App.Models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository  extends JpaRepository <Vote, Long> {
    List<Vote> findByUserId(Long userId);
    List<Vote> findByOptionId(Long optionId);
    long countByOptionId(Long optionId);
}
