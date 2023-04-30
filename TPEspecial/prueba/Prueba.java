package prueba;
import modelo.*;
import negocio.*;

public class Prueba {

	public static void main(String[] args) {
		
		Empresa e1 = Empresa.getInstancia();
		
		FacturaFactory f = new FacturaFactory();
		FacturaFactory g = null;
		
		Cliente cliente1 = null;//new ClienteJuridico("Matias", "44336072");
		Cliente cliente2 = null;//new ClienteFisico("Bernardo", "43056411");
		
		try {
			cliente1 = e1.creaCliente("Matias", "44336072", "fisico");
			cliente2 = e1.creaCliente("Bernardo", "43411056", "juridico");
		} catch (ClienteInvalidoException e) {
			e.printStackTrace();
		}
		
        Domicilio dom1 = null; //new Domicilio("Alice", 6151);
        Domicilio dom2 = null; // Domicilio("Belgrano", 2530);
        Domicilio dom3 = null; //new Domicilio("Luna Park", 666);
        
        try {
        	dom1 = e1.creaDomicilio("Alice", 6151);
        	dom2 = e1.creaDomicilio("Belgrano", 2530);
        	dom3 = e1.creaDomicilio("Luna Park", 666);
			e1.addDomicilioACliente(cliente1, dom1);
			e1.addDomicilioACliente(cliente1, dom2);
			e1.addDomicilioACliente(cliente2, dom3);
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
        
        Contratacion c1 = null;// new AlarmaVivienda(true, 2, 1, dom1);
        Contratacion c2 = null;//new AlarmaComercio(true, 1, 3, dom2);
        Contratacion c3 = null;//new AlarmaVivienda(false, 4, 3, dom3);
        
        
        try {
        	c1 = e1.creaContratacion(true, 2, 1, dom1, "vivienda");
        	c2 = e1.creaContratacion(true, 1, 3, dom2, "comercio");
        	c3 = e1.creaContratacion(false, 4, 3, dom3, "vivienda");
			e1.addContratacionACliente(cliente1, c1);
			e1.addContratacionACliente(cliente1, c2);
			e1.addContratacionACliente(cliente2, c3);
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
        
        System.out.println(e1.generarReporteFacturas());

	/* Creacion de un cliente con domicilio invalido. Descomentar en linea 83 si se desea probar la excepcion.
        Cliente cliente3 = new ClienteJuridico("Ricado", "44336072");
		
		Domicilio dom6 = null;

		try {
			dom6 =  e1.creaDomicilio(null, 1400);
			e1.addDomicilioACliente(cliente3, dom6);
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
	}
    
    Contratacion c4 = new AlarmaVivienda(true, 2, 1, dom6);
    
    try {
		e1.addContratacionACliente(cliente3, c4);
	} catch (DomicilioInvalidoException e) {
		e.printStackTrace();
	}
    
    
    try {
		e1.addFactura(f, "efectivo", cliente3);
	} catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException e) {
		e.printStackTrace();
	}*/
    
   // System.out.println(e1.generarReporteFacturas());
        
        /* Se intenta agregar una contratacion con un domicilio repetido. Descomentar en linea 117 para probar la excepcion.
        Cliente cliente3 = new ClienteJuridico("Ricado", "44336072");
		
        Domicilio dom6 = null;

        try {
        	dom6 =  e1.creaDomicilio("Belgrano", 1400);
        	e1.addDomicilioACliente(cliente3, dom6);
        	e1.addDomicilioACliente(cliente3, dom6);
        } catch (DomicilioInvalidoException e) {
        	e.printStackTrace();
        }

        Contratacion c4 = new AlarmaVivienda(true, 2, 1, dom6);
        Contratacion c5 = new AlarmaVivienda(false, 0, 1, dom6);

        try {
        	e1.addContratacionACliente(cliente3, c4);
        	e1.addContratacionACliente(cliente3, c5);
        } catch (DomicilioInvalidoException e) {
        	e.printStackTrace();
        }


        try {
        	e1.addFactura(f, "efectivo", cliente3);
        } catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException e) {
        	e.printStackTrace();
        }

        System.out.println(e1.generarReporteFacturas());*/
}
	
}
