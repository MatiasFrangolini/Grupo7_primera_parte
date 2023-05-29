package modelo;

public class SinContratacionState extends PersonaState {

	public SinContratacionState(ClienteFisico c) {
		super(c);
	}

	@Override
	public void pagarFactura(IFactura f) {
		//lanzar excepcion
	}
	

	@Override
	public void contratarServicio(ClienteFisico abonado) {
		super.contratarServicio(abonado);
		abonado.setEstado(new ConContratacionState(abonado));
	}

	@Override
	public void bajaServicio(ClienteFisico abonado, Contratacion contratacion) {
		//lanzar excepcion
	}
	
	

}
