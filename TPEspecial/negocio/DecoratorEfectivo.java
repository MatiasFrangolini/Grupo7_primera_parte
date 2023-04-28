package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Efectivo
 */
public class DecoratorEfectivo extends DecoratorMedioDePago {

	public DecoratorEfectivo(IFactura encapsulado) {
		super(encapsulado);
	}

	@Override
	public double getPrecioTotal() {
		return this.encapsulado.getPrecioTotal()*0.8;
	}



	
	
}
