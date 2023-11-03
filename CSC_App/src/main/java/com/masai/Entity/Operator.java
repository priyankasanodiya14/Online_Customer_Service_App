package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.masai.Utility.generatorOtp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operator extends Login {
    
   @Column(unique = true)
   @JsonIgnore
    private int operatorId = generatorOtp.generate();

    @NotNull(message = "Operator name should not be empty!")
    private String firstName;
    private String lastName;

    @Column(unique = true)
    @Email(message = "email should be formatted!")
    @NotNull(message = "Operator name should not be empty!")
    private String email;

    @NotNull(message = "mobile should not be empty!")
    private String mobile;
    private String city;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
   
    @JsonIgnore
    @OneToMany(mappedBy = "operator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Call> calls = new ArrayList<>();
}
