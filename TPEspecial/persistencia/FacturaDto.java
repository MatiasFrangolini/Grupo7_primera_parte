package persistencia;

import java.io.Serializable;

import modelo.Cliente;

public class FacturaDto implements Serializable{
	Cliente abonado; //Relacion de composicion con Cliente.
	double precioTotal;
	
	
	
	public FacturaDto() {
		super();
	}
	public Cliente getAbonado() {
		return abonado;
	}
	public void setAbonado(Cliente abonado) {
		this.abonado = abonado;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
