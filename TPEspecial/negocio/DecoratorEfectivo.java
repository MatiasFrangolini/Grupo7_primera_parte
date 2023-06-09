package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Efectivo
 */
public class DecoratorEfectivo extends DecoratorMedioDePago {
	
	/**
	 * Constructor de la clase DecoratorEfectivo. Llama al constructor de su superclase.
	 */
	public DecoratorEfectivo(IFactura encapsulado) {
		super(encapsulado);
	}

	/**
	 * Metodo override que agrega la recarga correspondiente cuando se paga con cheque.
	 */
	@Override
	public double getPrecioTotal() {
		return this.encapsulado.getPrecioTotal()*0.8;
	}
	
	@Override
	public String toString() {
		return encapsulado.toString() + "Precio $: " + this.getPrecioTotal();
	}




	
	
}
