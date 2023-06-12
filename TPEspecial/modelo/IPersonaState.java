package modelo;

import controlador.Controlador;
import excepciones.MorosoException;
import excepciones.SinContratacionException;

public interface IPersonaState {
	
	void pagarFactura(IFactura f) throws SinContratacionException;
	void contratarServicio(Contratacion contratacion) throws MorosoException;
	void bajaServicio(Contratacion c) throws SinContratacionException, MorosoException;
	void addObserver(Controlador c);

}
