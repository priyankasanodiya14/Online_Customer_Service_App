package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer>{


}
