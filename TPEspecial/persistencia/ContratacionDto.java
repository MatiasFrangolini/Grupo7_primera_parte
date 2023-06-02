package persistencia;

import java.io.Serializable;

import modelo.Domicilio;

public class ContratacionDto implements Serializable {
	protected static int sigNumId = 1;
	protected int numId;
	protected boolean movilAcompaniamiento;
	protected int cantCamaras;
	protected int cantBotones;
	protected double precio;
	protected Domicilio domicilio; //Relacion de composicion
	
	public ContratacionDto() {
		super();
	}

	public static int getSigNumId() {
		return sigNumId;
	}

	public static void setSigNumId(int sigNumId) {
		ContratacionDto.sigNumId = sigNumId;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public boolean isMovilAcompaniamiento() {
		return movilAcompaniamiento;
	}

	public void setMovilAcompaniamiento(boolean movilAcompaniamiento) {
		this.movilAcompaniamiento = movilAcompaniamiento;
	}

	public int getCantCamaras() {
		return cantCamaras;
	}

	public void setCantCamaras(int cantCamaras) {
		this.cantCamaras = cantCamaras;
	}

	public int getCantBotones() {
		return cantBotones;
	}

	public void setCantBotones(int cantBotones) {
		this.cantBotones = cantBotones;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	

}
