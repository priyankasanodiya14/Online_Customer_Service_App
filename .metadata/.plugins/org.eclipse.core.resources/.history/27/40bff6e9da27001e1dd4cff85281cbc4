package com.masai.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Solution {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int solutionId;
	    private String solutionDescription;
	    private Date solutionDate;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "issue_id")
	    private Issue issue;
}
