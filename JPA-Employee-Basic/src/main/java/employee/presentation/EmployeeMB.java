package employee.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import employee.Employee;
import employee.data.EmployeeDAO;

@Named
@ViewScoped
public class EmployeeMB implements Serializable {

    private List<Employee> list;
    private Employee item;
    
    @Inject EmployeeDAO dao;

    @PostConstruct
    public void init() {
        list = dao.findEmployees();
        item = new Employee();
    }
    
    public String add() {
        dao.addNew(item);
        // Actually, the DAO should already have set the ID from DB. This is just for demo.
        return "index";
    }
    
    public String delete(Employee employee) {
    	dao.removeEmployee(employee);
    	return "index";
    }

    public List<Employee> getList() {
        return list;
    }
    
    public Employee getItem() {
    	return this.item;
    }


}
