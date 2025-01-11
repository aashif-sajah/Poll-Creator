package com.aashif.PollCreator.Controller;

import com.aashif.PollCreator.Services.PollService;
import com.aashif.PollCreator.model.Poll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aashif.PollCreator.request.Vote;

import java.util.List;


@RestController
@RequestMapping("/api/polls")
@CrossOrigin
public class PollController
{
    private final PollService pollService;

    public PollController(PollService pollService) {
        System.out.println();
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll)
    {
        System.out.println(poll.toString());
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls()
    {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id)
    {
        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote)
    {
        System.out.println(vote.toString());
         pollService.vote(vote.getPollId(),
                vote.getOptionIndex());
    }

}
