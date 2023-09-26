package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @NotNull(message = "Department_name should not be empty!")
    private String departmentName;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Operator> operators = new ArrayList<>();

    public Department(@NotNull(message = "Department_name should not be empty!") String departmentName) {
        super();
        this.departmentName = departmentName;
    }
}
