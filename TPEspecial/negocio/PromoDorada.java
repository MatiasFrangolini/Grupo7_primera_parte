package negocio;

import java.io.Serializable;

public class PromoDorada implements IAplicaPromo,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PromoDorada() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo utilizado para implementar el Double Dispatch.
	 * El descuento a realizar depende de que tipo de contratacion recibio la promocion.
	 */
	@Override
	public void aplicarPromocion(Promocionable promo) {
		System.out.println("aa");
		promo.promoDorada();
	}

	

}
