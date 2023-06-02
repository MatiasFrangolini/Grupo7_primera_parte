package modelo;


public class MorosoState extends PersonaState{

	public MorosoState(ClienteFisico c) {
		super(c);
	}

	@Override
	public void pagarFactura(IFactura f) {
		//ver que hacer
		if (this.c.facturas.size()<2)
			this.c.setEstado(new ConContratacionState(c));
	}

	@Override
	public void contratarServicio(ClienteFisico abonado) {
		//lanza excepcion
	}

	@Override
	public void bajaServicio(ClienteFisico abonado, Contratacion contratacion) {
		//lanza excepcion
	}

	
}
