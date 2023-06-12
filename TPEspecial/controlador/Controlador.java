package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import excepciones.ClienteInvalidoException;
import excepciones.ContratacionInvalidaException;
import excepciones.DomicilioNoPerteneceAClienteException;
import excepciones.DomicilioNuloException;
import excepciones.DomicilioYaExisteException;
import excepciones.FacturaInvalidaException;
import excepciones.MorosoException;
import excepciones.SinContratacionException;
import modelo.Cliente;
import modelo.Contratacion;
import modelo.Domicilio;
import modelo.ServicioTecnico;
import negocio.Empresa;
import persistencia.*;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.Transferencia;
import vista.Ventana;

@SuppressWarnings("deprecation")
public class Controlador implements WindowListener, ActionListener, Observer {
	 private Empresa empresa;
	 private Ventana vista;
	 private ServicioTecnico servicioTecnico;
	 private IPersistencia persistenciaBIN;

	public Controlador()
	    {
		this.vista = new Ventana();
		this.empresa = Empresa.getInstancia();
		this.servicioTecnico = empresa.getServiciotecnico();
		this.servicioTecnico.addObserver(this);
		this.vista.setActionListener(this);
		this.vista.addWindowListener(this);
		this.persistenciaBIN = new PersistenciaBIN();
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
			this.vista.setLblCantTecnicos("Cantidad de tecnicos:  "+String.valueOf(this.empresa.getServiciotecnico().getTecnicos().size()));
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
				Thread t = new Thread(c);
				t.start();
			} catch  (Exception excepcion) {
				vista.showExceptionMessage(vista, excepcion);
			}
		} 
		else if (comando.equalsIgnoreCase("Aplicar promocion")) {
			if (this.vista.isRdbtnPromoDorada()) {
				this.vista.getContratacion().promoDorada();
			} else if (this.vista.isRdbtnPromoPlatino()) {
				this.vista.getContratacion().promoPlatino();
			}
			this.vista.refrescaListaContratacion();
		}
		else if (comando.equalsIgnoreCase("Clonar Factura")) {
			try {
				this.vista.getCliente().addFactura(this.empresa.clonarFactura(this.vista.getFactura()));
			} catch (CloneNotSupportedException | FacturaInvalidaException e1) {
				this.vista.showExceptionMessage(vista, e1);
			}
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.vista.writeText((String)arg);
		this.vista.writeText("\n");
	}



	@Override
	public void windowOpened(WindowEvent e) {
		try
        {
            persistenciaBIN.abrirInput("Empresa.dat");
            System.out.println("Archivo abierto");
            EmpresaDto edto=(EmpresaDto) persistenciaBIN.leer();
            this.empresa = Transferencia.empresafromEmpresaDto(edto);
 
            System.out.println("Empresa recuperada");
            persistenciaBIN.cerrarInput();
            System.out.println("Archivo cerrado");
            this.vista.refrescaListaCliente();
            this.vista.refrescaListaContratacion();
            this.vista.refrescaListaFactura();
            this.vista.refrescaListaHistorial();
            this.vista.setLblCantTecnicos("Cantidad de tecnicos:  "+String.valueOf(this.empresa.getServiciotecnico().getTecnicos().size()));
        } catch (IOException e1)
        {
            this.vista.showExceptionMessage(vista, e1);
        } catch (ClassNotFoundException e1)
        {
            this.vista.showExceptionMessage(vista, e1);
        }
	}



	@Override
	public void windowClosing(WindowEvent e) {	
		try {
        persistenciaBIN.abrirOutput("Empresa.dat");
        System.out.println("Crea archivo escritura");
        EmpresaDto edto=Transferencia.empresaDtofromEmpresa(empresa);
        persistenciaBIN.escribir(edto);
        System.out.println("Empresa grabada exitosamente");
        persistenciaBIN.cerrarOutput();
        System.out.println("Archivo cerrado");
    } catch (IOException e1)
    {
        // TODO Auto-generated catch block
        System.out.println(e1.getLocalizedMessage());
    }
		
	}



	@Override
	public void windowClosed(WindowEvent e) {
		try {
            persistenciaBIN.abrirOutput("Empresa.dat");
            System.out.println("Crea archivo escritura");
            EmpresaDto edto=Transferencia.empresaDtofromEmpresa(empresa);
            persistenciaBIN.escribir(edto);
            System.out.println("Empresa grabada exitosamente");
            persistenciaBIN.cerrarOutput();
            System.out.println("Archivo cerrado");
        } catch (IOException e1)
        {
            // TODO Auto-generated catch block
            System.out.println(e1.getLocalizedMessage());
        }
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
