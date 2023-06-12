package persistencia;

import java.util.ArrayList;

import modelo.Domicilio;
import modelo.ServicioTecnico;
import modelo.Tecnico;
import negocio.Empresa;

public class Transferencia {
	
	
	//Domicilios
	public static DomicilioDto domicilioDtofromDomicilio(Domicilio domicilio) {
		DomicilioDto respuesta= new DomicilioDto();
		respuesta.setCalle(domicilio.getCalle());
		respuesta.setAltura(domicilio.getAltura());
		return respuesta;
	}
	
	public static Domicilio DomiciliofromDomicilioDto(DomicilioDto domiciliodto) {
		Domicilio respuesta = new Domicilio(domiciliodto.getCalle(),domiciliodto.getAltura()); 
		return respuesta;
	}
	
	//Empresa
	public static EmpresaDto empresaDtofromEmpresa(Empresa empresa) {
		EmpresaDto respuesta = new EmpresaDto();
		respuesta.setNombre(empresa.getNombre());
		respuesta.setAbonados(empresa.getAbonados());
		respuesta.setServiciotecnico(empresa.getServiciotecnico());
		return respuesta;
	}
	
	public static Empresa empresafromEmpresaDto(EmpresaDto empresadto) {
		Empresa respuesta = Empresa.getInstancia();
		respuesta.setNombre(empresadto.getNombre());
		respuesta.setAbonados(empresadto.getAbonados());
		respuesta.setServiciotecnico(empresadto.getServiciotecnico());
		return respuesta;
	}
	

}
