package modelo;

import java.util.Iterator;

public class ClienteJuridico extends Cliente {

	public ClienteJuridico(String nombre, String dni) {
		super(nombre, dni);
	}

	/**
	 * Metodo que sobreescribe el de la clase abstracta Cliente
	 * El pago de los servicios se calcula realizando la sumatoria de los mismos.
	 * A partir de la 3ra contratacion se bonifica el 50% de las mismas.
	 */
	@Override
	public double getPagoTotal() {
		Iterator<Contratacion> it = this.contrataciones.iterator();
		double aux=0;
		int i=0;
		while (it.hasNext()) {
			if (i<3) {
				aux += it.next().getPrecio();
			} else
				aux += it.next().getPrecio()*0.5;
		}
		return aux;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Un cliente juridico no admite clonacion.");
	}
	
	
	
	
}
