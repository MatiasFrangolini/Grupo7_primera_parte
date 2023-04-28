package negocio;

public class PromoPlatino implements IAplicaPromo {

	public PromoPlatino() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarPromocion(Promocionable promo) {
		promo.promoPlatino();
	}

	

}
