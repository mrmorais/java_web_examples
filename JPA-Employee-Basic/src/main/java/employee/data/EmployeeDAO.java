package employee.data;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import employee.Employee;

@Named
@RequestScoped
public class EmployeeDAO {
	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public Employee addNew(Employee employee) {
		try {
			userTransaction.begin();
			entityManager.persist(employee);
			userTransaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> findEmployees() {
		TypedQuery<Employee> query = entityManager.createNamedQuery("findAllEmployees", Employee.class);
		return query.getResultList();
	}
	
	public void removeEmployee(Employee employee) {
		try {
			userTransaction.begin();
			Object c = entityManager.merge(employee);
			entityManager.remove(c);
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
