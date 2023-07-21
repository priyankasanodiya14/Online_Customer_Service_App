
package com.masai.Service;


import java.util.List;

import com.masai.Entity.Department;
import com.masai.Entity.Operator;
import com.masai.Exception.DepartmentException;
import com.masai.Exception.LoginException;
import com.masai.Exception.OperatorException;


public interface AdminService {

	Department addDepartment(Department d) throws LoginException;

	Department removeDepartment(int id) throws DepartmentException, LoginException;

	Department modifyDepartment(int id) throws DepartmentException, LoginException;

	Department findDepartmentById(int id) throws DepartmentException, LoginException;

	Operator addOperator(Operator o) throws LoginException;

	Operator removeOperatorById(int id) throws OperatorException, LoginException;

	Operator modifyOperator(int id) throws OperatorException, LoginException;

	Operator findOperatorById(int id) throws OperatorException, LoginException;

	List<Operator> getAllOperators() throws LoginException;


}
