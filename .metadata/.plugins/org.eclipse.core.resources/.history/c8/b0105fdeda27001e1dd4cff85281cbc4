package com.masai.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Operator {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int operatorId;

	@NotNull(message = "Operator name should not be empty!")
    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    @Email(message = "email should be formatted!")
    @NotNull(message = "Operator name should not be empty!")
    private String email;
    private String mobile;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;

    @JsonIgnore
    @OneToMany(mappedBy = "operator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Call> calls;

	public Operator(@NotNull(message = "Operator name should not be empty!") String firstName, String lastName,
			@Email(message = "email should be formatted!") @NotNull(message = "Operator name should not be empty!") String email,
			String mobile, String city, Department department, Login login) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.department = department;
		this.login = login;
	}
    
    
}
