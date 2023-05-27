package prueba;
import excepciones.ClienteInvalidoException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioInvalidoException;
import excepciones.FactoryInvalidoException;
import excepciones.FacturaInvalidaException;
import excepciones.MetodoDePagoInvalidoException;
import modelo.*;
import negocio.*;
import presentacion.Presentacion;

public class Prueba {

	public static void main(String[] args) {
		
		/*******    HAY CIERTAS LINEAS COMENTADAS, SON LAS QUE LANZAN EXCEPCIONES, DESCOMENTARLAS PARA PROBARLAS     *******/
		
		
		Empresa e1 = Empresa.getInstancia();
		
		FacturaFactory f = new FacturaFactory();
		FacturaFactory g = null;
		
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Cliente cliente3 = null;
		Cliente cliente4 = null;
		Cliente cliente5 = null;
		Cliente cliente6 = null;
		
		try {
			cliente1 = e1.creaCliente("Matias", "44336072", "fisico");
			cliente2 = e1.creaCliente("Bernardo", "43411056", "juridico");
			cliente3 = e1.creaCliente("Pedro", "41055870", "fisico");
			cliente4 = e1.creaCliente("Francisco", "40505303", "juridico");
			cliente5 = e1.creaCliente("Messi", "10101010", "fisico");
			cliente6 = e1.creaCliente("Diego", "01010101", "juridico");
			//cliente6 = e1.creaCliente(null, "01010101", "juridico");
		} catch (ClienteInvalidoException e) {
			e.printStackTrace();
		}
		
        Domicilio dom1 = null;
        Domicilio dom2 = null;
        Domicilio dom3 = null;
        Domicilio dom4 = null;
        Domicilio dom5 = null;
        Domicilio dom6 = null;
        Domicilio dom7 = null;
        Domicilio dom8 = null;
        Domicilio dom9 = null;
        
        try {
        	dom1 = e1.creaDomicilio("Alice", 6151);
        	dom2 = e1.creaDomicilio("Belgrano", 2530);
        	dom3 = e1.creaDomicilio("Luna Park", 666);
        	dom4 = e1.creaDomicilio("Alice", 6150);
        	dom5 = e1.creaDomicilio("Constitucion", 6152);
        	dom6 = e1.creaDomicilio("Tejedor", 6153);
        	dom7 = e1.creaDomicilio("Jara", 6666);
        	dom8 = e1.creaDomicilio("Juan B Justo", 7777);
        	dom9 = e1.creaDomicilio("Juan Jose Paso", 881);
        	//dom9 = e1.creaDomicilio("Juan Jose Paso", -5);
        	//dom9 = e1.creaDomicilio("", 881);
        	
        	
			e1.addDomicilioACliente(cliente1, dom1);
			e1.addDomicilioACliente(cliente1, dom2);
			e1.addDomicilioACliente(cliente2, dom3);
			e1.addDomicilioACliente(cliente3, dom4);
			e1.addDomicilioACliente(cliente4, dom5);
			e1.addDomicilioACliente(cliente5, dom6);
			e1.addDomicilioACliente(cliente6, dom7);
			e1.addDomicilioACliente(cliente5, dom8);
			e1.addDomicilioACliente(cliente5, dom9);
			//e1.addDomicilioACliente(cliente5, null);
			//e1.addDomicilioACliente(null, dom9);
		} catch (DomicilioInvalidoException | ClienteInvalidoException e) {
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
        	c6 = e1.creaContratacion(false, 3, 3, dom6, "comercio");
        	c7 = e1.creaContratacion(true, 0, 1, dom7, "vivienda");
        	c8 = e1.creaContratacion(true, 1, 1, dom8, "comercio");
        	c9 = e1.creaContratacion(false, 2, 5, dom9, "vivienda");
        	//c9 = e1.creaContratacion(false, 2, 5, dom9, "");
        	//c9 = e1.creaContratacion(false, 2, 5, null, "vivienda");
        	
        	e1.addContratacionACliente(cliente1, c1);
			e1.addContratacionACliente(cliente1, c2);
			e1.addContratacionACliente(cliente2, c3);
			e1.addContratacionACliente(cliente3, c4);
			e1.addContratacionACliente(cliente4, c5);
			e1.addContratacionACliente(cliente5, c6);
			e1.addContratacionACliente(cliente6, c7);
			e1.addContratacionACliente(cliente5, c8);
			e1.addContratacionACliente(cliente5, c9);
			//e1.addContratacionACliente(null, c9);
			//e1.addContratacionACliente(cliente5, null);
			
			
		} catch (DomicilioInvalidoException | ContratacionInvalidaException | ClienteInvalidoException e) {
			e.printStackTrace();
		}
        
        IAplicaPromo promDor = new PromoDorada();
        IAplicaPromo promPlat = new PromoPlatino();
        
        promDor.aplicarPromocion(c1);
        promDor.aplicarPromocion(c4);
        promDor.aplicarPromocion(c5);
        promDor.aplicarPromocion(c7);
        
        promPlat.aplicarPromocion(c2);
        promPlat.aplicarPromocion(c3);
        promPlat.aplicarPromocion(c6);
        promPlat.aplicarPromocion(c8);
        
        try {
			e1.addFactura(f, "efectivo", cliente1); //fisico
			e1.addFactura(f, "efectivo", cliente2); //juridico
			e1.addFactura(f, "tarjeta", cliente3); //fisico
			e1.addFactura(f, "tarjeta", cliente4); //juridico
			e1.addFactura(f, "cheque", cliente5); //fisico
			e1.addFactura(f, "cheque", cliente6); //juridico
			//e1.addFactura(g, "cheque", cliente6); //juridico
			
			e1.addFactura(e1.clonarFactura(e1.getFacturas().get(0))); //Cambiar numero de factura para probar las clonaciones. Un juridico no admite clonacion. 
			//e1.addFactura(e1.clonarFactura(e1.getFacturas().get(1)));
			
		} catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException | CloneNotSupportedException | FacturaInvalidaException e) {
			e.printStackTrace();
		}
        
        Presentacion.escribeReporteFacturas();

	    
	}
}
