package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import excepciones.ClienteInvalidoException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioNoPerteneceAClienteException;
import excepciones.DomicilioNuloException;
import excepciones.DomicilioYaExisteException;
import modelo.Cliente;
import modelo.Contratacion;
import modelo.Domicilio;
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
			Contratacion Caux = null;
			try {
				Caux = this.empresa.creaContratacion(this.vista.getCliente(), this.vista.getMovil(), this.vista.getCamaras(), this.vista.getBotones(), new Domicilio(this.vista.getCalle(),this.vista.getAltura()),"Vivienda");
				try {
					this.empresa.addContratacionACliente(this.vista.getCliente(), Caux);
					vista.refrescaListaContratacion();
				} catch (DomicilioYaExisteException | DomicilioNoPerteneceAClienteException
						| ClienteInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (DomicilioNuloException | ContratacionInvalidaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (comando.equalsIgnoreCase("Eliminar Contratacion")) {
			Contratacion ContAux = vista.getContratacion();
			Cliente ClientAux = vista.getCliente();
			this.empresa.removeContratacionCliente(ClientAux, ContAux);
			this.vista.refrescaListaContratacion();
		}
		else if (comando.equalsIgnoreCase("Agregar cliente fisico")) {
			try {
				this.empresa.creaCliente(this.vista.getNombre(), this.vista.getDNI(), "Fisico");
				this.vista.refrescaListaCliente();
			} catch (ClienteInvalidoException e1) {
				e1.printStackTrace();
			}
		}
		else if (comando.equalsIgnoreCase("Agregar cliente juridico")) {
			try {
				this.empresa.creaCliente(this.vista.getNombre(), this.vista.getDNI(), "Juridico");
				this.vista.refrescaListaCliente();
			} catch (ClienteInvalidoException e1) {
				e1.printStackTrace();
			}
		}
		else if (comando.equalsIgnoreCase("Agregar tecnico")) {
			//NO ESTOY SEGURO SI HAY QUE CREAR UN THREAD O QUE HACER YA CREE LA FUNCION .GETNOMBRETECNICO
		}
		else if (comando.equalsIgnoreCase("Avanzar mes")) {
			this.empresa.cambiarMes();
			vista.setLblMesActual("Mes actual:              "+ String.valueOf(Empresa.getMes()));
		}
		else if (comando.equalsIgnoreCase("Pagar Factura")) {
			//HAY QUE HACER UN METODO QUE ELIMINE UNA FACTURA Y LA MANDE LA LISTA DE HISTORIAL FACTURAS (PENSE QUE YA ESTABA)
		}
		else if (comando.equalsIgnoreCase("Solicitar Tecnico")) {
			//SE ACTIVA EL RECURSO COMPARTIDO
		}
	}

}
