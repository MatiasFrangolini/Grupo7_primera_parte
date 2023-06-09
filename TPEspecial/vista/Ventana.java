package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Cliente;
import modelo.Contratacion;
import modelo.Factura;
import modelo.IFactura;
import negocio.Empresa;
import javax.swing.JScrollPane;

public class Ventana extends JFrame implements KeyListener, ActionListener, MouseListener, ListSelectionListener, ChangeListener {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;
	private JButton btnAvanzarMes;
	private JButton btnClienteFisico;
	private JButton btnClienteJuridico;
	private JButton btnAgregarContratacion;
	private JButton btnEliminarContratacion;
	private JPanel abonadosPrincipal;
	private JPanel panelListaClientes;
	private JPanel panelCentralAbonados;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_18;
	private JPanel panel_19;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_20;
	private JTextField calletext;
	private JPanel panel_21;
	private JTextField alturatext;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JSpinner spinnercamaras;
	private JSpinner spinnerbotones;
	private JTextField textNombreTecnico;
	private ActionListener actionListener;
	private JButton btnAgregarTecnico;
	private JButton btnSolicitarTecnico;
	private JButton btnPagarFactura;
	protected JList<Cliente> listaClientes;
	private JCheckBox chckbxMovilAcom;
	private JList<IFactura> listaFacturas;
	private JList<Contratacion> listaContrataciones;
	private DefaultListModel<Cliente> listModelClienteEmpresa = new DefaultListModel<Cliente>();
	private DefaultListModel<Cliente> listModelCliente = new DefaultListModel<Cliente>();
	private DefaultListModel<IFactura> listModelFactura = new DefaultListModel<IFactura>();
	private DefaultListModel<IFactura> listModelFacturaHistorial = new DefaultListModel<IFactura>();
	private DefaultListModel<Contratacion> listModelContratacion = new DefaultListModel<Contratacion>();
	private JTabbedPane tabbedPane;
	private JList<Cliente> listaClientesHistorial;
	private JList<IFactura> listaFacturasHistorial;
	private JList<Cliente> listaClientesEmpresa;
	private JLabel lblMesActual;
	
	public void setActionListener(ActionListener actionListener)
	    {
		this.btnAgregarContratacion.addActionListener(actionListener);
		this.btnAvanzarMes.addActionListener(actionListener);
		this.btnClienteFisico.addActionListener(actionListener);
		this.btnEliminarContratacion.addActionListener(actionListener);
		this.btnClienteJuridico.addActionListener(actionListener);
		this.btnAgregarTecnico.addActionListener(actionListener);
		this.btnSolicitarTecnico.addActionListener(actionListener);
		this.btnPagarFactura.addActionListener(actionListener);
		this.actionListener = actionListener;
	    }
	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addChangeListener(this);
		
		JPanel tabEmpresa = new JPanel();
		tabbedPane.addTab("Empresa", null, tabEmpresa, null);
		tabEmpresa.setLayout(new BorderLayout(0, 0));
		
		
		JPanel empresaPrincipal = new JPanel();
		tabEmpresa.add(empresaPrincipal, BorderLayout.CENTER);
		empresaPrincipal.setLayout(new GridLayout(0, 2, 2, 0));
		
		JPanel listaIzq = new JPanel();
		listaIzq.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		empresaPrincipal.add(listaIzq);
		listaIzq.setLayout(new BorderLayout(0, 0));
		
		
		this.listaClientesEmpresa = new JList<Cliente>();
		listaIzq.add(listaClientesEmpresa);
		listaClientesEmpresa.setModel(listModelClienteEmpresa);
		
		JPanel panelDerecho = new JPanel();
		empresaPrincipal.add(panelDerecho);
		panelDerecho.setLayout(new GridLayout(3, 1, 0, 2));
		
		JPanel panelAddAbonado = new JPanel();
		panelAddAbonado.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelDerecho.add(panelAddAbonado);
		panelAddAbonado.setLayout(new BorderLayout(0, 0));
		
		JLabel textoCrearCliente = new JLabel("Crear Nuevo Cliente");
		textoCrearCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panelAddAbonado.add(textoCrearCliente, BorderLayout.NORTH);
		
		JPanel panelDatosCliente = new JPanel();
		panelAddAbonado.add(panelDatosCliente, BorderLayout.CENTER);
		panelDatosCliente.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panelDatosCliente.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelNombre, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panelDatosCliente.add(panel_5);
		panel_5.setLayout(null);
		
		this.textNombre = new JTextField();
		this.textNombre.addKeyListener(this);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setBounds(10, 17, 198, 20);
		panel_5.add(textNombre);
		textNombre.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panelDatosCliente.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel labelDni = new JLabel("Dni:");
		labelDni.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(labelDni, BorderLayout.CENTER);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panelDatosCliente.add(panel_5_1);
		
		this.textDni = new JTextField();
		this.textDni.addKeyListener(this);
		textDni.setHorizontalAlignment(SwingConstants.CENTER);
		textDni.setColumns(10);
		textDni.setBounds(10, 17, 198, 20);
		panel_5_1.add(textDni);
		
		JPanel panelBotones = new JPanel();
		panelAddAbonado.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.btnClienteFisico = new JButton("Agregar Cliente Fisico");
		btnClienteFisico.addMouseListener(this);
		panelBotones.add(btnClienteFisico);
		this.btnClienteFisico.setEnabled(false);
		
		this.btnClienteJuridico = new JButton("Agregar Cliente Juridico");
		btnClienteJuridico.addMouseListener(this);
		panelBotones.add(btnClienteJuridico);
		this.btnClienteJuridico.setEnabled(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelDerecho.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(null);
		panel_2.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel lblNombreTecnico = new JLabel("Nombre: ");
		lblNombreTecnico.setBounds(86, 0, 218, 71);
		panel_17.add(lblNombreTecnico);
		
		JPanel panel_22 = new JPanel();
		panel_2.add(panel_22);
		panel_22.setLayout(null);
		
		textNombreTecnico = new JTextField();
		this.textNombreTecnico.addKeyListener(this);
		textNombreTecnico.setBounds(50, 25, 120, 20);
		panel_22.add(textNombreTecnico);
		textNombreTecnico.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_1.add(panel_16);
		panel_16.setLayout(null);
		
		this.btnAgregarTecnico = new JButton("Agregar Técnico");
		btnAgregarTecnico.setBounds(150, 20, 132, 23);
		panel_16.add(btnAgregarTecnico);
		this.btnAgregarTecnico.setEnabled(false);
		
		JPanel panelMes = new JPanel();
		panelMes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelDerecho.add(panelMes);
		panelMes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panelMes.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		this.btnAvanzarMes = new JButton("Avanzar mes");
		btnAvanzarMes.addMouseListener(this);
		this.btnAvanzarMes.setBounds(150, 50, 140, 23);
		panel_3.add(this.btnAvanzarMes);
		
		this.lblMesActual = new JLabel("Mes actual:              "+ String.valueOf(Empresa.getMes()));
		lblMesActual.setBounds(150, 28, 140, 14);
		panel_3.add(lblMesActual);
		
		this.textArea = new JTextArea();
		textArea.setEnabled(false);
		tabEmpresa.add(this.textArea, BorderLayout.SOUTH);
		
		JPanel tabAbonados = new JPanel();
		tabbedPane.addTab("Abonados", null, tabAbonados, null);
		tabAbonados.setLayout(new BorderLayout(0, 0));
		
		this.abonadosPrincipal = new JPanel();
		tabAbonados.add(this.abonadosPrincipal, BorderLayout.CENTER);
		this.abonadosPrincipal.setLayout(new GridLayout(0, 3, 2, 0));
		
		this.panelListaClientes = new JPanel();
		panelListaClientes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		this.abonadosPrincipal.add(this.panelListaClientes);
		this.panelListaClientes.setLayout(new BorderLayout(0, 0));
		
		this.listaClientes = new JList<Cliente>();
		listaClientes.addListSelectionListener(this);
		this.panelListaClientes.add(listaClientes, BorderLayout.CENTER);
		listaClientes.setModel(listModelCliente);
		
		this.panelCentralAbonados = new JPanel();
		this.abonadosPrincipal.add(this.panelCentralAbonados);
		this.panelCentralAbonados.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipalCentral = new JPanel();
		this.panelCentralAbonados.add(panelPrincipalCentral, BorderLayout.CENTER);
		panelPrincipalCentral.setLayout(new GridLayout(2, 0, 0, 2));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelPrincipalCentral.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAgregarContratacion = new JLabel("Agregar contratacion");
		labelAgregarContratacion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(labelAgregarContratacion, BorderLayout.NORTH);
		
		JPanel panelCentralAgregar = new JPanel();
		panel_4.add(panelCentralAgregar, BorderLayout.CENTER);
		panelCentralAgregar.setLayout(new GridLayout(4, 2, 10, 2));
		
		JPanel panel_10 = new JPanel();
		panelCentralAgregar.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Movil acompañamiento");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_2);
		
		JPanel panelCheckbox = new JPanel();
		panelCentralAgregar.add(panelCheckbox);
		panelCheckbox.setLayout(new BorderLayout(0, 0));
		
		this.chckbxMovilAcom = new JCheckBox("Agregar");
		chckbxMovilAcom.setHorizontalAlignment(SwingConstants.CENTER);
		panelCheckbox.add(chckbxMovilAcom);
		
		JPanel panel_12 = new JPanel();
		panelCentralAgregar.add(panel_12);
		panel_12.setLayout(null);
		
		this.lblNewLabel_3 = new JLabel("Cantidad de camaras");
		this.lblNewLabel_3.setBounds(20, 7, 113, 23);
		panel_12.add(this.lblNewLabel_3);
		
		JPanel panel_13 = new JPanel();
		panelCentralAgregar.add(panel_13);
		panel_13.setLayout(null);
		
		this.spinnercamaras = new JSpinner();
		spinnercamaras.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		this.spinnercamaras.setBounds(45, 10, 45, 20);
		panel_13.add(this.spinnercamaras);
		
		JPanel panel_14 = new JPanel();
		panelCentralAgregar.add(panel_14);
		panel_14.setLayout(null);
		
		this.lblNewLabel_4 = new JLabel("Cantidad de botones");
		this.lblNewLabel_4.setBounds(20, 5, 115, 23);
		panel_14.add(this.lblNewLabel_4);
		
		JPanel panel_15 = new JPanel();
		panelCentralAgregar.add(panel_15);
		panel_15.setLayout(null);
		
		this.spinnerbotones = new JSpinner();
		spinnerbotones.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		this.spinnerbotones.setBounds(45, 10, 45, 20);
		panel_15.add(this.spinnerbotones);
		
		this.panel_18 = new JPanel();
		panelCentralAgregar.add(this.panel_18);
		this.panel_18.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel_5 = new JLabel("Calle");
		this.lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_18.add(this.lblNewLabel_5, BorderLayout.NORTH);
		
		this.panel_20 = new JPanel();
		this.panel_18.add(this.panel_20, BorderLayout.CENTER);
		this.panel_20.setLayout(null);
		
		this.calletext = new JTextField();
		this.calletext.addKeyListener(this);
		this.calletext.setBounds(18, 5, 102, 15);
		this.panel_20.add(this.calletext);
		this.calletext.setColumns(10);
		
		this.panel_19 = new JPanel();
		panelCentralAgregar.add(this.panel_19);
		this.panel_19.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel_6 = new JLabel("Altura");
		this.lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_19.add(this.lblNewLabel_6, BorderLayout.NORTH);
		
		this.panel_21 = new JPanel();
		this.panel_19.add(this.panel_21, BorderLayout.CENTER);
		this.panel_21.setLayout(null);
		
		this.alturatext = new JTextField();
		this.alturatext.addKeyListener(this);
		this.alturatext.setBounds(18, 5, 102, 15);
		this.panel_21.add(this.alturatext);
		this.alturatext.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.SOUTH);
		
		this.btnAgregarContratacion = new JButton("Agregar Contratacion");
		this.btnAgregarContratacion.addMouseListener(this);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		this.btnAgregarContratacion.setEnabled(false);
		panel_7.add(btnAgregarContratacion);
		
		this.btnEliminarContratacion = new JButton("Eliminar Contratacion");
		this.btnEliminarContratacion.addMouseListener(this);
		this.btnEliminarContratacion.setEnabled(false);
		panel_7.add(btnEliminarContratacion);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelPrincipalCentral.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		this.btnPagarFactura = new JButton("Pagar Factura");
		this.btnPagarFactura.addMouseListener(this);
		btnPagarFactura.setBounds(80, 35, 129, 30);
		btnPagarFactura.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_9.add(btnPagarFactura);
		this.btnPagarFactura.setEnabled(false);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		this.btnSolicitarTecnico = new JButton("Solicitar Técnico");
		this.btnSolicitarTecnico.addMouseListener(this);
		btnSolicitarTecnico.setBounds(80, 35, 129, 30);
		btnSolicitarTecnico.setAlignmentX(0.5f);
		panel_11.add(btnSolicitarTecnico);
		
		JPanel panelContratacionesFacturas = new JPanel();
		this.abonadosPrincipal.add(panelContratacionesFacturas);
		panelContratacionesFacturas.setLayout(new GridLayout(2, 1, 0, 2));
		
		JScrollPane scrollPane = new JScrollPane();
		panelContratacionesFacturas.add(scrollPane);
		
		JPanel panelContrataciones = new JPanel();
		scrollPane.setViewportView(panelContrataciones);
		panelContrataciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelContrataciones.setLayout(new BorderLayout(0, 0));
		
		JLabel contrataciones = new JLabel("Contrataciones");
		contrataciones.setForeground(new Color(0, 0, 0));
		contrataciones.setHorizontalAlignment(SwingConstants.CENTER);
		panelContrataciones.add(contrataciones, BorderLayout.NORTH);
		
		this.listaContrataciones = new JList<Contratacion>();
		panelContrataciones.add(listaContrataciones, BorderLayout.CENTER);
		listaContrataciones.addListSelectionListener(this);
		listaContrataciones.setModel(listModelContratacion);
		
		JPanel panelFacturas = new JPanel();
		panelFacturas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelContratacionesFacturas.add(panelFacturas);
		panelFacturas.setLayout(new BorderLayout(0, 0));
		
		JLabel facturas = new JLabel("Facturas");
		facturas.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturas.add(facturas, BorderLayout.NORTH);
		
		this.listaFacturas = new JList<IFactura>();
		panelFacturas.add(listaFacturas, BorderLayout.CENTER);
		listaFacturas.setModel(listModelFactura);
		
		this.textArea_1 = new JTextArea();
		this.textArea_1.setCaretColor(new Color(255, 0, 0));
		tabAbonados.add(this.textArea_1, BorderLayout.SOUTH);
		
		JPanel tabHistorial = new JPanel();
		tabbedPane.addTab("Historial", null, tabHistorial, null);
		tabHistorial.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHistorial = new JPanel();
		tabHistorial.add(panelHistorial);
		panelHistorial.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelClientesHistorial = new JPanel();
		panelClientesHistorial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHistorial.add(panelClientesHistorial);
		panelClientesHistorial.setLayout(new BorderLayout(0, 0));
		
		this.listaClientesHistorial = new JList<Cliente>();
		panelClientesHistorial.add(listaClientesHistorial);
		listaClientesHistorial.setModel(listModelCliente);
		
		JPanel panelFacturasHistorial = new JPanel();
		panelFacturasHistorial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Facturas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHistorial.add(panelFacturasHistorial);
		panelFacturasHistorial.setLayout(new BorderLayout(0, 0));
		
		this.listaFacturasHistorial = new JList<IFactura>();
		listaFacturasHistorial.setModel(listModelFacturaHistorial);
		panelFacturasHistorial.add(listaFacturasHistorial);
		this.setVisible(true);
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	
	
	private boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	public void keyReleased(KeyEvent e) {
		String calle=null;
		String nombre=null;
		String DNI=null;
		String nombreTecnico=null;
		Cliente cliente = null;
		int altura = -1;
			calle = this.calletext.getText();
			if (isInteger(this.alturatext.getText())) {
				altura = Integer.parseInt(this.alturatext.getText());
			}
			nombre = this.textNombre.getText();
			DNI = this.textDni.getText();
			cliente = this.getCliente();
			boolean condicionagregarcontratacion = calle != null && !(calle.equalsIgnoreCase("")) && altura>0 && cliente != null;
			this.btnAgregarContratacion.setEnabled(condicionagregarcontratacion);	
			boolean condicionagregarcliente = nombre != null && !(nombre.equalsIgnoreCase("")) && DNI != null && !(DNI.equalsIgnoreCase(""));
			this.btnClienteFisico.setEnabled(condicionagregarcliente);
			this.btnClienteJuridico.setEnabled(condicionagregarcliente);
			nombreTecnico = this.textNombreTecnico.getText();
			boolean condicionagregartecnico = nombreTecnico != null && !(nombreTecnico.equalsIgnoreCase(""));
			this.btnAgregarTecnico.setEnabled(condicionagregartecnico);
	}
	
	public void keyTyped(KeyEvent e) {
	}

	public Cliente getCliente() {
		return (Cliente) this.listaClientes.getSelectedValue();
	}

	public String getNombre() {
		return this.textNombre.getText();
	}
	
	public String getDNI() {
		return this.textDni.getText();
	}
	
	public String getNombreTecnico() {
		return this.textNombreTecnico.getText();
	}
	
	public boolean getMovil() {
		return this.chckbxMovilAcom.isSelected();
	}
	
	public int getCamaras() {
		return this.spinnercamaras.getComponentCount();
	}
	
	public int getBotones() {
		return this.spinnerbotones.getComponentCount();
	}
	
	public String getCalle() {
		return this.calletext.getText();
	}
	
	public int getAltura() {
		int aux;
		aux = (int) Integer.parseInt(this.alturatext.getText());
		return aux;
	}
	
	public Contratacion getContratacion() {
		return (Contratacion) this.listaContrataciones.getSelectedValue();
	}
	
	public Factura getFactura() {
		return (Factura) this.listaFacturas.getSelectedValue();
	}
	
	public void setLblMesActual(String string) {
		this.lblMesActual.setText("Mes actual:              "+ String.valueOf(Empresa.getMes()));
	}
	
	public void actionPerformed(ActionEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		JButton boton = (JButton) e.getSource();
		String comando = null;
		comando = boton.getActionCommand();
		ActionEvent evento = new ActionEvent(e.getSource(),0,comando);
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	public void refrescaListaCliente() {
		Cliente cliente = null;
		this.listModelCliente.clear();
		this.listModelClienteEmpresa.clear();
		Iterator<Cliente> it = Empresa.getInstancia().getAbonados().iterator();
		while (it.hasNext()) {
			cliente = it.next();
			this.listModelCliente.addElement(cliente);
			this.listModelClienteEmpresa.addElement(cliente);
		}
		this.repaint();
    }
	
	public void refrescaListaContratacion() {
		this.listModelContratacion.clear();
		Cliente c = this.getCliente();
		if (c != null && c.getContrataciones() != null) {
			Iterator<Contratacion> it = c.getContrataciones().iterator();
			while (it.hasNext())
				this.listModelContratacion.addElement(it.next());
			this.repaint();
		}
	}
	
	public void refrescaListaFactura() {
		this.listModelFactura.clear();
		Cliente c = this.getCliente();
		if (c != null && c.getFacturas() != null) {
			Iterator<IFactura> it = c.getFacturas().iterator();
			while (it.hasNext())
				this.listModelFactura.addElement(it.next());
			this.repaint();
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == this.listaContrataciones) {
			Contratacion cont = null;
			cont = this.getContratacion(); 
			boolean cond = cont != null;
			this.btnEliminarContratacion.setEnabled(cond);
		} else {
			this.refrescaListaContratacion();
			this.refrescaListaFactura();
		}
		
		
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		int index = tabbedPane.getSelectedIndex();
		
		if (index == 0) {
			if (listaClientes != null)
				this.listaClientes.clearSelection();
			if (listaContrataciones != null)
				this.listaContrataciones.clearSelection();
			if (listaFacturas != null)
				this.listaFacturas.clearSelection();
			if (listaClientesHistorial != null)
				this.listaClientesHistorial.clearSelection();
			if (listaFacturasHistorial != null)
				this.listaFacturasHistorial.clearSelection();
		} else if (index == 1) {
			if (listaClientesEmpresa != null)
				this.listaClientesEmpresa.clearSelection();
			if (listaClientesHistorial != null)
				this.listaClientesHistorial.clearSelection();
			if (listaFacturasHistorial != null)
				this.listaFacturasHistorial.clearSelection();
		} else {
			if (listaClientes != null)
				this.listaClientes.clearSelection();
			if (listaContrataciones != null)
				this.listaContrataciones.clearSelection();
			if (listaFacturas != null)
				this.listaFacturas.clearSelection();
		}
		
	}
	
	
	
	
	
}
	
	
