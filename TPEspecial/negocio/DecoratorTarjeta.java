package negocio;

import modelo.IFactura;

/**
 * 
 * Patron Decorator que extiende de DecoratorMedioDePago
 * Aplica Decorador Tarjeta
 */
public class DecoratorTarjeta extends DecoratorMedioDePago {
	
	/**
	 * Constructor de la clase DecoratorTarjeta. Llama al constructor de su superclase.
	 */
	public DecoratorTarjeta(IFactura encapsulado) {
		super(encapsulado);
	}
	
	public DecoratorTarjeta() {}
	
/**
* Metodo override que agrega la recarga correspondiente cuando se paga con cheque.
 * @return Devuelve el Precio Incrementado en %5.
 */
	@Override
	public double getPrecioTotal() {
		return this.encapsulado.getPrecioTotal()*1.05;
	}

	
	
	@Override
	public String toString() {
		return encapsulado.toString() + "Precio $: " + this.getPrecioTotal();
	}
	
	



}
