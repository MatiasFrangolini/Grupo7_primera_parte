package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ClienteFisico extends Cliente {
	
	private IPersonaState estado; 
	
	/**
	 * Constructor de la clase Cliente Fisico, que llama al constructor de su superclase.
	 */
	public ClienteFisico(String nombre, String dni) {
		super(nombre, dni);
		this.setEstado(new SinContratacionState(this));
	}

	public void pagarFactura(IFactura f) {
		this.estado.pagarFactura(f);
	}

	public void contratarServicio(ClienteFisico abonado) {
		this.estado.contratarServicio(abonado);
	}
	
	public void bajaServicio(ClienteFisico abonado, Contratacion contratacion) {
		this.estado.bajaServicio(abonado, contratacion);
	}
	
	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	}
	
	public void actualizarEstado() {
		if (this.contrataciones.size()==0) {
			this.setEstado(new SinContratacionState(this));
		}
		else if (this.facturas.size()>=2)
			this.setEstado(new MorosoState(this));	
		}
	}
