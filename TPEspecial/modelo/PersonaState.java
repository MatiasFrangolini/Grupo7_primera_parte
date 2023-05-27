package modelo;

public abstract class PersonaState implements IPersonaState{
	
	private ClienteFisico c;
	
	public PersonaState(ClienteFisico c) {
		this.c = c;
	}
	

	public void pagarFactura() {
		
	}

	public void contratarServicio(Contratacion contratacion) {

	}

	public void bajaServicio(Contratacion contratacion) {
		
	}
}
