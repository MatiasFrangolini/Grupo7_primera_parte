package modelo;

import java.io.Serializable;

public class Tecnico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private boolean ocupado;
	private Cliente cliente;
	
	public Tecnico(String nombre) {
		this.nombre = nombre;
		this.ocupado = false;
		this.cliente = null;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

		
	

}
