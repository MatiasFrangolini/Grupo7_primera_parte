package presentacion;

import negocio.Empresa;

public class Presentacion {
	
	
	public static void escribeReporteFacturas() {
		System.out.println(Empresa.getInstancia().generarReporteFacturas());
	}
}
