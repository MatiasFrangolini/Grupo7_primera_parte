package persistencia;

import java.io.Serializable;

public class TecnicoDto implements Serializable {
	private String nombre;
	private boolean ocupado;
	public TecnicoDto() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	
}
