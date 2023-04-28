package presentacion;
import modelo.*;
import negocio.*;

public class Prueba {

	public static void main(String[] args) {
		
		Empresa e1 = Empresa.getInstancia();
		FacturaFactory f = new FacturaFactory();
		FacturaFactory g = null;
		
		Cliente cliente1 = new ClienteJuridico("Matias", "44336072");
        Domicilio dom1 = new Domicilio("Alice", 6151);
        cliente1.addDomicilio(dom1);
        Contratacion c1 = new AlarmaVivienda(true, 2, 1, dom1);
        IAplicaPromo promDor = new PromoDorada();
        promDor.aplicarPromocion(c1);
        cliente1.addContratacion(c1);
        IFactura fact1 = null;
        try {
			e1.addFactura(f, "efectivo", cliente1);
		} catch (ClienteInvalidoException | FactoryInvalidoException e) {
			e.printStackTrace();
		}
        e1.generarReporteFacturas();
	}

}
