package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Tecnico;
import negocio.Empresa;

public class EmpresaDto implements Serializable {
	private static int mes = 1;
	private static Empresa instancia = null;
	private String nombre;
	private ArrayList<Cliente> abonados = new ArrayList<Cliente>();
	private ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	public EmpresaDto() {
		super();
	}
	public static int getMes() {
		return mes;
	}
	public static void setMes(int mes) {
		EmpresaDto.mes = mes;
	}
	public static Empresa getInstancia() {
		return instancia;
	}
	public static void setInstancia(Empresa instancia) {
		EmpresaDto.instancia = instancia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cliente> getAbonados() {
		return abonados;
	}
	public void setAbonados(ArrayList<Cliente> abonados) {
		this.abonados = abonados;
	}
	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}
	public void setTecnicos(ArrayList<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}
	
	

}
