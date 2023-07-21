package com.masai.Entity;

import java.time.LocalDate;

import org.hibernate.sql.ComparisonRestriction.Operator;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Call {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int callId;
    private LocalDate callDate;
    private double callDuration;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id")
    private Operator operator;
}
