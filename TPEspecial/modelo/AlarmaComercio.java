package modelo;

public class AlarmaComercio extends Contratacion{
	
	private static double valorBase = 10000;
	
	/**
	 * LLama al constructor de su super clase.
	 * Calcula el precio de la contratacion del servicio.
	 */
	public AlarmaComercio(boolean movilAcompaniamiento, int cantCamaras, int cantBotones, Domicilio domicilio) {
		super(movilAcompaniamiento, cantCamaras, cantBotones, domicilio);
		this.precio=super.getCostoAgregado()+valorBase;
	}
	
	@Override
	public double getPrecio() {
		return this.precio;
	}

	/**
	 * Funcion que aplica la "Promo Dorada" 
	 * Modifica el precio aplicando la promocion correspondiente
	 * <b>Post</b>: Precio es modificado por la aplicacion de la Promo Dorada<br>
	 */
	@Override
	public void promoDorada() {
		double oldPrecio = this.precio;
		this.precio-=2500;
		assert this.precio == oldPrecio-2500:"Fallo postcondicion";
	}

	/**
	 * Funcion que aplica la "Promo Platino"
	 * Modifica el precio aplicando la promocion correspondiente
	 * <b>Post</b>: Precio es modificado por la aplicacion de la Promo Platino<br>
	 */
	@Override
	public void promoPlatino() {
		double oldPrecio = this.precio;
		this.precio*=0.65;
		assert this.precio == oldPrecio*0.65:"Fallo postcondicion";
	}
	
	@Override
	public String toString() {
		return "[Contratacion Id: " + this.numId + ". Precio: $" + this.precio +". "+ this.domicilio.toString() + "Descripcion: \nAlarma en Comercio\nCantidad de camaras: "+this.cantCamaras
				+"\nCantidad de botones antipanico: "+this.cantBotones+movilAcompaniamientoString()+"]\n";
	}

}
