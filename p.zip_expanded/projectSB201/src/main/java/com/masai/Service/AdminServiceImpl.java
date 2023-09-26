package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Admin;
import com.masai.Entity.Customer;
import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.CustomerException;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;
import com.masai.Repository.AdminRepository;
import com.masai.Repository.DepartmentRepository;
import com.masai.Repository.OperatorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	AdminRepository adminRepository;
  
	@Override
	public Admin findByUsername(String username) throws LoginException {
	Admin opt= adminRepository.findByUsername(username);
		 if(opt == null) throw new LoginException("No user found");
		 return opt;
	}
	
	
	@Override
	public Admin createAdmin(Admin admin) throws LoginException {
		admin.setUsername(admin.getEmail());
		Admin ad = adminRepository.save(admin);
		return ad;
	}

	@Override
	public Admin login(String username, String password) {
		return adminRepository.findByUsernameAndPassword(username, password);
		
	}

	@Override
	public Department addDepartment(Department department) throws LoginException {
		log.info("Department Added");
		Department savedDepartment = departmentRepository.save(department);
		return savedDepartment;
	}

	@Override
	public Department removeDepartment(int deparmentId) throws DepartmentException, LoginException {
		log.info("Department has been Removed");
		Optional<Department> departmentOptional = departmentRepository.findById(deparmentId);
		if (!departmentOptional.isPresent()) {
			throw new DepartmentException("Department not found");
		}
		Department department = departmentOptional.get();
		departmentRepository.delete(department);
		return department;
	}

	@Override
	public Department modifyDepartment(int deparmentId, String name) throws DepartmentException, LoginException {
		log.info("Department has beed modified");
		Optional<Department> departmentOptional = departmentRepository.findById(deparmentId);
		if (!departmentOptional.isPresent()) {
			throw new DepartmentException("Department not found");
		}
		Department department = departmentOptional.get();
		department.setDepartmentName(name);
		departmentRepository.save(department);
		return department;
	}

	@Override
	public Department findDepartmentById(int deparmentId) throws DepartmentException, LoginException {
		log.info("Department findDepartmentById method called");
		Optional<Department> departmentOptional = departmentRepository.findById(deparmentId);
		if (!departmentOptional.isPresent()) {
			throw new DepartmentException("Department not found");
		}
		return departmentOptional.get();
	}

	@Override
	public Operator addOperator(Operator operator, int departmentId) throws LoginException, DepartmentException {
		Department depart = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new DepartmentException("Department not found"));

		operator.setUsername(operator.getEmail());
		operator.setDepartment(depart);

		List<Operator> li = depart.getOperators();
		li.add(operator);
		Operator savedOperator = operatorRepository.save(operator);
		return savedOperator;
	}

	@Override
	public Operator removeOperatorById(int operaterId) throws OperatorException, LoginException {
		Optional<Operator> operatorOptional = operatorRepository.findById(operaterId);
		if (!operatorOptional.isPresent()) {
			throw new OperatorException("Operator not found");
		}
		Operator operator = operatorOptional.get();
		operatorRepository.delete(operator);
		return operator;
	}

	@Override
	public Operator modifyOperator(int operatorId, Operator op) throws OperatorException, LoginException {
		Optional<Operator> operatorOptional = operatorRepository.findById(operatorId);

		if (!operatorOptional.isPresent()) {
			throw new OperatorException("Operator not found");
		}
		Operator operator = operatorOptional.get();

		operator.setFirstName(op.getFirstName());
		operator.setLastName(op.getLastName());
		operator.setEmail(op.getEmail());
		operator.setCity(op.getCity());
		operator.setMobile(op.getMobile());
		return operatorRepository.save(operator);

	}

	@Override
	public Operator findOperatorById(int operatorId) throws OperatorException, LoginException {
		Optional<Operator> operatorOptional = operatorRepository.findById(operatorId);
		if (!operatorOptional.isPresent()) {
			throw new OperatorException("Operator not found");
		}
		return operatorOptional.get();
	}

	@Override
	public List<Operator> getAllOperators() throws LoginException {
		List<Operator> allOperators = operatorRepository.findAll();
		return allOperators;
	}

}
