package modelo;

public interface IPersonaState {
	void pagarFactura();
	void contratarServicio(Contratacion contratacion);
	void bajaServicio(Contratacion contratacion);
}
