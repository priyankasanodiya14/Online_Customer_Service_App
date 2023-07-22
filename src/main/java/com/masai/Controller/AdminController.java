package com.masai.Controller;


import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) throws LoginException {
		Department savedDepartment = adminService.addDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@DeleteMapping("/departments/{departmentId}")
	public ResponseEntity<Object> removeDepartment(@PathVariable int departmentId) throws DepartmentException, LoginException {
		Department removedDepartment = adminService.removeDepartment(departmentId);
		return new ResponseEntity<>(removedDepartment, HttpStatus.OK);
	}

	@PutMapping("/departments/{departmentId}/{name}")
	public ResponseEntity<Object> modifyDepartment(@PathVariable int departmentId,@PathVariable String name) throws DepartmentException, LoginException {
		Department modifiedDepartment = adminService.modifyDepartment(departmentId,name);
		return new ResponseEntity<>(modifiedDepartment, HttpStatus.OK);
	}

	@GetMapping("/departments/{departmentId}")
	public ResponseEntity<Object> findDepartmentById(@PathVariable int departmentId) throws DepartmentException, LoginException {
		Department department = adminService.findDepartmentById(departmentId);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PostMapping("/operators/{did}")
	public ResponseEntity<Operator> addOperator(@Valid @RequestBody Operator operator,@PathVariable int did) throws LoginException, DepartmentException {
		Operator savedOperator = adminService.addOperator(operator,did);
		return new ResponseEntity<>(savedOperator, HttpStatus.CREATED);
	}

	@DeleteMapping("/operators/{operatorId}")
	public ResponseEntity<Object> removeOperator(@PathVariable int operatorId) throws OperatorException, LoginException {
		Operator removedOperator = adminService.removeOperatorById(operatorId);
		return new ResponseEntity<>(removedOperator, HttpStatus.OK);
	}

	@PutMapping("/operators/{operatorId}")
	public ResponseEntity<Object> modifyOperator(@PathVariable int operatorId, @RequestBody Operator operator) throws OperatorException, LoginException {
		Operator modifiedOperator = adminService.modifyOperator(operatorId, operator);
		return new ResponseEntity<>(modifiedOperator, HttpStatus.OK);
	}

	@GetMapping("/operators/{operatorId}")
	public ResponseEntity<Object> findOperatorById(@PathVariable int operatorId) throws OperatorException, LoginException {
		Operator operator = adminService.findOperatorById(operatorId);
		return new ResponseEntity<>(operator, HttpStatus.OK);
	}

	@GetMapping("/operators")
	public ResponseEntity<List<Operator>> getAllOperators() throws LoginException {
		List<Operator> allOperators = adminService.getAllOperators();
		return new ResponseEntity<>(allOperators, HttpStatus.OK);
	}
}
