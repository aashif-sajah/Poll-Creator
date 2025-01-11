package com.aashif.PollCreator.Services;

import com.aashif.PollCreator.Repositories.PollRepository;
import com.aashif.PollCreator.model.OptionVote;
import com.aashif.PollCreator.model.Poll;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls()
    {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id)
    {
        return pollRepository.findById(id);
    }

    public void vote(long pollId, int optionIndex)
    {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        List<OptionVote> options = poll.getOptions();

        if (optionIndex < 0 || optionIndex >= options.size())
        {
            throw new IllegalArgumentException("Invalid option index");
        }

        OptionVote selectedOption = options.get(optionIndex);

        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        pollRepository.save(poll);
    }
}
