package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import excepciones.ClienteInvalidoException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioNoPerteneceAClienteException;
import excepciones.DomicilioNuloException;
import excepciones.DomicilioYaExisteException;
import excepciones.MorosoException;
import excepciones.SinContratacionException;
import modelo.Cliente;
import modelo.Contratacion;
import modelo.Domicilio;
import modelo.ServicioTecnico;
import negocio.Empresa;
import vista.Ventana;

@SuppressWarnings("deprecation")
public class Controlador implements ActionListener, Observer {
	 private Empresa empresa;
	 private Ventana vista;
	 private ServicioTecnico servicioTecnico;

	public Controlador()
	    {
		this.vista = new Ventana();
		this.empresa = Empresa.getInstancia();
		this.servicioTecnico = empresa.getServiciotecnico();
		this.servicioTecnico.addObserver(this);
		this.vista.setActionListener(this);
	    }
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("Agregar Contratacion")) {
			Contratacion Caux = null;
			try {
				if (vista.isRdbtnVivienda())
					Caux = this.empresa.creaContratacion(this.vista.getCliente(), this.vista.getMovil(), this.vista.getCamaras(), this.vista.getBotones(), new Domicilio(this.vista.getCalle(),this.vista.getAltura()),"Vivienda");
				else
					Caux = this.empresa.creaContratacion(this.vista.getCliente(), this.vista.getMovil(), this.vista.getCamaras(), this.vista.getBotones(), new Domicilio(this.vista.getCalle(),this.vista.getAltura()),"Comercio");
				try {
					try {
						this.empresa.addContratacionACliente(this.vista.getCliente(), Caux);
					} catch (MorosoException e1) {
						this.vista.showExceptionMessage(vista, e1);
					}
					vista.refrescaListaContratacion();
				} catch (DomicilioYaExisteException | DomicilioNoPerteneceAClienteException
						| ClienteInvalidoException e1) {
					vista.showExceptionMessage(vista, e1);
				}
			} catch (DomicilioNuloException | ContratacionInvalidaException e1) {
				vista.showExceptionMessage(vista, e1);
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
				vista.showExceptionMessage(vista, e1);
			}
		}
		else if (comando.equalsIgnoreCase("Agregar cliente juridico")) {
			try {
				this.empresa.creaCliente(this.vista.getNombre(), this.vista.getDNI(), "Juridico");
				this.vista.refrescaListaCliente();
			} catch (ClienteInvalidoException e1) {
				vista.showExceptionMessage(vista, e1);
			}
		}
		else if (comando.equalsIgnoreCase("Agregar tecnico")) {
			this.empresa.addTecnico(this.vista.getNombreTecnico());
			this.vista.setLblCantTecnicos("Cantidad de tecnicos:  "+String.valueOf(this.servicioTecnico.getTecnicos().size()));
		}
		else if (comando.equalsIgnoreCase("Avanzar mes")) {
			this.empresa.cambiarMes(); 
			vista.setLblMesActual("Mes actual:                 "+ String.valueOf(Empresa.getMes()));
		}
		else if (comando.equalsIgnoreCase("Pagar Factura")) {
			try {
				this.vista.getCliente().addObserver(this);
				this.empresa.abonarFactura(this.vista.getFactura(), this.vista.getCliente());
				
			} catch (SinContratacionException e1) {
				this.vista.showExceptionMessage(vista, e1);
			}
			this.vista.refrescaListaFactura();
			this.vista.refrescaListaHistorial();
		}
		else if (comando.equalsIgnoreCase("Solicitar Tecnico")) {
			Cliente c = this.vista.getCliente();
			try {
				c.start();
			} catch  (Exception excepcion) {
				vista.showExceptionMessage(vista, excepcion);
			}
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.vista.writeText((String)arg);
		this.vista.writeText("\n");
	}

}
