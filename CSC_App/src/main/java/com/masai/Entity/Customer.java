package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.masai.Utility.generatorOtp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Customer extends Login {
//	
    @Column(unique = true)
    @JsonIgnore
    private int customerId = generatorOtp.generate();

    @NotNull(message = "name should not be empty!")
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @Email(message = "email should be formatted!")
    @NotNull(message = "email should not be empty!")
    private String email;

    @NotNull(message = "mobile should not be empty!")
    private String mobile;
    private String city;

    private boolean isActive = true;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Issue> issues = new ArrayList<>();

     
}
