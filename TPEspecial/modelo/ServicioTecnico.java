package modelo;

import java.util.ArrayList;
import java.util.Iterator;

//RECURSO COMPARTIDO
public class ServicioTecnico {
	
	
	private ArrayList<Tecnico>tecnicos = new ArrayList<Tecnico>();
	
	
	public void addTecnico(String nombre) {
		tecnicos.add(new Tecnico(nombre));
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
	
	
	public synchronized Tecnico trabajaTecnico() {
		Tecnico aux;
		while(tecnicoDisponible()==null)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		aux=tecnicoDisponible();
		aux.setOcupado(true);
		notifyAll();
		return aux;
	}

	public synchronized void terminaTecnico(Tecnico tecnico) {
		tecnico.setOcupado(false);
		notifyAll();
	}
	
}
