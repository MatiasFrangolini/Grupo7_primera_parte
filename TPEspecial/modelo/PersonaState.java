package modelo;


public abstract class PersonaState implements IPersonaState{
	
	protected ClienteFisico c;

	public PersonaState(ClienteFisico c) {
		this.c = c;
	}
	
	public void pagarFactura(IFactura f) {
		this.c.getHistorialFacturas().add(f);
		this.c.getFacturas().remove(f);
	}

	public void contratarServicio(ClienteFisico abonado) {
		//Empresa.getInstancia().addContratacionACliente(abonado);
		//Delegar al metodo de creacion de contrataciones en un cliente (Clase EMPRESA)
	}
	
	public void bajaServicio(ClienteFisico abonado, Contratacion contratacion) {
		this.c.getContrataciones().remove(contratacion);
	}
}
