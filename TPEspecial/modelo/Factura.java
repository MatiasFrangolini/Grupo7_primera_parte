package modelo;

import java.util.Iterator;
/**
 * 
 * 
 *
 */
public class Factura implements IFactura{
	/**
     * @aggregation Agregacion
     */
	Cliente abonado;
	double precioTotal;
	

	/*
	 * Constructor de una Factura
	 * Recibe como parametro un cliente
	 */
	public Factura(Cliente abonado) {
		this.abonado=abonado;
	}

	/*
	 * Metodo que calcula el precio total a mostrar en la factura.
	 * Recorre las contrataciones del cliente propio de la factura.
	 */
	public double getPrecioTotal() {
		return this.abonado.getPagoTotal();
	}
	
	public int getCantContrataciones() {
		return this.abonado.contrataciones.size();
	}
	
	/*
	 * Metodo para clonar una factura, realiza una clonacion profunda.
	 * La clonacion es condicional.
	 */
	public Object clone() throws CloneNotSupportedException{
		Factura clonado = null;
		clonado = (Factura)super.clone();
		clonado.abonado = (Cliente) this.abonado.clone();
		return clonado;
	}


	@Override
	public String toString() {
		return "Factura del " + abonado.toString() + "\nPrecio total: $" + getPrecioTotal();
	}


	
	
	
	
	
	
}
