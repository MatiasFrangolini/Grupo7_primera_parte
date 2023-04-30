package prueba;
import modelo.*;
import negocio.*;
import presentacion.Presentacion;

public class Prueba {

	public static void main(String[] args) {
		
		Empresa e1 = Empresa.getInstancia();
		
		FacturaFactory f = new FacturaFactory();
		FacturaFactory g = null;
		
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Cliente cliente5 = null;
		Cliente cliente6 = null;
		Cliente cliente7 = null;
		Cliente cliente8 = null;
		
		try {
			cliente1 = e1.creaCliente("Matias", "44336072", "fisico");
			cliente2 = e1.creaCliente("Bernardo", "43411056", "juridico");
			cliente5 = e1.creaCliente("Pedro", "41055870", "fisico");
			cliente6 = e1.creaCliente("Francisco", "40505303", "juridico");
			cliente7 = e1.creaCliente("Messi", "10101010", "fisico ");
			cliente8 = e1.creaCliente("Diego", "01010101", "juridico");
		} catch (ClienteInvalidoException e) {
			e.printStackTrace();
		}
		
        Domicilio dom1 = null;
        Domicilio dom2 = null;
        Domicilio dom3 = null;
        Domicilio dom4 = null;
        Domicilio dom5 = null;
        Domicilio dom7 = null;
        Domicilio dom8 = null;
        Domicilio dom9 = null;
        Domicilio dom10 = null;
        
        try {
        	dom1 = e1.creaDomicilio("Alice", 6151);
        	dom2 = e1.creaDomicilio("Belgrano", 2530);
        	dom3 = e1.creaDomicilio("Luna Park", 666);
        	dom4 = e1.creaDomicilio("Alice", 6150);
        	dom5 = e1.creaDomicilio("Constitucion", 6152);
        	dom7 = e1.creaDomicilio("Tejedor", 6153);
        	dom8 = e1.creaDomicilio("Jara", 6666);
        	dom9 = e1.creaDomicilio("Juan B Justo", 7777);
        	dom10 = e1.creaDomicilio("Juan Jose Paso", 881);
			e1.addDomicilioACliente(cliente1, dom1);
			e1.addDomicilioACliente(cliente1, dom2);
			e1.addDomicilioACliente(cliente2, dom3);
			e1.addDomicilioACliente(cliente5, dom4);
			e1.addDomicilioACliente(cliente6, dom5);
			e1.addDomicilioACliente(cliente7, dom7);
			e1.addDomicilioACliente(cliente8, dom8);
			e1.addDomicilioACliente(cliente7, dom9);
			e1.addDomicilioACliente(cliente7, dom10);
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
        
        Contratacion c1 = null;
        Contratacion c2 = null;
        Contratacion c3 = null;
        Contratacion c4 = null;
        Contratacion c5 = null;
        Contratacion c6 = null;
        Contratacion c7 = null;
        Contratacion c8 = null;
        Contratacion c9 = null;
        
        try {
        	c1 = e1.creaContratacion(true, 2, 1, dom1, "vivienda");
        	c2 = e1.creaContratacion(true, 1, 3, dom2, "comercio");
        	c3 = e1.creaContratacion(false, 4, 3, dom3, "vivienda");
        	c4 = e1.creaContratacion(true, 2, 4, dom4, "comercio");
        	c5 = e1.creaContratacion(true, 5, 1, dom5, "vivienda");
        	c6 = e1.creaContratacion(false, 3, 3, dom7, "comercio");
        	c7 = e1.creaContratacion(true, 0, 1, dom8, "vivienda");
        	c8 = e1.creaContratacion(true, 1, 1, dom9, "comercio");
        	c9 = e1.creaContratacion(false, 2, 5, dom10, "vivienda");
        	
        	e1.addContratacionACliente(cliente1, c1);
			e1.addContratacionACliente(cliente1, c2);
			e1.addContratacionACliente(cliente2, c3);
			e1.addContratacionACliente(cliente5, c4);
			e1.addContratacionACliente(cliente6, c5);
			e1.addContratacionACliente(cliente7, c6);
			e1.addContratacionACliente(cliente8, c7);
			e1.addContratacionACliente(cliente7, c3);
		} catch (DomicilioInvalidoException | ContratacionInvalidaException e) {
			e.printStackTrace();
		}
        
        IAplicaPromo promDor = new PromoDorada();
        IAplicaPromo promPlat = new PromoPlatino();
        
        promDor.aplicarPromocion(c1);
        promPlat.aplicarPromocion(c2);
        
        try {
			e1.addFactura(f, "efectivo", cliente1);
			e1.addFactura(f, "cheque", cliente2);
			e1.addFactura(e1.clonarFactura(e1.getFacturas().get(1))); //Cambiar numero de factura para probar las clonaciones. Un juridico es siempre clonable 
		} catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException | CloneNotSupportedException | FacturaInvalidaException e) {
			e.printStackTrace();
		}
        
        Presentacion.escribeReporteFacturas();

	    //Creacion de un cliente con domicilio invalido. Descomentar en linea 83 si se desea probar la excepcion.
        /*Cliente cliente3 = null;//new ClienteJuridico("Ricardo", "44336072");
		
		Domicilio dom6 = null;

		try {
			cliente3 = e1.creaCliente("Ricardo", "44336072", "juridico");
			dom6 =  e1.creaDomicilio(null, 1400);
			e1.addDomicilioACliente(cliente3, dom6);
		} catch (DomicilioInvalidoException | ClienteInvalidoException e) {
			e.printStackTrace();
		}
    
		Contratacion c4 = null;//new AlarmaVivienda(true, 2, 1, dom6);
    
		try {
			c4 = e1.creaContratacion(true, 2, 1, dom6, "vivienda");
			e1.addContratacionACliente(cliente3, c4);
		} catch (DomicilioInvalidoException | ContratacionInvalidaException e) {
			e.printStackTrace();
		}
    
    
		try {
			e1.addFactura(f, "efectivo", cliente3);
		} catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException e) {
			e.printStackTrace();
		}
    
		Presentacion.escribeReporteFacturas();*/
        
        //Se intenta agregar una contratacion con un domicilio repetido. Descomentar en linea 117 para probar la excepcion.
        /*Cliente cliente4 = null;
		
        Domicilio dom7 = null;

        try {
        	cliente4 = e1.creaCliente("Pedro", "44554455", "fisico");
        	dom7 =  e1.creaDomicilio("Belgrano", 1400);
        	e1.addDomicilioACliente(cliente4, dom7);
        	e1.addDomicilioACliente(cliente4, dom7);
        } catch (DomicilioInvalidoException | ClienteInvalidoException e) {
        	e.printStackTrace();
        }

        Contratacion c5 = null;
        Contratacion c6 = null;

        try {
        	c5 = e1.creaContratacion(true, 2, 1, dom7, "vivienda");
        	c6 = e1.creaContratacion(false, 0, 1, dom7, "comercio");
        	e1.addContratacionACliente(cliente3, c4);
        	e1.addContratacionACliente(cliente3, c5);
        } catch (DomicilioInvalidoException | ContratacionInvalidaException e) {
        	e.printStackTrace();
        }


        try {
        	e1.addFactura(f, "efectivo", cliente4);
        } catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException e) {
        	e.printStackTrace();
        }

        Presentacion.escribeReporteFacturas();*/
}
	
}
