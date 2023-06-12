package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

//RECURSO COMPARTIDO
@SuppressWarnings("deprecation")
public class ServicioTecnico extends Observable implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Tecnico>tecnicos = new ArrayList<Tecnico>();
	
	
	public synchronized void addTecnico(String nombre) {
		tecnicos.add(new Tecnico(nombre));
		notifyAll();
	}
	
	public Tecnico tecnicoDisponible() {
		Iterator<Tecnico> it = tecnicos.iterator();
		Tecnico aux = null;
		Tecnico aux2 = null;
		while (it.hasNext() && aux == null) {
			aux2 = it.next();
			if (!aux2.isOcupado()) {
				aux = aux2;
			}
		}
		return aux;
	}
	
	
	public synchronized Tecnico trabajaTecnico(Cliente cliente) {
		Tecnico aux;
		while(tecnicoDisponible()==null)
			try {
				this.setChanged();
				this.notifyObservers("El cliente "+ cliente.getNombre()+ " esta a la espera de un tecnico");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		aux=tecnicoDisponible();
		aux.setCliente(cliente);
		aux.setOcupado(true);
		this.setChanged();
		this.notifyObservers("El tecnico "+aux.getNombre()+" empieza a trabajar con el cliente "+ cliente.getNombre());
		notifyAll();
		return aux;
	}

	public synchronized void terminaTecnico(Tecnico tecnico) {
		tecnico.setOcupado(false);
		this.setChanged();
		this.notifyObservers("El tecnico "+tecnico.getNombre()+" terminó de trabajar con el cliente "+ tecnico.getCliente().getNombre());
		tecnico.setCliente(null);
		notifyAll();
	}

	public ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(ArrayList<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}
	
	
}
