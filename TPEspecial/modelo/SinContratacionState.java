package modelo;

import excepciones.MorosoException;
import excepciones.SinContratacionException;

public class SinContratacionState extends PersonaState {

	public SinContratacionState(ClienteFisico c) {
		super(c);
	}

	@Override
	public void pagarFactura(IFactura f) throws SinContratacionException {
		throw new SinContratacionException("Un cliente sin factura no puede pagarla.");
	}
	

	@Override
	public void contratarServicio(Contratacion contratacion) throws MorosoException {
		super.contratarServicio(contratacion);
		this.c.setEstado(new ConContratacionState(this.c));
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
