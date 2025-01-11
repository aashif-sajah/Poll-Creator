package com.aashif.PollCreator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Poll
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    private String question;

    @ElementCollection
    private List<OptionVote> options = new ArrayList<>();

    public String getQuestion() {
        return question;
    }

    public List<OptionVote> getOptions() {
        return options;
    }
}
