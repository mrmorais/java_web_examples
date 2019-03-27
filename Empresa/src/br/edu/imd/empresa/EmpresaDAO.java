package br.edu.imd.empresa;

import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class EmpresaDAO {
	private int number = 0;
	
	public EmpresaDAO() {
		System.out.println("Singleton Empresa Done!!!!");
	}
	
	public int next() {
		return this.number++;
	}
	
}
