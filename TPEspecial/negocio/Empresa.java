package negocio;

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
	 * Funcion que imprime la factura.
	 */
	public void generarReporteFacturas() {
		Iterator<IFactura> it = this.facturas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	/**
	 * Agrega una factura al arreglo de facturas de la Empresa.
	 * @param factura: factura que sera agregada al Array.
	 * @throws FacturaInvalidaException: se lanza cuando una factura es null.
	 * <Post>: Agrega una factura a la lista de facturacion de la empresa.
	 */
	public void addFactura(IFactura factura) throws FacturaInvalidaException {
		if (factura != null) 
			this.facturas.add(factura);
		else
			throw new FacturaInvalidaException("La factura que se desea agregar es invalida.");
	}
	
	/**
	 * Metodo sobrecargado que CREA la factura y ademas la agrega al arreglo.
	 * @param f: Factory que creara la factura.
	 * @param medioDePago: parametro String que se usara en el factory, indica el medio de pago utilizado.
	 * @param cliente: parametro de tipo Cliente.
	 * @throws ClienteInvalidoException: Se lanza cuando el cliente es null.
	 * @throws FactoryInvalidoException : Se lanza cuando el Factory es null.
	 * <Post>: Crea una factura y la agrega a la lista de facturacion de la empresa.
	 */
	public void addFactura(FacturaFactory f, String medioDePago, Cliente cliente) throws ClienteInvalidoException, FactoryInvalidoException {
		try {
			if (f != null) {
				if (cliente != null)
					this.facturas.add(f.getFactura(medioDePago, cliente));
				else
					throw new ClienteInvalidoException("No se puede crear una factura para un cliente invalido.");
			} else throw new FactoryInvalidoException("El factory que se quiere utilizar es invalido.");
		} catch (MetodoDePagoInvalidoException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	/**
	 * Metodo que agrega una contratacion al arreglo de contrataciones de un Cliente.
	 * @param cliente: parametro Cliente
	 * @param contratacion: parametro Contratacion que sera agregado a un arreglo.
	 * @throws DomicilioInvalidoException
	 * <Post>: Actualiza el arreglo de contrataciones de un Cliente agregando una Contratacion pasada como parametro.
	 */
	public void addContratacionACliente(Cliente cliente, Contratacion contratacion) throws DomicilioInvalidoException {
		if (contratacion.getDomicilio() == null) {
			throw new DomicilioNuloException("El domicilio no puede ser nulo");
		} else {
			if (!(domicilioYaExiste(cliente.getDomicilios(), contratacion.getDomicilio())))
				cliente.addContratacion(contratacion);
			else
				throw new DomicilioYaExisteException("Ese domicilio ya existia en otra contratacion");
		}
	}
	
	
	/**
	 * Metodo que recorre un array y determina si un domicilio pasado como parametro existe en el mismo.
	 * @param domicilios: parametro ArrayList con todos los domicilios.
	 * @param domicilio: parametro de tipo Domicilio que sera buscado.
	 * @return
	 */
	public boolean domicilioYaExiste(ArrayList<Domicilio> domicilios,Domicilio domicilio) {
		Iterator<Domicilio> it = domicilios.iterator();
		int aux = 1;
		while (aux != 0 && it.hasNext()) {
			aux = it.next().compareTo(domicilio);
		}
		if (aux == 0) {
			return true;
		}else
			return false;
	}
	
}
