package modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Tecnico extends Observable{
	
	private String nombre;
	private boolean ocupado;
	
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
	
	
	
	
	
	
	

}
