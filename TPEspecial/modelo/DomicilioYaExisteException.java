package modelo;

public class DomicilioYaExisteException extends DomicilioInvalidoException {

	
	/*
	 * Constructor propio de la excepcion DomicilioYaExiste se lanza cuando se quiere realizar
	 * una contratacion con un domicilio que ya hizo una contratacion previa.
	 */
	public DomicilioYaExisteException(String message) {
		super(message);
	}
	
	
}
