package modelo;


import java.io.Serializable;

import negocio.Promocionable;

public abstract class Contratacion implements Promocionable, Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static int sigNumId = 1;
	protected int numId;
	protected boolean movilAcompaniamiento;
	protected int cantCamaras;
	protected int cantBotones;
	protected double precio;
	protected Domicilio domicilio; //Relacion de composicion
    
	
    /**
     * Constructor con cuatro parametros para setear si tiene movil de acompañamiento, la cantidad de camaras, la cantidad de botones y el domicilio.
     * <br>
     * <b>Pre</b>: No va a llegar un domicilio null.<br>
     * <b>Pre</b>: No van a llegar cantCamaras o cantBotones menores a 0.<br>
     * @param movilAcompanamiento : parametro de tipo boolean que indica si se contrato un movil de acompanamiento
     * @param cantCamaras : parametro de tipo int que indica la cantidad de camaras contratadas
     * @param cantBotones : parametro de tipo int que indica la cantidad de botones contratados
     * @param domicilio : parametro de tipo string que representa el domicilio del cliente
     */
	public Contratacion(boolean movilAcompaniamiento, int cantCamaras, int cantBotones, Domicilio domicilio) {
		assert domicilio != null: "Domicilio nulo";
		
		this.movilAcompaniamiento = movilAcompaniamiento;
		this.cantCamaras = cantCamaras;
		this.cantBotones = cantBotones;
		this.domicilio = domicilio;
		this.numId = sigNumId++;
	}
	
	/**
	 * Funcion que será redefinida en hijos de la clase.
	 * @return Devuelve el valor del precio de la contratacion.
	 */
	public abstract double getPrecio();
	
	
	/**
	 * @return Devuelve el valor que se agrega a la contratacion por sus servicios extra. 
	 * <b>Post: </b> Devuelve un valor mayor o igual a 0.<br>
	 */
	public double getCostoAgregado() {
		int aux = 0;
		if (movilAcompaniamiento)
			aux += 7500;
		aux += cantCamaras*3000;
		aux += cantBotones*2000;
		assert aux >= 0:"Fallo en postcondicion.";
		return aux;
	}

	public int getNumId() {
		return numId;
	}

	public boolean isMovilAcompaniamiento() {
		return movilAcompaniamiento;
	}

	public int getCantCamaras() {
		return cantCamaras;
	}

	public int getCantBotones() {
		return cantBotones;
	}

	public static int getSigNumId() {
		return sigNumId;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	/**
	 * Metodo que realiza una clonacion profunda condicional.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Contratacion clonado = null;
		clonado = (Contratacion)super.clone();
		clonado.domicilio = (Domicilio)this.domicilio.clone();
		return clonado;
	}
	

	public String movilAcompaniamientoString() {
		if (movilAcompaniamiento)
			return "\nPosee movil de acompañamiento";
		else
			return "";
	}
	
	@Override
	public String toString() {
		return "Id: " + numId + ". Precio: $" + precio +".  "+ domicilio.toString() + "  Camaras: "+cantCamaras
				+"  Botones antipanico: "+cantBotones+movilAcompaniamientoString();
	}

	public Contratacion() {
		super();
	}

	public static void setSigNumId(int sigNumId) {
		Contratacion.sigNumId = sigNumId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public void setMovilAcompaniamiento(boolean movilAcompaniamiento) {
		this.movilAcompaniamiento = movilAcompaniamiento;
	}

	public void setCantCamaras(int cantCamaras) {
		this.cantCamaras = cantCamaras;
	}

	public void setCantBotones(int cantBotones) {
		this.cantBotones = cantBotones;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	
}
