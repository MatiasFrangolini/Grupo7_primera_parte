package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Cheque
 */
public class DecoratorCheque extends DecoratorMedioDePago {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase DecoratorCheque. Llama al constructor de su superclase.
	 */
	public DecoratorCheque(IFactura encapsulado) {
		super(encapsulado);
	}

	public DecoratorCheque() {}
	
	/**
	 * 
	 * Metodo override que agrega la recarga correspondiente cuando se paga con cheque.
	 */
	@Override
	public double getPrecioTotal() {
		return this.encapsulado.getPrecioTotal()*1.1;
	}

	@Override
	public String toString() {
		return encapsulado.toString() + " Precio final: $" + this.getPrecioTotal();
	}
	
	

}
