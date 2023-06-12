package negocio;

import java.io.Serializable;

import modelo.IFactura;

/**
 * 
 * Clase de tipo decorator, que va a decorar un encapsulado de tipo DecoratorPersoneria
 *
 */
public abstract class DecoratorMedioDePago implements IFactura, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected IFactura encapsulado;

	/**
	 * Constructor de tipo DecoratorMedioDePago
	 * <b>Pre</b> Encapsulado no va a ser nulo<br>
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

	public IFactura getEncapsulado() {
		return encapsulado;
	}

	public void setEncapsulado(IFactura encapsulado) {
		this.encapsulado = encapsulado;
	}

	public DecoratorMedioDePago() {}

	
	
	
	

	
	
	

}
