package br.ufrn.imd.ecryption.web2;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ufrn.imd.web2.encryption.EncryptionRemote;

@Named
@RequestScoped
public class HashingManagedBean {
	private String input, output;
	
	@EJB
	EncryptionRemote encryption;
	
	public HashingManagedBean() {
	}
	
	public String runHash() {
		try {
		output = encryption.hash(input);
		System.out.println(output);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "hashing";
	}
	
	public String getInput() {
		return input;
	}
	
	public String getOutput() {
		return output;
	}
	
	public void setInput(String _input) {
		this.input = _input;
	}
	
	public void setOutput(String _output) {
		this.input = _output;
	}
}
