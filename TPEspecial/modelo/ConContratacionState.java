package modelo;


public class ConContratacionState extends PersonaState {

	public ConContratacionState(ClienteFisico c) {
		super(c);
	}
	
	
	// Pasa a SinContratacionState en el caso de que al final del mes, no tenga ninguna contratacion (Mediante la funcion actualizarEstado en ClienteFisico)


	@Override
	public String toString() {
		return "con contratacion.";
	}
	
	

	
}
