package persistencia;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Domicilio;
import modelo.Tecnico;
import negocio.Empresa;

public class Transferencia {
	
	public static ClienteDto clienteDtofromCliente(Cliente cliente) {}
	
	public static Cliente clientefromClienteDto(ClienteDto clientedto) {}
	
	
	
	public static DomicilioDto domicilioDtofromDomicilio(Domicilio domicilio) {}
	
	public static Domicilio DomiciliofromDomicilioDto(DomicilioDto domiciliodto) {}
	
	
	
	public static EmpresaDto empresaDtofromEmpresa(Empresa empresa) {
		int i;
		EmpresaDto respuesta = new EmpresaDto();
		respuesta.setNombre(empresa.getNombre());
		ArrayList<ClienteDto> clientesDto = new ArrayList <ClienteDto>();
		for(i=0;i<empresa.getAbonados().size();i++) {
			clientesDto.add(Transferencia.clienteDtofromCliente(empresa.getAbonados().get(i)));
		}
		respuesta.setAbonados(clientesDto);
		
		ArrayList<TecnicoDto> tecnicosDto = new ArrayList <TecnicoDto>();
		for(i=0;i<empresa.getTecnicos().size();i++) {
			tecnicosDto.add(Transferencia.tecnicoDtofromTecnico(empresa.getTecnicos().get(i)));
		}
		respuesta.setTecnicos(tecnicosDto);
		return respuesta;
	}
	
	public static Empresa empresafromEmpresaDto(EmpresaDto empresadto) {
		
	}
	
	
	public static TecnicoDto tecnicoDtofromTecnico(Tecnico tecnico) {
		TecnicoDto respuesta = new TecnicoDto();
		respuesta.setNombre(tecnico.getNombre());
		respuesta.setOcupado(tecnico.isOcupado());
		return respuesta;
	}
	
	public static Tecnico tecnicofromTecnicoDto(TecnicoDto tecnicodto) {
		Tecnico respuesta = new Tecnico(tecnicodto.getNombre());
		return respuesta;
	}
}
