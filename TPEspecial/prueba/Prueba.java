package prueba;
import modelo.*;
import negocio.*;

public class Prueba {

	public static void main(String[] args) {
		
		Empresa e1 = Empresa.getInstancia();
		
		FacturaFactory f = new FacturaFactory();
		FacturaFactory g = null;
		
		Cliente cliente1 = new ClienteJuridico("Matias", "44336072");
		Cliente cliente2 = new ClienteFisico("Bernardo", "43056411");
		
        Domicilio dom1 = new Domicilio("Alice", 6151);
        Domicilio dom2 = new Domicilio("Belgrano", 2530);
        Domicilio dom3 = new Domicilio("Luna Park", 666);
        
        try {
			e1.addDomicilioACliente(cliente1, dom1);
			e1.addDomicilioACliente(cliente1, dom2);
			e1.addDomicilioACliente(cliente2, dom3);
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
        
        Contratacion c1 = new AlarmaVivienda(true, 2, 1, dom1);
        Contratacion c2 = new AlarmaComercio(true, 1, 3, dom2);
        Contratacion c3 = new AlarmaVivienda(false, 4, 3, dom3);
        
        
        try {
			e1.addContratacionACliente(cliente1, c1);
			e1.addContratacionACliente(cliente1, c2);
			e1.addContratacionACliente(cliente2, c3);
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
        
        IAplicaPromo promDor = new PromoDorada();
        IAplicaPromo promPlat = new PromoPlatino();
        
        promDor.aplicarPromocion(c1);
        promPlat.aplicarPromocion(c2);
        
        try {
			e1.addFactura(f, "efectivo", cliente1);
			e1.addFactura(f, "cheque", cliente2);
			e1.addFactura(e1.clonarFactura(e1.getFacturas().get(1))); 
		} catch (ClienteInvalidoException | FactoryInvalidoException | MetodoDePagoInvalidoException | CloneNotSupportedException | FacturaInvalidaException e) {
			e.printStackTrace();
		}
        
        System.out.println(e1.generarReporteFacturas());
	}

}
