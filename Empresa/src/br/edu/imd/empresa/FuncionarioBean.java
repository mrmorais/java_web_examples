package br.edu.imd.empresa;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FuncionarioBean {
	private String name;
	private double salario;
	
	int ultimoIdCriado;
	
	@EJB
	private EmpresaDAO empresaDAO;
	
	public FuncionarioBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String createNewFuncionario() {
		this.ultimoIdCriado = empresaDAO.next();
	
		return "funcionario";
	}
	
	public int getUltimoIdCriado() {
		return this.ultimoIdCriado;
	}
	
}
