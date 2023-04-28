package modelo;

import java.util.ArrayList;
import java.util.Iterator;


public abstract class Cliente implements Cloneable{
    /**
     * @aggregation composicion
     */
    protected ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();
	protected ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
	private String nombre;
	private String dni;
	
	/**
	 * Constructor de la clase Cliente
	 * <Pre>: nombre debe ser distinto de null
	 * @param nombre: Parametro de tipo string que indica el nombre del cliente
	 * @param dni: Parametro de tipo String que representa el dni del cliente
	 */
	public Cliente(String nombre, String dni) {
		assert nombre != null:"Nombre de cliente nulo";
		this.nombre = nombre;
		this.dni = dni;
	}
	/**
	 * Metodo que agrega un domicilio a la lista de domicilios del cliente
	 * <Pre>: El domicilio no puede ser null
	 * @param domicilio: Domicilio del cliente
	 */
	public void addDomicilio(Domicilio domicilio) {
		this.domicilios.add(domicilio);
	}
	
	/**
	 * Metodo que agrega una contratacion a la lista de contrataciones del cliente
	 * <Pre>: La contratacion no puede ser null
	 * @param contratacion: Contratacion del cliente
	 */
	public void addContratacion(Contratacion contratacion) {
		this.contrataciones.add(contratacion);
	}
	
	/**
	 * @return devuelve el precio total de todas las contrataciones del cliente.
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
