package modelo;

public interface IFactura extends Cloneable{

	double getPrecioTotal();
	Object clone() throws CloneNotSupportedException;
	
}
