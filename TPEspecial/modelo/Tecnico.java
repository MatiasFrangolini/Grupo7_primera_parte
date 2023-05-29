package modelo;

public class Tecnico {
	
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
