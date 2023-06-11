package modelo;


public class Tecnico {
	
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
