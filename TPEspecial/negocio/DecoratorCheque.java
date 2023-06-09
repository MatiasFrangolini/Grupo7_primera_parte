package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Cheque
 */
public class DecoratorCheque extends DecoratorMedioDePago {

	/**
	 * Constructor de la clase DecoratorCheque. Llama al constructor de su superclase.
	 */
	public DecoratorCheque(IFactura encapsulado) {
		super(encapsulado);
	}

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
		return encapsulado.toString() + "Precio $: " + this.getPrecioTotal();
	}

}
