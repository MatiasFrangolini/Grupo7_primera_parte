package modelo;

import java.io.Serializable;
import java.util.Observable;

import controlador.Controlador;
import excepciones.MorosoException;
import excepciones.SinContratacionException;

@SuppressWarnings("deprecation")
public abstract class PersonaState extends Observable implements IPersonaState, Serializable {
	
	protected ClienteFisico c;
	

	public PersonaState() {
	}

	public PersonaState(ClienteFisico c) {
		this.c = c;
	}
	
	public void pagarFactura(IFactura f) throws SinContratacionException {
		this.setChanged();
		this.notifyObservers("El cliente "+this.c.getName()+ " pagó "+f.getPrecioTotal());
		this.c.getHistorialFacturas().add(f);
		this.c.getFacturas().remove(f);
	}

	public void contratarServicio(Contratacion contratacion) throws MorosoException {
		assert contratacion != null:"Contratacion nula";
		int oldSize = this.c.getContrataciones().size();
		this.c.getContrataciones().add(contratacion);
		assert this.c.getContrataciones().size() == oldSize+1: "Fallo postcondicion";
	}
	
	public void bajaServicio(Contratacion contratacion) throws SinContratacionException, MorosoException {
		this.c.getContrataciones().remove(contratacion);
	}
	
	public void addObserver(Controlador c) {
		super.addObserver(c);
	}

	public ClienteFisico getC() {
		return c;
	}

	public void setC(ClienteFisico c) {
		this.c = c;
	}
	
	
}
