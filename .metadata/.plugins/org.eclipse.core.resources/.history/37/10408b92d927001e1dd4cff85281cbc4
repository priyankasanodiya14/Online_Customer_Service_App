package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.DepartmentRepository;
import com.masai.Repository.OperatorRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public Department addDepartment(Department d) throws LoginException {
        // Implement the logic to add a department
        Department savedDepartment = departmentRepository.save(d);
        return savedDepartment;
    }

    @Override
    public Department removeDepartment(int id) throws DepartmentException, LoginException {
        // Implement the logic to remove a department by its ID
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        Department department = departmentOptional.get();
        departmentRepository.delete(department);
        return department;
    }

    @Override
    public Department modifyDepartment(int id) throws DepartmentException, LoginException {
        // Implement the logic to modify a department
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        Department department = departmentOptional.get();
        // Implement the logic to modify the department attributes
        // For example, department.setName("New Name");
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department findDepartmentById(int id) throws DepartmentException, LoginException {
        // Implement the logic to find a department by its ID
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        }
        return departmentOptional.get();
    }

    @Override
    public Operator addOperator(Operator o) throws LoginException {
        // Implement the logic to add an operator
        Operator savedOperator = operatorRepository.save(o);
        return savedOperator;
    }

    @Override
    public Operator removeOperatorById(int id) throws OperatorException, LoginException {
        // Implement the logic to remove an operator by its ID
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        Operator operator = operatorOptional.get();
        operatorRepository.delete(operator);
        return operator;
    }

    @Override
    public Operator modifyOperator(int id) throws OperatorException, LoginException {
        // Implement the logic to modify an operator
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        Operator operator = operatorOptional.get();
        // Implement the logic to modify the operator attributes
        // For example, operator.setName("New Name");
        operatorRepository.save(operator);
        return operator;
    }

    @Override
    public Operator findOperatorById(int id) throws OperatorException, LoginException {
        // Implement the logic to find an operator by its ID
        Optional<Operator> operatorOptional = operatorRepository.findById(id);
        if (!operatorOptional.isPresent()) {
            throw new OperatorException("Operator not found");
        }
        return operatorOptional.get();
    }

    @Override
    public List<Operator> getAllOperators() throws LoginException {
        // Implement the logic to get all operators
        List<Operator> allOperators = operatorRepository.findAll();
        return allOperators;
    }
}
