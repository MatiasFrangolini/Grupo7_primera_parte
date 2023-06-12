package modelo;

import java.io.Serializable;

import excepciones.MorosoException;
import excepciones.SinContratacionException;

public class SinContratacionState extends PersonaState implements Serializable {
	
	public SinContratacionState(){};
	
	public SinContratacionState(ClienteFisico c) {
		super(c);
	}

	@Override
	public void pagarFactura(IFactura f) throws SinContratacionException {
		throw new SinContratacionException("Un cliente sin factura no puede pagarla.");
	}
	

	@Override
	public void contratarServicio(Contratacion contratacion) throws MorosoException {
		assert contratacion != null:"Contratacion nula";
		int oldSize = this.c.getContrataciones().size();
		this.c.getContrataciones().add(contratacion);
		this.c.setEstado(new ConContratacionState(this.c));
		assert this.c.getContrataciones().size() == oldSize+1: "Fallo postcondicion";
	}

	@Override
	public void bajaServicio(Contratacion contratacion) throws SinContratacionException {
		throw new SinContratacionException("Un cliente sin contratacion no puede darla de baja.");
	}
	
	@Override
	public String toString() {
		return "sin contratacion.";
	}
	
	

}
