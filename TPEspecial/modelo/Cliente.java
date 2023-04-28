package modelo;

import java.util.ArrayList;
import java.util.Iterator;


public abstract class Cliente implements Cloneable{
   
    protected ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>(); //Relacion de composicion
	protected ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>(); //Relacion de composicion
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
		assert nombre != null:"Nombre de cliente nulo";
		assert dni != null:"Dni de cliente nulo";
		this.nombre = nombre;
		this.dni = dni;
	}
	/**
	 * Metodo que agrega un domicilio a la lista de domicilios del cliente
	 * <b>Pre: </b> El domicilio no puede ser null
	 * @param domicilio: Domicilio del cliente
	 * <b>Post: </b> Agrega un domicilio a la lista de domicilios del cliente.
	 */
	public void addDomicilio(Domicilio domicilio) {
		assert domicilio != null:"Domicilio nulo";
		int oldSize = this.domicilios.size();
		this.domicilios.add(domicilio);
		assert this.domicilios.size() == oldSize+1: "Fallo postcondicion";
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
		Iterator<Domicilio> itD = this.domicilios.iterator();
		clonado = (ClienteFisico) super.clone();
		clonado.contrataciones = (ArrayList<Contratacion>) this.contrataciones.clone();
		clonado.contrataciones.clear();
		while (itC.hasNext()) {
			clonado.contrataciones.add((Contratacion)itC.next().clone());
		}
		clonado.domicilios = (ArrayList<Domicilio>)this.domicilios.clone();
		clonado.domicilios.clear();
		while (itD.hasNext()) {
			clonado.domicilios.add((Domicilio)itD.next().clone());
		}
		return clonado;
	}
	
	/**
	 * Metodo que imprime los domicilios de un Cliente
	 */
	public void listarDomicilios() {
		Iterator<Domicilio> it = this.domicilios.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	@Override
	public String toString() {
		return "cliente " + nombre + ", Dni " + dni + "\nContrataciones: \n"+ contrataciones.toString();
	}

	public ArrayList<Domicilio> getDomicilios() {
		return domicilios;
	}

	public ArrayList<Contratacion> getContrataciones() {
		return contrataciones;
	}
	
	
	
	
	
	
	
}
