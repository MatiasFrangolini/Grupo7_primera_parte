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
		setEstado(new SinContratacionState(this));
	}

	@Override
	public Object clone() {
		ClienteFisico clonado = null;
		try {
			clonado = (ClienteFisico)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clonado;
	}

	public IPersonaState getEstado() {
		return estado;
	}

	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	}
	
	
	
	

	
}
