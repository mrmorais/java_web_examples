package br.ufrn.imd.web2.encryption;

public class EncryptionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncryptionException() {
		super();
	}

	public EncryptionException(String message, Throwable cause) {
		super(message, cause);
	}

	public EncryptionException(String message) {
		super(message);
	}

	public EncryptionException(Throwable cause) {
		super(cause);
	}

}
