package persistencia;

import java.io.Serializable;

import modelo.IFactura;

public class DecoratorMedioDePagoDto implements Serializable {
	protected IFactura encapsulado;

	public DecoratorMedioDePagoDto() {
		super();
	}

	public IFactura getEncapsulado() {
		return encapsulado;
	}

	public void setEncapsulado(IFactura encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	
}
