package modelo;

public interface IPersonaState {
	
	void pagarFactura(IFactura f);
	void contratarServicio(ClienteFisico abonado);
	void bajaServicio(ClienteFisico abonado, Contratacion c);

}
