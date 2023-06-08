package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.Empresa;
import vista.Ventana;

public class Controlador implements ActionListener {
	 private Empresa empresa;
	 private Ventana vista;

	public Controlador()
	    {
		this.vista = new Ventana();
		this.empresa = Empresa.getInstancia();
		this.vista.setActionListener(this);
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Agregar Contratacion")) {
			
		}
		
	}

}
