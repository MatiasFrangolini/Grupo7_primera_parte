package negocio;

public class PromoDorada implements IAplicaPromo {

	public PromoDorada() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo utilizado para implementar el Double Dispatch.
	 * El descuento a realizar depende de que tipo de contratacion recibio la promocion.
	 */
	@Override
	public void aplicarPromocion(Promocionable promo) {
		promo.promoDorada();
	}

	

}
