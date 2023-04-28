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



	@Override
	public double getPrecio() {
		return this.precio;
	}


	/**
	 * Funcion que aplica la "Promo Dorada" 
	 * Modifica el precio aplicando la promocion correspondiente
	 * <Post>: Precio es modificado por la aplicacion de la Promo Dorada
	 */
	@Override
	public void promoDorada() {
		this.precio-=1500;
	}


	/**
	 * Funcion que aplica la "Promo Platino"
	 * Modifica el precio aplicando la promocion correspondiente
	 * <Post>: precio es modificado por la aplicacion de la Promo Platino
	 */
	@Override
	public void promoPlatino() {
		this.precio*=0.7;
	}

	

}
