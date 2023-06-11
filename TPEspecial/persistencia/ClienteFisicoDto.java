package persistencia;

import modelo.IPersonaState;

public class ClienteFisicoDto extends ClienteDto {
	private IPersonaState estado=null;
	
	public ClienteFisicoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IPersonaState getEstado() {
		return estado;
	}

	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	}

}
