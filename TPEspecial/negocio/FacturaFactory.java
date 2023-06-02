package negocio;



import excepciones.MetodoDePagoInvalidoException;
import modelo.Cliente;
import modelo.Factura;
import modelo.IFactura;

/**
 * 
 * Patron Factory encargado de crear las Facturas y decorarlas.
 *
 */
public class FacturaFactory {
	/**
	 * 
	 * @param medioDePago String que contiene el medio de pago a utilizar.
	 * @param cliente     Cliente de la factura.
	 * <b>Pre: </b> Cliente no puede ser nulo.<br>
	 * @return Crea una instancia de factura en caso de recibir parametros validos.
	 * @throws MetodoDePagoInvalidoException
	 */
	public IFactura getFactura(String medioDePago, Cliente cliente) throws MetodoDePagoInvalidoException {
		assert cliente != null : "Cliente nulo";
		IFactura factura = new Factura(cliente);
		IFactura respuesta = null;

			if (medioDePago.equalsIgnoreCase("Efectivo"))
				respuesta = new DecoratorEfectivo(factura);
			else if (medioDePago.equalsIgnoreCase("Cheque"))
				respuesta = new DecoratorCheque(factura);
			else if (medioDePago.equalsIgnoreCase("Tarjeta"))
				respuesta = new DecoratorTarjeta(factura);
		if (respuesta !=null)
			return respuesta;
		else
			throw new MetodoDePagoInvalidoException(medioDePago);

	}

}
