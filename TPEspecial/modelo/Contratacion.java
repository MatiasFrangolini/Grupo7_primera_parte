package modelo;

import negocio.Promocionable;

/**
 * 
 * Invariante de clase El domicilio no puede ser null
 *
 */
public abstract class Contratacion implements Promocionable, Cloneable{
	
	protected static int sigNumId = 1;
	private int numId;
	private boolean movilAcompaniamiento;
	private int cantCamaras;
	private int cantBotones;
	protected double precio;

    /**
     * @aggregation composite
     */
    private Domicilio domicilio;
    
	
    /**
     * Constructor con cuatro parametros para setear si tiene movil de acompañamiento, la cantidad de camaras, la cantidad de botones y el domicilio.
     * <br>
     * <Pre>: No va a llegar un domicilio null.
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
	 * <b>Post: </b> Devuelve un precio no nulo.
	 */
	public abstract double getPrecio();
	
	
	/**
	 * @return Devuelve el valor que se agrega a la contratacion por sus servicios extra. 
	 * <b>Post: </b> Devuelve un precio no nulo.
	 */
	public double getCostoAgregado() {
		int aux = 0;
		if (movilAcompaniamiento)
			aux += 7500;
		aux += cantCamaras*3000;
		aux += cantBotones*2000;
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
		return "[Contratacion Id: " + numId + ". Precio: $" + precio +". "+ domicilio.toString() + "Descripcion: \nCantidad de camaras: "+cantCamaras
				+"\nCantidad de botones antipanico: "+cantBotones+movilAcompaniamientoString()+"]\n";
	}
	
	
	
	
	
	
	
}
