package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Tarjeta
 */
public class DecoratorTarjeta extends DecoratorMedioDePago {

	public DecoratorTarjeta(IFactura encapsulado) {
		super(encapsulado);
	}
/**
 * @return Devuelve el Precio Incrementado en %5.
 */
	@Override
	public double getPrecioTotal() {
		return this.encapsulado.getPrecioTotal()*1.05;
	}



}
