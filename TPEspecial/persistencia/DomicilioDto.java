package persistencia;

import java.io.Serializable;

public class DomicilioDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calle;
	private int altura;
	
	public DomicilioDto() {
		super();
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}
