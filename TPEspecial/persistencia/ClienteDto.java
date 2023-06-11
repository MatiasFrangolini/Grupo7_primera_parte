package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Contratacion;
import modelo.IFactura;
import modelo.IPersonaState;

public class ClienteDto implements Serializable{
	protected ArrayList<ContratacionDto> contrataciones = new ArrayList<ContratacionDto>(); //Relacion de composicion
	protected ArrayList<IFactura> facturas = new ArrayList<IFactura>();
	protected ArrayList<IFactura> historialfacturas = new ArrayList<IFactura>();
	private String nombre;
	private String dni;
	//private IPersonaState estado=null;
	
	public ClienteDto() {
		super();
	}

	public ArrayList<ContratacionDto> getContrataciones() {
		return contrataciones;
	}

	public void setContrataciones(ArrayList<ContratacionDto> contrataciones) {
		this.contrataciones = contrataciones;
	}

	public ArrayList<IFactura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<IFactura> facturas) {
		this.facturas = facturas;
	}

	public ArrayList<IFactura> getHistorialfacturas() {
		return historialfacturas;
	}

	public void setHistorialfacturas(ArrayList<IFactura> historialfacturas) {
		this.historialfacturas = historialfacturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	/*public IPersonaState getEstado() {
		return estado;
	}

	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	}*/
	
	

}
