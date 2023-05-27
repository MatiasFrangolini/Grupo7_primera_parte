package negocio;
import modelo.*;
import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ClienteInvalidoException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioInvalidoException;
import excepciones.DomicilioNoPerteneceAClienteException;
import excepciones.DomicilioNuloException;
import excepciones.DomicilioYaExisteException;
import excepciones.FactoryInvalidoException;
import excepciones.FacturaInvalidaException;
import excepciones.MetodoDePagoInvalidoException;

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
	 * Metodo propio del PatronSingleton.
	 * @return devuelve una instancia de la clase en caso de que no se haya instanciado nunca antes.
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
	 * <b>Post: </b> Agrega una factura a la lista de facturacion de la empresa.<br>
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
	 * <b>Post: </b> Crea una factura y la agrega a la lista de facturacion de la empresa.<br>
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
	 * @throws ContratacionInvalidaException Si la contratacion es nula
	 * @throws ClienteInvalidoException Si el cliente es nulo
	 * @throws DomicilioNoPerteneceAClienteException Si es domicilio de la contratacion no es un domicilio del cliente
	 * @throws DomicilioYaExisteException Si ese domicilio ya tenia una contratacion
	 * <b>Post: </b> Actualiza el arreglo de contrataciones de un Cliente agregando una Contratacion pasada como parametro.<br>
	 */
	public void addContratacionACliente(Cliente cliente, Contratacion contratacion) throws DomicilioYaExisteException,DomicilioNoPerteneceAClienteException, ClienteInvalidoException, ContratacionInvalidaException {
		if (cliente == null)
			throw new ClienteInvalidoException("El cliente no puede ser nulo");
		int oldsize = cliente.getContrataciones().size();
		if (contratacion == null) {
			throw new ContratacionInvalidaException("La contratacion no puede ser nula");
		} else {
			if (puedeAgregarContratacion(cliente, contratacion)) {
				if (!(domicilioYaExiste(cliente.getContrataciones(), contratacion.getDomicilio())))
					cliente.addContratacion(contratacion);
				else
					throw new DomicilioYaExisteException("Ese domicilio ya existia en otra contratacion");
			} else
				throw new DomicilioNoPerteneceAClienteException("El domicilio de esa contratacion no pertenece al cliente");
		}
		assert cliente.getContrataciones().size() == oldsize+1 : "Fallo postcondicion.";
	}
	
	
	/**
	 * Funcion booleana para saber si el cliente puede recibir cierta contratacion.
	 */
	private boolean puedeAgregarContratacion(Cliente cliente, Contratacion contratacion) {
		if (cliente.getDomicilios().contains(contratacion.getDomicilio()))
			return true;
		else
			return false;
	}

	/**
	 * Metodo que agrega un domicilio al arreglo de domicilios de un Cliente.
	 * @param cliente: Cliente
	 * @param domicilio: Domicilio que sera agregado a un arreglo.
	 * @throws ClienteInvalidoException 
	 * @throws DomicilioInvalidoException
	 * <b>Post: </b> Actualiza el arreglo de domicilios de un Cliente agregando un domicilio pasada como parametro.<br>
	 */
	public void addDomicilioACliente(Cliente cliente, Domicilio domicilio) throws DomicilioNuloException, ClienteInvalidoException {
		if (cliente == null)
			throw new ClienteInvalidoException("El cliente no puede ser nulo");
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
	 * @param factura: Factura que se quiere clonar. 
	 * @return Devuelve un clon del parametro factura.
	 * @throws CloneNotSupportedException Si alguna clase del proceso de clonacion profunda no admitia clonacion.
	 * @throws FacturaInvalidaException 
	 */
	public IFactura clonarFactura(IFactura factura) throws CloneNotSupportedException, FacturaInvalidaException {
		if (factura != null)
			return (IFactura)factura.clone();
		else
			throw new FacturaInvalidaException("Se intento clonar una factura nula");
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
		} else
			return false;
	}

	/**
	 * Funcion que valida los datos que llaman al constructor de Domicilio.
	 * @param calle Nombre de la calle del domicilio
	 * @param altura Numero de la calle
	 * @return Devuelve una instancia de la clase Domicilio
	 * @throws DomicilioInvalidoException Si la calle es null o string vacío, o si la altura no es positiva.
	 */
	public Domicilio creaDomicilio(String calle, int altura) throws DomicilioInvalidoException {
		if (calle != null && !(calle.equals("")) && altura>0)
			return new Domicilio(calle,altura);
		else
			throw new DomicilioInvalidoException("No se pudo crear el domicilio.");
	}
	
	
	/**
	 * Funcion que valida los datos que llaman al constructor de Cliente
	 * @param nombre Nombre del Cliente
	 * @param dni Dni del cliente
	 * @param tipo Tipo del cliente
	 * @return Devuelve una instancia de un hijo de Cliente, depende del parametro tipo
	 * @throws ClienteInvalidoException Si los parametros son null o vacios, o si el tipo no es correcto.
	 */
	public Cliente creaCliente(String nombre, String dni, String tipo) throws ClienteInvalidoException {
		if (nombre != null && !(nombre.equals("")) && dni != null && !(dni.equals("")) && tipo != null)
			
			if (tipo.equalsIgnoreCase("fisico"))
				return new ClienteFisico(nombre,dni);
			else if (tipo.equalsIgnoreCase("juridico"))
				return  new ClienteJuridico(nombre,dni);
			else
				throw new ClienteInvalidoException("Tipo de cliente no valido.");
				
		else
			throw new ClienteInvalidoException("No se pudo crear el cliente.");
	}
	
	
	/**
	 * 
	 * @param movilAcompanamiento : parametro de tipo boolean que indica si se contrato un movil de acompanamiento
     * @param cantCamaras : parametro de tipo int que indica la cantidad de camaras contratadas
     * @param cantBotones : parametro de tipo int que indica la cantidad de botones contratados
     * @param domicilio : parametro de tipo string que representa el domicilio del cliente
	 * @param tipo Tipo de contratacion
	 * @return Devuelve una instancia de un hijo de Contratacion, dependiendo del parametro tipo.
	 * @throws DomicilioNuloException Si el domicilio es nulo
	 * @throws ContratacionInvalidaException Si no se pudo instanciar la contratacion por valores invalidos.
	 */
	public Contratacion creaContratacion(boolean movilAcompaniamiento, int cantCamaras, int cantBotones, Domicilio domicilio, String tipo) throws DomicilioNuloException, ContratacionInvalidaException {
		if (domicilio != null)
			if (cantCamaras >= 0 && cantBotones>=0 && tipo != null)
				if (tipo.equalsIgnoreCase("vivienda"))
					return new AlarmaVivienda(movilAcompaniamiento, cantCamaras, cantBotones, domicilio);
				else if (tipo.equalsIgnoreCase("comercio"))
					return new AlarmaComercio(movilAcompaniamiento, cantCamaras, cantBotones, domicilio);
				else
					throw  new ContratacionInvalidaException("No se conoce ese tipo de contratacion");
			else
				throw  new ContratacionInvalidaException("No se pudo instanciar la  contratacion");
		else
			throw new DomicilioNuloException("Se quiso crear una contratacion con un domicilio nulo");
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<IFactura> getFacturas() {
		return facturas;
	}
	
	
	
}
