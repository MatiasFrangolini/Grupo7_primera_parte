package modelo;

public class Factura implements IFactura{
	Cliente abonado; //Relacion de composicion con Cliente.
	double precioTotal;
	

	/**
	 * Constructor de la clase Factura.
	 * @param abonado: parametro de tipo Cliente que determina a que abonado pertenece la factura.
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
		return "Factura del " + abonado.toString() + "\nPrecio total de la factura: $" + getPrecioTotal()+"\n\n";
	}


	
	
	
	
	
	
}
