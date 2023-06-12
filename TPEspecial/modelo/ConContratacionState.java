package modelo;


public class ConContratacionState extends PersonaState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public ConContratacionState(ClienteFisico c) {
		super(c);
	}
	
	
	
	// Pasa a SinContratacionState en el caso de que al final del mes, no tenga ninguna contratacion (Mediante la funcion actualizarEstado en ClienteFisico)


	public ConContratacionState() {}



	@Override
	public String toString() {
		return "con contratacion.";
	}
	
	

	
}
