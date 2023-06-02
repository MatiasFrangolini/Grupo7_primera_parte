package persistencia;

import modelo.IPersonaState;

public class ClienteFisicoDto extends ClienteDto {
	private IPersonaState estado;

	public ClienteFisicoDto() {
		super();
	}

	public IPersonaState getEstado() {
		return estado;
	}

	public void setEstado(IPersonaState estado) {
		this.estado = estado;
	} 
	
	
}
