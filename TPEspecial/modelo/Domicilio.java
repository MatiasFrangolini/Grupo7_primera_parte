package modelo;

public class Domicilio implements Cloneable, Comparable<Domicilio>{
	
	private String calle;
	private int altura;
	
	/**
	 * Constructor de la clase Domicilio.
	 * <b>Pre:</b> String calle no puede ser null <br>
	 * <b>Pre:</b> altura no puede ser negativa <br>
	 * @param calle: parametro String que determina el nombre de la calle
	 * @param altura: parametro int que determina la altura de la direccion
	 */
	public Domicilio(String calle, int altura) {
		assert calle != null : "Fallo en la precondicion. La calle no puede ser null";
		assert altura>0 : "Fallo en la precondicion. La altura debe ser positiva.";
		this.calle = calle;
		this.altura = altura;
	}


	public String getCalle() {
		return calle;
	}


	public int getAltura() {
		return altura;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	@Override
	public String toString() {
		return "Domicilio: " + calle + " " + altura + "\n";
	}


	/*
	 * Metodo clone() que clona un domicilio utilizando el metodo clone de la clase Object de Java
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	/*
	 * Implementacion del metodo compareTo de la interfaz Comparable original de Java
	 * <b>Pre:</b> El parametro o de tipo Domicilio no puede ser null <br>
	 */
	@Override
	public int compareTo(Domicilio o) {
		assert o != null : "Domicilio null";
		if (this.calle.equalsIgnoreCase(o.calle) && (this.altura == o.altura)) {
			return 0;
		} else {
			if (!(this.calle.equalsIgnoreCase(o.calle)))
				return this.calle.compareTo(o.calle);
			else
				return this.altura-o.altura;
		}
	}
	
	
	
	
	

}
