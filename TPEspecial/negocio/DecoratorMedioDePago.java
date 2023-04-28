package negocio;
import modelo.*;

/**
 * 
 * Clase de tipo decorator, que va a decorar un encapsulado de tipo DecoratorPersoneria
 *
 */
public abstract class DecoratorMedioDePago implements IFactura {
	
	IFactura encapsulado;

	/**
	 * Constructor de tipo DecoratorMedioDePago
	 * <Pre> Encapsulado no va a ser nulo
	 * @param encapsulado: representa un decorador Personeria
	 */
	
	public DecoratorMedioDePago(IFactura encapsulado) {
		assert encapsulado != null:"Encapsulado nulo";
		this.encapsulado = encapsulado;
	}

	/**
	 * Desarrollo del metodo abstracto de clonacion.
	 * @return Devuelve, en caso de ser posible, un clon del encapsulado.
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return encapsulado.clone();
	}

	@Override
	public String toString() {
		return encapsulado.toString();
	}
	
	
	

	
	
	

}
