package negocio;
import modelo.*;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.*;

/**
 * Esta clase solo puede ser instanciada una vez. 
 * Por eso implementa un patron singleton.
 *
 */
public class Empresa {
	
	
	private static Empresa instancia = null;
	private String nombre;
	private ArrayList<IFactura> facturas = new ArrayList<IFactura>();
	
	private Empresa() {
		nombre = "Grupo 7";
	}
	
	/**
	 * Metodo propio del PatronSingleton que devuelve una instancia de la clase en caso de que no se haya instanciado nunca antes.
	 * @return
	 */
	public static Empresa getInstancia() {
		if (instancia == null)
			instancia = new Empresa();
		return instancia;
	}
	
	/**
	 * Funcion que devuelve un String que contiene toda la informacion de las facturas.
	 */
	public String generarReporteFacturas() {
		Iterator<IFactura> it = this.facturas.iterator();
		String aux = "";
		while (it.hasNext()) {
			aux += it.next().toString();
		}
		return aux;
	}
	
	/**
	 * Agrega una factura al arreglo de facturas de la Empresa.
	 * @param factura: factura que sera agregada al Array.
	 * @throws FacturaInvalidaException: se lanza cuando una factura es null.
	 * <Post>: Agrega una factura a la lista de facturacion de la empresa.
	 */
	public void addFactura(IFactura factura) throws FacturaInvalidaException {
		int oldsize = this.facturas.size();
		if (factura != null) 
			this.facturas.add(factura);
		else
			throw new FacturaInvalidaException("La factura que se desea agregar es invalida.");
		assert this.facturas.size() == oldsize+1 : "Fallo postcondicion.";
	}
	
	/**
	 * Metodo sobrecargado que CREA la factura y ademas la agrega al arreglo.
	 * @param f: Factory que creara la factura.
	 * @param medioDePago: parametro String que se usara en el factory, indica el medio de pago utilizado.
	 * @param cliente: parametro de tipo Cliente.
	 * @throws MetodoDePagoInvalidoException: Se lanza cuando el metodo de pago no es valido.
	 * @throws ClienteInvalidoException: Se lanza cuando el cliente es null.
	 * @throws FactoryInvalidoException : Se lanza cuando el Factory es null.
	 * <Post>: Crea una factura y la agrega a la lista de facturacion de la empresa.
	 */
	public void addFactura(FacturaFactory f, String medioDePago, Cliente cliente) throws MetodoDePagoInvalidoException, ClienteInvalidoException, FactoryInvalidoException {
		int oldsize = this.facturas.size();
		if (f != null) {
			if (cliente != null)
				this.facturas.add(f.getFactura(medioDePago, cliente));
			else
				throw new ClienteInvalidoException("No se puede crear una factura para un cliente invalido.");
		} else throw new FactoryInvalidoException("El factory que se quiere utilizar es invalido.");
		assert this.facturas.size() == oldsize+1 : "Fallo postcondicion.";
	}
	
	/**
	 * Metodo que agrega una contratacion al arreglo de contrataciones de un Cliente.
	 * @param cliente: parametro Cliente
	 * @param contratacion: parametro Contratacion que sera agregado a un arreglo.
	 * @throws DomicilioInvalidoException
	 * <Post>: Actualiza el arreglo de contrataciones de un Cliente agregando una Contratacion pasada como parametro.
	 */
	public void addContratacionACliente(Cliente cliente, Contratacion contratacion) throws DomicilioInvalidoException {
		int oldsize = cliente.getContrataciones().size();
		if (contratacion.getDomicilio() == null) {
			throw new DomicilioNuloException("El domicilio no puede ser nulo");
		} else {
			if (!(domicilioYaExiste(cliente.getContrataciones(), contratacion.getDomicilio())))
				cliente.addContratacion(contratacion);
			else
				throw new DomicilioYaExisteException("Ese domicilio ya existia en otra contratacion");
		}
		assert cliente.getContrataciones().size() == oldsize+1 : "Fallo postcondicion.";
	}
	
	/**
	 * Metodo que agrega un domicilio al arreglo de domicilios de un Cliente.
	 * @param cliente: Cliente
	 * @param domicilio: Domicilio que sera agregado a un arreglo.
	 * @throws DomicilioInvalidoException
	 * <Post>: Actualiza el arreglo de domicilios de un Cliente agregando un domicilio pasada como parametro.
	 */
	public void addDomicilioACliente(Cliente cliente, Domicilio domicilio) throws DomicilioInvalidoException {
		int oldsize = cliente.getDomicilios().size();
		if (domicilio == null) {
			throw new DomicilioNuloException("El domicilio no puede ser nulo");
		} else {
			cliente.addDomicilio(domicilio);
		}
		assert cliente.getDomicilios().size() == oldsize+1 : "Fallo postcondicion.";
	}
	
	/**
	 * Metodo que se encarga de clonar una factura(Clonacion profunda).
	 * <b>Pre: </b>Factura no puede ser null<br>
	 * @param factura: Factura que se quiere clonar. 
	 * @return Devuelve un clon del parametro factura.
	 * @throws CloneNotSupportedException Si alguna clase del proceso de clonacion profunda no admitia clonacion.
	 */
	public IFactura clonarFactura(IFactura factura) throws CloneNotSupportedException {
		assert factura != null:"Factura nula";
		return (IFactura)factura.clone();
	}
	
	/**
	 * Metodo que recorre un array y determina si un domicilio pasado como parametro existe en el mismo.
	 * @param contrataciones: parametro ArrayList con todas las contrataciones de un cliente.
	 * @param domicilio: parametro de tipo Domicilio que sera buscado.
	 * @return Devuelve true si el domicilio ya existe, false en caso contrario.
	 */
	public boolean domicilioYaExiste(ArrayList<Contratacion> contrataciones,Domicilio domicilio) {
		Iterator<Contratacion> it = contrataciones.iterator();
		int aux = 1;
		while (aux != 0 && it.hasNext()) {
			aux = it.next().getDomicilio().compareTo(domicilio);
		}
		if (aux == 0) {
			return true;
		}else
			return false;
	}

	
	public Domicilio creaDomicilio(String calle, int altura) throws DomicilioInvalidoException {
		if (calle != null && !(calle.equals("") && altura>0))
			return new Domicilio(calle,altura);
		else
			throw new DomicilioInvalidoException("No se pudo crear el domicilio.");
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<IFactura> getFacturas() {
		return facturas;
	}
	
	
	
}
