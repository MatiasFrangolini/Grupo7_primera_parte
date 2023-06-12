package modelo;



import java.io.Serializable;

import negocio.Empresa;

public class Factura implements IFactura,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente abonado; //Relacion de composicion con Cliente.
	private double precioTotal;
	private int mes;
	

	/**
	 * Constructor de la clase Factura.
	 * @param abonado: parametro de tipo Cliente que determina a que abonado pertenece la factura.
	 */
	public Factura(Cliente abonado) {
		this.abonado=abonado;
		this.mes = Empresa.getMes()-1;
		this.precioTotal = abonado.getPagoTotal();
	}

	/*
	 * Metodo que calcula el precio total a mostrar en la factura.
	 * Recorre las contrataciones del cliente propio de la factura.
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantContrataciones() {
		return this.abonado.contrataciones.size();
	}
	
	/*
	 * Metodo para clonar una factura.
	 */
	public Object clone() throws CloneNotSupportedException{
		IFactura clonado = null;
		clonado = (IFactura)super.clone();
		return clonado;
	}


	@Override
	public String toString() {
		return "Factura del mes " +mes+". Precio base: "+this.precioTotal;
	}

	public Factura() {
		super();
	}

	public Cliente getAbonado() {
		return abonado;
	}

	public void setAbonado(Cliente abonado) {
		this.abonado = abonado;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	
}
