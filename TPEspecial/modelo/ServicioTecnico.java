package modelo;

import java.util.ArrayList;
import java.util.Iterator;

//RECURSO COMPARTIDO
public class ServicioTecnico {
	private ArrayList<Tecnico>tecnicos = new ArrayList<Tecnico>();
	
	public synchronized Tecnico tecnicoDisponible() {
		Iterator<Tecnico> it = tecnicos.iterator();
		Tecnico aux = null;
		while (it.hasNext() && aux == null) {
			if (!it.next().isOcupado()) {
				aux = it.next();
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
				// TODO Auto-generated catch block
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
