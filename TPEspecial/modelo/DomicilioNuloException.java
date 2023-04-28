package modelo;

public class DomicilioNuloException extends DomicilioInvalidoException {

	/*
	 * Constructor propio de la excepcion DomicilioNulo se lanza cuando se recibe un domicilio nulo
	 */
	public DomicilioNuloException(String message) {
		super(message);
	}
	
	
}
