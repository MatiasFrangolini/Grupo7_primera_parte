package persistencia;

import java.util.ArrayList;

import modelo.AlarmaComercio;
import modelo.AlarmaVivienda;
import modelo.Cliente;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.ConContratacionState;
import modelo.Contratacion;
import modelo.Domicilio;
import modelo.MorosoState;
import modelo.PersonaState;
import modelo.SinContratacionState;
import modelo.Tecnico;
import negocio.Empresa;

public class Transferencia {
	
	//State
	public static PersonaStateDto PersonaStateDtofromPersonaState(PersonaState personastate) {
		PersonaStateDto respuesta=new PersonaStateDto();
		respuesta.setC(Transferencia.clienteFisicoDtofromClienteFisico(personastate.getC()));
		return respuesta;
	}
	
	
	
	
	//Estados
	public static MorosoState MorosoStatefromPersonaStateDto(PersonaStateDto personastatedto) {
		MorosoState respuesta=new MorosoState(Transferencia.clienteFisicofromClienteFisicoDto(personastatedto.getC()));
		return respuesta;
	}
	
	public static ConContratacionState ConContratacionStatefromPersonaStateDto(PersonaStateDto personastatedto) {
		ConContratacionState respuesta=new ConContratacionState(Transferencia.clienteFisicofromClienteFisicoDto(personastatedto.getC()));
		return respuesta;
	}
	
	public static SinContratacionState SinContratacionStatefromPersonaStateDto(PersonaStateDto personastatedto) {
		SinContratacionState respuesta=new SinContratacionState(Transferencia.clienteFisicofromClienteFisicoDto(personastatedto.getC()));
		return respuesta;
	}
	
	
	
	//Contrataciones
	public static AlarmaComercio AlarmaComerciofromContratacionDto(ContratacionDto contrataciondto) {
		AlarmaComercio respuesta = new AlarmaComercio(contrataciondto.isMovilAcompaniamiento(),contrataciondto.getCantCamaras(),contrataciondto.getCantBotones(),Transferencia.DomiciliofromDomicilioDto(contrataciondto.getDomicilio()));
		return respuesta;
	}
	
	public static AlarmaVivienda AlarmaViviendafromContratacionDto(ContratacionDto contrataciondto) {
		AlarmaVivienda respuesta = new AlarmaVivienda(contrataciondto.isMovilAcompaniamiento(),contrataciondto.getCantCamaras(),contrataciondto.getCantBotones(),Transferencia.DomiciliofromDomicilioDto(contrataciondto.getDomicilio()));
		return respuesta;
	}
	
	public static Contratacion ContratacionfromContratacionDto(ContratacionDto contrataciondto) {
		Contratacion respuesta ;
		if(contrataciondto instanceof AlarmaViviendaDto )
			respuesta=Transferencia.AlarmaViviendafromContratacionDto(contrataciondto);
		else
			respuesta=Transferencia.AlarmaComerciofromContratacionDto(contrataciondto);
		return respuesta;
	}
	
	public static ContratacionDto ContratacionDtofromContratacion(Contratacion contratacion) {
		ContratacionDto respuesta = new ContratacionDto();
		respuesta.setNumId(contratacion.getNumId());
		respuesta.setMovilAcompaniamiento(contratacion.isMovilAcompaniamiento());
		respuesta.setCantCamaras(contratacion.getCantCamaras());
		respuesta.setCantBotones(contratacion.getCantBotones());
		respuesta.setPrecio(contratacion.getPrecio());
		respuesta.setDomicilio(Transferencia.domicilioDtofromDomicilio(contratacion.getDomicilio()));
		return respuesta;
	}
	
	
	//Clientes
	public static ClienteJuridicoDto clienteJuridicoDtofromClienteJuridico(Cliente cliente) {
		int i;
		ClienteJuridico cliente1=(ClienteJuridico) cliente;
		ClienteJuridicoDto respuesta = new ClienteJuridicoDto();
		respuesta.setNombre(cliente1.getNombre());
		respuesta.setDni(cliente1.getDni());
		respuesta.setHistorialfacturas(cliente1.getHistorialFacturas());
		respuesta.setFacturas(cliente1.getFacturas());
		ArrayList<ContratacionDto> contratacionesDto = new ArrayList <ContratacionDto>();
		for(i=0;i<cliente1.getContrataciones().size();i++)
			contratacionesDto.add(Transferencia.ContratacionDtofromContratacion(cliente1.getContrataciones().get(i)));
		respuesta.setContrataciones(contratacionesDto);
		return respuesta;
	}
	
	public static ClienteFisicoDto clienteFisicoDtofromClienteFisico(Cliente cliente) {
		int i;
		ClienteFisico cliente1=(ClienteFisico) cliente;
		ClienteFisicoDto respuesta = new ClienteFisicoDto();
		respuesta.setNombre(cliente1.getNombre());
		respuesta.setDni(cliente1.getDni());
		respuesta.setHistorialfacturas(cliente1.getHistorialFacturas());
		respuesta.setFacturas(cliente1.getFacturas());
		respuesta.setEstado(cliente1.getEstado());
		ArrayList<ContratacionDto> contratacionesDto = new ArrayList <ContratacionDto>();
		for(i=0;i<cliente1.getContrataciones().size();i++)
			contratacionesDto.add(Transferencia.ContratacionDtofromContratacion(cliente1.getContrataciones().get(i)));
		respuesta.setContrataciones(contratacionesDto);
		return respuesta;
	}
		
	
	
	public static ClienteJuridico clienteJuridicofromClienteJuridicoDto(ClienteDto clientedto) {
		int i;
		ClienteJuridicoDto clientedto1=(ClienteJuridicoDto) clientedto;
		ClienteJuridico respuesta = new ClienteJuridico(clientedto1.getNombre(),clientedto1.getDni());
		respuesta.setFacturas(clientedto1.getFacturas());
		respuesta.setHistorialfacturas(clientedto1.getHistorialfacturas());
		ArrayList<Contratacion> contrataciones = new ArrayList <Contratacion>();
		for(i=0;i<clientedto1.getContrataciones().size();i++)
			contrataciones.add(Transferencia.ContratacionfromContratacionDto(clientedto1.getContrataciones().get(i)));
		respuesta.setContrataciones(contrataciones);
		return respuesta;
	}
	

	public static ClienteFisico clienteFisicofromClienteFisicoDto(ClienteDto clientedto) {
		int i;
		ClienteFisicoDto clientedto1=(ClienteFisicoDto) clientedto;
		ClienteFisico respuesta = new ClienteFisico(clientedto1.getNombre(),clientedto1.getDni());
		respuesta.setFacturas(clientedto1.getFacturas());
		respuesta.setHistorialfacturas(clientedto1.getHistorialfacturas());
		respuesta.setEstado(clientedto1.getEstado());
		ArrayList<Contratacion> contrataciones = new ArrayList <Contratacion>();
		for(i=0;i<clientedto1.getContrataciones().size();i++)
			contrataciones.add(Transferencia.ContratacionfromContratacionDto(clientedto1.getContrataciones().get(i)));
		respuesta.setContrataciones(contrataciones);
		return respuesta;
	}
	
	public static Cliente clientefromClienteDto(ClienteDto clientedto) {
		Cliente respuesta;
		if(clientedto instanceof ClienteFisicoDto) {
			respuesta=Transferencia.clienteFisicofromClienteFisicoDto(clientedto);
		}
		else
			respuesta=Transferencia.clienteJuridicofromClienteJuridicoDto(clientedto);
		return respuesta;
	}
	
	
	
	
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
		int i;
		EmpresaDto respuesta = new EmpresaDto();
		respuesta.setNombre(empresa.getNombre());
		ArrayList<ClienteDto> clientesDto = new ArrayList <ClienteDto>();
		for(i=0;i<empresa.getAbonados().size();i++) {
			if(empresa.getAbonados().get(i) instanceof ClienteFisico)
				clientesDto.add(Transferencia.clienteFisicoDtofromClienteFisico(empresa.getAbonados().get(i)));
			else
				clientesDto.add(Transferencia.clienteJuridicoDtofromClienteJuridico(empresa.getAbonados().get(i)));
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
		int i;
		Empresa respuesta = Empresa.getInstancia();
		respuesta.setNombre(empresadto.getNombre());
		ArrayList<Cliente> clientes = new ArrayList <Cliente>();
		for(i=0;i<empresadto.getAbonados().size();i++) {
			clientes.add(Transferencia.clientefromClienteDto(empresadto.getAbonados().get(i)));
		}
		respuesta.setAbonados(clientes);
		
		ArrayList<Tecnico> tecnicos = new ArrayList <Tecnico>();
		for(i=0;i<empresadto.getTecnicos().size();i++) {
			tecnicos.add(Transferencia.tecnicofromTecnicoDto(empresadto.getTecnicos().get(i)));
		}
		respuesta.setTecnicos(tecnicos);
		return respuesta;
	}
	
	
	//Tecnico
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
