package modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Tecnico extends Observable{
	
	private String nombre;
	private boolean ocupado;
	private Contratacion asignacion=null;
	
	public Tecnico(String nombre) {
		this.nombre = nombre;
		this.ocupado = false;
	}


	public String getNombre() {
		return nombre;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public Contratacion getAsignacion() {
		return asignacion;
	}


	public void setAsignacion(Contratacion asignacion) {
		this.asignacion = asignacion;
	}


}
