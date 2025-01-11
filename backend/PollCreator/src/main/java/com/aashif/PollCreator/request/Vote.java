package com.aashif.PollCreator.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Vote
{
    private long pollId;
    private int optionIndex;

    public int getOptionIndex() {
        return optionIndex;
    }

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }
    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    public String toString()
    {
        return "Vote [pollId=" + pollId + ", optionIndex=" + optionIndex + "]";
    }
}
