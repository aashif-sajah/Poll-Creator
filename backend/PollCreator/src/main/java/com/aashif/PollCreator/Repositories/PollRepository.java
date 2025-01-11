package com.aashif.PollCreator.Repositories;

import com.aashif.PollCreator.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PollRepository extends JpaRepository<Poll, Long>
{

}
