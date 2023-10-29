package TP3.Polling.App.Services;

import TP3.Polling.App.Models.User;
import TP3.Polling.App.Models.Vote;
import TP3.Polling.App.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService
{
    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }



    public List<Vote>  getAllVotes()
    {
        return voteRepository.findAll();
    }
    public List<Vote> getVotesByUser(Long userId) {
        return voteRepository.findByUserId(userId);
    }

    public List<Vote> getVotesByOption(Long optionId) {
        return voteRepository.findByOptionId(optionId);
    }

    public Vote getVoteById(Long voteId) {
        return voteRepository.findById(voteId).orElse(null);
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }


    public Vote updateVote(Long voteId, Vote vote) {
        Vote existingVote = voteRepository.findById(voteId).orElse(null);

        if (existingVote != null) {
            existingVote.setOption(vote.getOption());
            existingVote.setUser(vote.getUser());

            Vote UpdateVote= voteRepository.save(existingVote);
        }

        return null;
    }


    public void deleteVote(Long voteId) {
            voteRepository.deleteById(voteId);
    }

    public long getVoteCountForOption(Long optionId) {
        return voteRepository.countByOptionId(optionId);
    }


}
