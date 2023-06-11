package modelo;

import excepciones.MorosoException;

public class MorosoState extends PersonaState{

	public MorosoState(ClienteFisico c) {
		super(c);
		this.c.getFacturas().get(this.c.getFacturas().size()-1);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void pagarFactura(IFactura f) {
		this.setChanged();
		this.notifyObservers("El cliente "+this.c.getName()+ " pagó "+f.getPrecioTotal()*1.3);
		this.c.getHistorialFacturas().add(f);
		this.c.getFacturas().remove(f);
		if (this.c.facturas.size()<2)
			this.c.setEstado(new ConContratacionState(c));
	}

	@Override
	public void contratarServicio(Contratacion contratacion) throws MorosoException {
		throw new MorosoException("Un cliente moroso no puede contratar un servicio");
	}

	@Override
	public void bajaServicio(Contratacion contratacion) throws MorosoException {
		throw new MorosoException("Un cliente moroso no puede eliminar una contratacion");
	}
	
	@Override
	public String toString() {
		return "moroso.";
	}
	
}
