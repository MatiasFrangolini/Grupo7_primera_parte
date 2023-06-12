package modelo;

public class AlarmaVivienda extends Contratacion{
	
	private static double valorBase = 8500;
	
	/**
	 * LLama al constructor de su super clase.
	 * Calcula el precio de la contratacion del servicio.
	 */
	public AlarmaVivienda(boolean movilAcompaniamiento, int cantCamaras, int cantBotones, Domicilio domicilio) {
		super(movilAcompaniamiento, cantCamaras, cantBotones, domicilio);
		this.precio=super.getCostoAgregado()+valorBase;
	}

	public AlarmaVivienda() {}


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
		this.precio-=1500;
		assert this.precio == oldPrecio-1500:"Fallo postcondicion";
	}


	/**
	 * Funcion que aplica la "Promo Platino"
	 * Modifica el precio aplicando la promocion correspondiente
	 * <b>Post</b>: Precio es modificado por la aplicacion de la Promo Platino<br>
	 */
	@Override
	public void promoPlatino() {
		double oldPrecio = this.precio;
		this.precio*=0.7;
		assert this.precio == oldPrecio*0.7:"Fallo postcondicion";
	}
	
	@Override
	public String toString() {
		return "Vivienda. "+ super.toString();
	}

	public static double getValorBase() {
		return valorBase;
	}

	public static void setValorBase(double valorBase) {
		AlarmaVivienda.valorBase = valorBase;
	}
	

}
