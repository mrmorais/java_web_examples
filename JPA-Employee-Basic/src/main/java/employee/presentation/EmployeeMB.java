package employee.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import employee.Employee;
import employee.data.EmployeeDAO;

@Named(value = "employeeManagedBean")
//@ViewScoped
@RequestScoped
public class EmployeeMB implements Serializable {
	private static final long serialVersionUID = -1072401845049198412L;

	@Inject EmployeeDAO dao;
	
	//Auxiliary fields for JSF
	private List<Employee> employeeList = new ArrayList<>();
	private Employee employee = new Employee();
	
	public List<Employee> getEmployeeList() {
		System.out.println("listar usuariosa");
		employeeList = dao.findEmployees();
		return employeeList;
	}
	
	@PostConstruct
	public void init() {
		employeeList = dao.findEmployees();
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addNewEmployee() {
		dao.addNew(employee);
		employeeList = dao.findEmployees();
		return "employeelist";
	}
	
	public String removeEmployee() {
		System.out.println("remover usuario");
//		dao.removeEmployee(employee);
//		employeeList = dao.findEmployees();
		return "employeelist";
	}
	
}
