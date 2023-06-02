package modelo;


import java.util.ArrayList;
import java.util.Iterator;

import negocio.Empresa;


public abstract class Cliente extends Thread implements Cloneable{
   
	
	protected ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>(); //Relacion de composicion
	protected ArrayList<IFactura> facturas = new ArrayList<IFactura>();
	protected ArrayList<IFactura> historialfacturas = new ArrayList<IFactura>();
	private String nombre;
	private String dni;
	
	/**
	 * Constructor de la clase Cliente
	 * <b>Pre: </b> nombre debe ser distinto de null <br>
	 * <b>Pre: </b> Dni distinto de null <br>
	 * @param nombre: Parametro de tipo string que indica el nombre del cliente
	 * @param dni: Parametro de tipo String que representa el dni del cliente
	 */
	public Cliente(String nombre, String dni) {
		super(nombre);
		assert nombre != null:"Nombre de cliente nulo";
		assert dni != null:"Dni de cliente nulo";
		this.nombre = nombre;
		this.dni = dni;
	}

	/**
	 * Metodo que agrega una contratacion a la lista de contrataciones del cliente
	 * <b>Pre: </b> La contratacion no puede ser null<br>
	 * @param contratacion: Contratacion del cliente
	 * <b>Post: </b> Agrega una contratacion a la lista de contrataciones del cliente.<br>
	 */
	public void addContratacion(Contratacion contratacion) {
		assert contratacion != null:"Contratacion nula";
		int oldSize = this.contrataciones.size();
		this.contrataciones.add(contratacion);
		assert this.contrataciones.size() == oldSize+1: "Fallo postcondicion";
	}
	
	public void addFactura(IFactura factura) {
		assert factura != null:"Factura nula";
		int oldSize = this.facturas.size();
		this.facturas.add(factura);
		assert this.facturas.size() == oldSize+1: "Fallo postcondicion";
	}
	
	/**
	 * @return Devuelve el precio total de todas las contrataciones del cliente.
	 * El pago de los servicios se calcula realizando la sumatoria de los mismos.
	 */
	public double getPagoTotal() {
		Iterator<Contratacion> it = this.contrataciones.iterator();
		double aux=0;
		while (it.hasNext()) {
			aux += it.next().getPrecio();
		}
		return aux;
	}

	
	/**
	 * Metodo que realiza una clonacion profunda del Cliente
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Cliente clonado;
		Iterator<Contratacion> itC = this.contrataciones.iterator();
		clonado = (ClienteFisico) super.clone();
		clonado.contrataciones = (ArrayList<Contratacion>) this.contrataciones.clone();
		clonado.contrataciones.clear();
		while (itC.hasNext()) {
			clonado.contrataciones.add((Contratacion)itC.next().clone());
		}
		return clonado;
	}
	

	@Override
	public String toString() {
		return "cliente " + nombre + ", Dni " + dni + "\nContrataciones: \n"+ contrataciones.toString();
	}


	public ArrayList<IFactura> getFacturas() {
		return facturas;
	}

	public ArrayList<Contratacion> getContrataciones() {
		return contrataciones;
	}
	
	public ArrayList<IFactura> getHistorialFacturas() {
		return historialfacturas;
	}
	
	public void run() {
		//Empresa.getInstancia().solicitarTecnico();
		Empresa.trabajoTecnico(Empresa.getInstancia().solicitarTecnico(), 3000);
	}
	
	
	
	
}
