package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Tecnico;

public class ServicioTecnicoDto implements Serializable{
	private ArrayList<TecnicoDto>tecnicos = new ArrayList<TecnicoDto>();

	
	
	public ServicioTecnicoDto() {
		super();
	}

	public ArrayList<TecnicoDto> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(ArrayList<TecnicoDto> tecnicos) {
		this.tecnicos = tecnicos;
	}
	
	
}
