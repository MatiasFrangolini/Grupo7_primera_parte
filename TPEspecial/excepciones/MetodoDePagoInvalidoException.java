package excepciones;

public class MetodoDePagoInvalidoException extends Exception {
	
	private String medioDePago;
	
	public MetodoDePagoInvalidoException(String medioDePago) {
		this.medioDePago=medioDePago;
	}

	@Override
	public String getMessage() {
		return "El metodo de pago" +medioDePago +" no es valido";
	}
	
	

}
