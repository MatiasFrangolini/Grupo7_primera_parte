package negocio;

public class PromoDorada implements IAplicaPromo {

	public PromoDorada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarPromocion(Promocionable promo) {
		promo.promoDorada();
	}

	

}
