package com.masai.Service;

import java.util.List;

import com.masai.Entity.Admin;
import com.masai.Entity.Customer;
import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.CustomerException;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;


public interface AdminService {
	Department addDepartment(Department department) throws LoginException;

	Department removeDepartment(int departmentId) throws DepartmentException, LoginException;

	Department modifyDepartment(int deparmentId,String name) throws DepartmentException, LoginException;

	Department findDepartmentById(int deparmentId) throws DepartmentException, LoginException;

	Operator addOperator(Operator operator,int departId) throws LoginException, DepartmentException;

	Operator removeOperatorById(int operatorId) throws OperatorException, LoginException;

	Operator modifyOperator(int operatorId,Operator operator) throws OperatorException, LoginException;

	Operator findOperatorById(int idoperatorId) throws OperatorException, LoginException;

	List<Operator> getAllOperators() throws LoginException;
	
	Admin createAdmin(Admin admin) throws LoginException;

	Admin login(String username, String password);
	Admin findByUsername(String username) throws LoginException;
}
