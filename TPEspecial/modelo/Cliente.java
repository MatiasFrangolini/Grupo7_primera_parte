package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import controlador.Controlador;
import excepciones.MorosoException;
import excepciones.SinContratacionException;
import negocio.Empresa;
import util.Util;


public abstract class Cliente implements Cloneable, Serializable, Runnable {
   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @throws MorosoException 
	 */
	public void addContratacion(Contratacion contratacion) throws MorosoException {
		assert contratacion != null:"Contratacion nula";
		int oldSize = this.contrataciones.size();
		this.contrataciones.add(contratacion);
		assert this.contrataciones.size() == oldSize+1: "Fallo postcondicion";
	}
	
	public void removeContratacion(Contratacion contratacion) {
		assert contratacion != null:"Contratacion nula";
		int oldSize = this.contrataciones.size();
		this.contrataciones.remove(contratacion);
		assert this.contrataciones.size() == oldSize+1: "Fallo postcondicion";
	}
	
	public void addFactura(IFactura factura) {
		assert factura != null:"Factura nula";
		int oldSize = this.facturas.size();
		this.facturas.add(factura);
		assert this.facturas.size() == oldSize+1: "Fallo postcondicion";
	}
	
	public void addFacturaHistorial(IFactura factura) {
		assert factura != null:"Factura nula";
		int oldSize = this.historialfacturas.size();
		this.historialfacturas.add(factura);
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
		return nombre + ". DNI: " + dni;
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
	
	public void pagarFactura(IFactura factura) throws SinContratacionException {
		this.facturas.remove(factura);
		this.historialfacturas.add(factura);
	}
	
	public void run() {
		Tecnico aux;
		aux=Empresa.getInstancia().getServiciotecnico().trabajaTecnico(this);
		Util.espera(3000);  // Simulo que el tecnico trabaja
		Empresa.getInstancia().getServiciotecnico().terminaTecnico(aux);
	}

	public void actualizarEstado() {
		
	}

	public abstract void addObserver(Controlador controlador);

	public ArrayList<IFactura> getHistorialfacturas() {
		return historialfacturas;
	}

	public void setHistorialfacturas(ArrayList<IFactura> historialfacturas) {
		this.historialfacturas = historialfacturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setContrataciones(ArrayList<Contratacion> contrataciones) {
		this.contrataciones = contrataciones;
	}

	public void setFacturas(ArrayList<IFactura> facturas) {
		this.facturas = facturas;
	}

	public Cliente() {
		super();
	}
	
	
	
	
	
	
}
