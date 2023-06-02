package persistencia;

import java.io.Serializable;

import modelo.ClienteFisico;

public class PersonaStateDto implements Serializable {
	protected ClienteFisico c;

	public PersonaStateDto() {
		super();
	}

	public ClienteFisico getC() {
		return c;
	}

	public void setC(ClienteFisico c) {
		this.c = c;
	}
	
	
}
