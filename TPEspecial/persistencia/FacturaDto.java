package persistencia;

import java.io.Serializable;

import modelo.Cliente;
import modelo.IFactura;

public class FacturaDto implements Serializable{
	Cliente abonado; //Relacion de composicion con Cliente.
	double precioTotal;
	private int mes;
	
	
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
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	
}
