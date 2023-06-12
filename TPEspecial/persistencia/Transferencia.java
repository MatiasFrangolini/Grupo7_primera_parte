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
	
	
	//Servicio tecnico
	public static ServicioTecnicoDto servicioTecnicoDtofromServicioTecnico(ServicioTecnico st) {
		ServicioTecnicoDto respuesta = new ServicioTecnicoDto();
		int i;
		ArrayList<TecnicoDto> tecnicosDto = new ArrayList <TecnicoDto>();
		for(i=0;i<st.getTecnicos().size();i++) {
			tecnicosDto.add(Transferencia.tecnicoDtofromTecnico(st.getTecnicos().get(i)));
		}
		respuesta.setTecnicos(tecnicosDto);
		return respuesta;
	}
	
	public static ServicioTecnico servicioTecnicofromServicioTecnicoDto(ServicioTecnicoDto st) {
		ServicioTecnico respuesta = new ServicioTecnico();
		int i;
		ArrayList<Tecnico> tecnicos = new ArrayList <Tecnico>();
		for(i=0;i<st.getTecnicos().size();i++) {
			tecnicos.add(Transferencia.tecnicofromTecnicoDto(st.getTecnicos().get(i)));
		}
		respuesta.setTecnicos(tecnicos);
		return respuesta;
	}
	
	//Empresa
	public static EmpresaDto empresaDtofromEmpresa(Empresa empresa) {
		EmpresaDto respuesta = new EmpresaDto();
		respuesta.setNombre(empresa.getNombre());
		respuesta.setAbonados(empresa.getAbonados());
		respuesta.setServiciotecnico(Transferencia.servicioTecnicoDtofromServicioTecnico(empresa.getServiciotecnico()));
		return respuesta;
	}
	
	public static Empresa empresafromEmpresaDto(EmpresaDto empresadto) {
		Empresa respuesta = Empresa.getInstancia();
		respuesta.setNombre(empresadto.getNombre());
		respuesta.setAbonados(empresadto.getAbonados());
		respuesta.setServiciotecnico(Transferencia.servicioTecnicofromServicioTecnicoDto(empresadto.getServiciotecnico()));
		return respuesta;
	}
	
	
	//Tecnico
	public static TecnicoDto tecnicoDtofromTecnico(Tecnico tecnico) {
		TecnicoDto respuesta = new TecnicoDto();
		respuesta.setNombre(tecnico.getNombre());
		respuesta.setOcupado(tecnico.isOcupado());
		respuesta.setCliente(tecnico.getCliente());
		return respuesta;
	}
	
	public static Tecnico tecnicofromTecnicoDto(TecnicoDto tecnicodto) {
		Tecnico respuesta = new Tecnico(tecnicodto.getNombre());
		respuesta.setCliente(tecnicodto.getCliente());
		return respuesta;
	}
}
