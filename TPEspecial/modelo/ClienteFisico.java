package modelo;

import controlador.Controlador;
import excepciones.MorosoException;
import excepciones.SinContratacionException;

public class ClienteFisico extends Cliente {
	
	private IPersonaState estado; 
	
	/**
	 * Constructor de la clase Cliente Fisico, que llama al constructor de su superclase.
	 */
	public ClienteFisico(String nombre, String dni) {
		super(nombre, dni);
		this.setEstado(new SinContratacionState(this));
	}

	public void pagarFactura(IFactura f) throws SinContratacionException {
		this.estado.pagarFactura(f);
	}

	public void addContratacion(Contratacion contratacion) throws MorosoException {
		this.estado.contratarServicio(contratacion);
	}
	
	public void bajaServicio(Contratacion contratacion) throws SinContratacionException, MorosoException {
		this.estado.bajaServicio(contratacion);
	}
	
	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	}
	@Override
	public void actualizarEstado() {
		if (this.contrataciones.size()==0) {
			this.setEstado(new SinContratacionState(this));
		}
		else if (this.facturas.size()>=2)
			this.setEstado(new MorosoState(this));	
		}

	@Override
	public String toString() {
		return super.toString()+".Persona física "+ estado.toString();
	}
	
	public void addObserver(Controlador c) {
		this.estado.addObserver(c);
	}
}

	
