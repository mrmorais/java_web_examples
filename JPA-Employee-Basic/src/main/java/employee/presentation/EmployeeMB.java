package employee.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import employee.Employee;
import employee.data.EmployeeDAO;

@Named(value = "employeeManagedBean")
@ViewScoped
public class EmployeeMB implements Serializable {
	private static final long serialVersionUID = -1072401845049198412L;

	@Inject EmployeeDAO dao;
	
	//Auxiliary fields for JSF
	private List<Employee> employeeList;
	private Employee employee = new Employee();
	private transient DataModel<Employee> model = null;
	
	public List<Employee> getEmployeeList() {
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
	
	public DataModel<Employee> getModel() {
		if (model == null) {
			model = new ListDataModel<Employee>(employeeList);
		}
		
		return model;
	}
	
	public void delete() {
		dao.removeEmployee(model.getRowData());
	}
}
