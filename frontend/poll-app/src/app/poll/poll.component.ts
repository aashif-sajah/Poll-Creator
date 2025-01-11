import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})
export class PollComponent implements OnInit{
  newPoll: Poll = {
    id: 0,
    question: "",
    options: [
      {
        voteOption: "",
        voteCount: 0
      },
      {
        voteOption: "",
        voteCount: 0
      }
    ]
  }
  polls: Poll[] = [];

  constructor(private pollService: PollService)
  {

  }

  ngOnInit(): void
  {
    this.loadPolls();
  }

  loadPolls()
  {
    this.pollService.getPolls()
    .subscribe
    ({
        next: (data) =>
        {
          this.polls = data;
        },
        error: (error) =>
        {
          console.error("Error Fetching the Polls",error);
        }
    });
  }

  createPoll()
  {
    console.log(this.newPoll);
    this.pollService.createPoll(this.newPoll)
    .subscribe
    ({
        next: (data) =>
        {
         this.polls.push(data);
         this.resetPoll();
         this.loadPolls();
        },
        error: (error) =>
        {
          console.error("Error Creating the Poll",error);
        }
    });
  }

  resetPoll()
  {
    this.newPoll = {
      id: 0,
      question: "",
      options: [
        {
          voteOption: "",
          voteCount: 0
        },
        {
          voteOption: "",
          voteCount: 0
        }
      ]
    }
  }

  vote(pollId: number, optionIndex: number)
  {
    console.log(pollId, optionIndex);
    this.pollService.vote(pollId, optionIndex)
    .subscribe
    ({
        next: () =>
        {
          this.loadPolls();
        },
        error: (error) =>
        {
          console.error("Error Voting the Poll",error);
        }
    });
  }

  addOption()
  {
    this.newPoll.options.push({
      voteOption: "",
      voteCount: 0
    });
  }
}
