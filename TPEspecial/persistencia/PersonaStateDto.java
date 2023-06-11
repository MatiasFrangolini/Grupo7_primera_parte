package persistencia;

import java.io.Serializable;

import modelo.ClienteFisico;

public class PersonaStateDto implements Serializable {
	protected ClienteDto c;

	public PersonaStateDto() {
		super();
	}

	public ClienteDto getC() {
		return c;
	}

	public void setC(ClienteDto c) {
		this.c = c;
	}
	
	
}
