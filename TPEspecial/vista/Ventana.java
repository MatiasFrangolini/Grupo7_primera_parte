package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;
	private JButton btnAvanzarMes;
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
	private JTextField textField_2;
	private JPanel panel_21;
	private JTextField textField_3;
	private JTextArea textArea;
	private JTextArea textArea_1;
	/**
	 * @wbp.nonvisual location=-30,379
	 */
	private final JPanel panel_26 = new JPanel();
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel empresa = new JPanel();
		tabbedPane.addTab("Empresa", null, empresa, null);
		empresa.setLayout(new BorderLayout(0, 0));
		
		JPanel empresaPrincipal = new JPanel();
		empresa.add(empresaPrincipal, BorderLayout.CENTER);
		empresaPrincipal.setLayout(new GridLayout(0, 2, 2, 0));
		
		JPanel listaIzq = new JPanel();
		listaIzq.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		empresaPrincipal.add(listaIzq);
		listaIzq.setLayout(new BorderLayout(0, 0));
		
		JList listaClientesEmpresa = new JList();
		listaIzq.add(listaClientesEmpresa);
		
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
		
		textNombre = new JTextField();
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
		
		textDni = new JTextField();
		textDni.setHorizontalAlignment(SwingConstants.CENTER);
		textDni.setColumns(10);
		textDni.setBounds(10, 17, 198, 20);
		panel_5_1.add(textDni);
		
		JPanel panelBotones = new JPanel();
		panelAddAbonado.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnClienteFisico = new JButton("Agregar Cliente Fisico");
		panelBotones.add(btnClienteFisico);
		
		JButton btnClienteJuridico = new JButton("Agregar Cliente Juridico");
		panelBotones.add(btnClienteJuridico);
		
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
		
		textField = new JTextField();
		textField.setBounds(50, 25, 120, 20);
		panel_22.add(textField);
		textField.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_1.add(panel_16);
		panel_16.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar Técnico");
		btnNewButton.setBounds(150, 20, 132, 23);
		panel_16.add(btnNewButton);
		
		JPanel panelMes = new JPanel();
		panelMes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelDerecho.add(panelMes);
		panelMes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panelMes.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		this.btnAvanzarMes = new JButton("Avanzar mes");
		this.btnAvanzarMes.setBounds(150, 50, 140, 23);
		panel_3.add(this.btnAvanzarMes);
		
		this.textArea = new JTextArea();
		textArea.setEnabled(false);
		empresa.add(this.textArea, BorderLayout.SOUTH);
		
		JPanel abonados = new JPanel();
		tabbedPane.addTab("Abonados", null, abonados, null);
		abonados.setLayout(new BorderLayout(0, 0));
		
		this.abonadosPrincipal = new JPanel();
		abonados.add(this.abonadosPrincipal, BorderLayout.CENTER);
		this.abonadosPrincipal.setLayout(new GridLayout(0, 3, 2, 0));
		
		this.panelListaClientes = new JPanel();
		panelListaClientes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		this.abonadosPrincipal.add(this.panelListaClientes);
		this.panelListaClientes.setLayout(new BorderLayout(0, 0));
		
		JList listaClientes = new JList();
		this.panelListaClientes.add(listaClientes, BorderLayout.CENTER);
		
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
		
		JCheckBox chckbxMovilAcom = new JCheckBox("Agregar");
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
		
		this.spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		this.spinner.setBounds(45, 10, 45, 20);
		panel_13.add(this.spinner);
		
		JPanel panel_14 = new JPanel();
		panelCentralAgregar.add(panel_14);
		panel_14.setLayout(null);
		
		this.lblNewLabel_4 = new JLabel("Cantidad de botones");
		this.lblNewLabel_4.setBounds(20, 5, 115, 23);
		panel_14.add(this.lblNewLabel_4);
		
		JPanel panel_15 = new JPanel();
		panelCentralAgregar.add(panel_15);
		panel_15.setLayout(null);
		
		this.spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		this.spinner_1.setBounds(45, 10, 45, 20);
		panel_15.add(this.spinner_1);
		
		this.panel_18 = new JPanel();
		panelCentralAgregar.add(this.panel_18);
		this.panel_18.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel_5 = new JLabel("Calle");
		this.lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_18.add(this.lblNewLabel_5, BorderLayout.NORTH);
		
		this.panel_20 = new JPanel();
		this.panel_18.add(this.panel_20, BorderLayout.CENTER);
		this.panel_20.setLayout(null);
		
		this.textField_2 = new JTextField();
		this.textField_2.setBounds(18, 5, 102, 15);
		this.panel_20.add(this.textField_2);
		this.textField_2.setColumns(10);
		
		this.panel_19 = new JPanel();
		panelCentralAgregar.add(this.panel_19);
		this.panel_19.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel_6 = new JLabel("Altura");
		this.lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_19.add(this.lblNewLabel_6, BorderLayout.NORTH);
		
		this.panel_21 = new JPanel();
		this.panel_19.add(this.panel_21, BorderLayout.CENTER);
		this.panel_21.setLayout(null);
		
		this.textField_3 = new JTextField();
		this.textField_3.setBounds(18, 5, 102, 15);
		this.panel_21.add(this.textField_3);
		this.textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAgregarContratacion = new JButton("Agregar Contratacion");
		panel_7.add(btnAgregarContratacion);
		
		JButton btnEliminarContratacion = new JButton("Eliminar Contratacion");
		panel_7.add(btnEliminarContratacion);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelPrincipalCentral.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnPagarFactura = new JButton("Pagar Factura");
		btnPagarFactura.setBounds(80, 35, 129, 30);
		btnPagarFactura.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_9.add(btnPagarFactura);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnSolicitarTecnico = new JButton("Solicitar Técnico");
		btnSolicitarTecnico.setBounds(80, 35, 129, 30);
		btnSolicitarTecnico.setAlignmentX(0.5f);
		panel_11.add(btnSolicitarTecnico);
		
		JPanel panelContratacionesFacturas = new JPanel();
		this.abonadosPrincipal.add(panelContratacionesFacturas);
		panelContratacionesFacturas.setLayout(new GridLayout(2, 1, 0, 2));
		
		JPanel panelContrataciones = new JPanel();
		panelContrataciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelContratacionesFacturas.add(panelContrataciones);
		panelContrataciones.setLayout(new BorderLayout(0, 0));
		
		JLabel contrataciones = new JLabel("Contrataciones");
		contrataciones.setForeground(new Color(0, 0, 0));
		contrataciones.setHorizontalAlignment(SwingConstants.CENTER);
		panelContrataciones.add(contrataciones, BorderLayout.NORTH);
		
		JList listaContrataciones = new JList();
		panelContrataciones.add(listaContrataciones, BorderLayout.CENTER);
		
		JPanel panelFacturas = new JPanel();
		panelFacturas.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelContratacionesFacturas.add(panelFacturas);
		panelFacturas.setLayout(new BorderLayout(0, 0));
		
		JLabel facturas = new JLabel("Facturas");
		facturas.setHorizontalAlignment(SwingConstants.CENTER);
		panelFacturas.add(facturas, BorderLayout.NORTH);
		
		JList listaFacturas = new JList();
		panelFacturas.add(listaFacturas, BorderLayout.CENTER);
		
		this.textArea_1 = new JTextArea();
		this.textArea_1.setCaretColor(new Color(255, 0, 0));
		abonados.add(this.textArea_1, BorderLayout.SOUTH);
		
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
		
		JList listaClientesHistorial = new JList();
		panelClientesHistorial.add(listaClientesHistorial);
		
		JPanel panelFacturasHistorial = new JPanel();
		panelFacturasHistorial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Facturas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHistorial.add(panelFacturasHistorial);
		panelFacturasHistorial.setLayout(new BorderLayout(0, 0));
		
		JList listaFacturasHistorial = new JList();
		panelFacturasHistorial.add(listaFacturasHistorial);
	}
}
