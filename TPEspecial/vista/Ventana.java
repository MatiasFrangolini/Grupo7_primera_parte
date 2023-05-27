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
	private JPanel panel_23;
	private JPanel panel_24;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * @wbp.nonvisual location=-30,379
	 */
	private final JPanel panel_26 = new JPanel();
	private JSpinner spinner;
	private JSpinner spinner_1;

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
		empresaPrincipal.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel listaIzq = new JPanel();
		empresaPrincipal.add(listaIzq);
		listaIzq.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		listaIzq.add(list);
		
		JPanel panelMedio = new JPanel();
		empresaPrincipal.add(panelMedio);
		panelMedio.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelAddAbonado = new JPanel();
		panelMedio.add(panelAddAbonado);
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
		panelMedio.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel labelTP = new JLabel("CREAR TECNICOS");
		labelTP.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(labelTP, BorderLayout.CENTER);
		
		JPanel panelMes = new JPanel();
		panelMedio.add(panelMes);
		panelMes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panelMes.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		this.btnAvanzarMes = new JButton("Avanzar mes");
		this.btnAvanzarMes.setBounds(160, 60, 140, 23);
		panel_3.add(this.btnAvanzarMes);
		
		this.textArea = new JTextArea();
		empresa.add(this.textArea, BorderLayout.SOUTH);
		
		JPanel abonados = new JPanel();
		tabbedPane.addTab("Abonados", null, abonados, null);
		abonados.setLayout(new BorderLayout(0, 0));
		
		this.abonadosPrincipal = new JPanel();
		abonados.add(this.abonadosPrincipal, BorderLayout.CENTER);
		this.abonadosPrincipal.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panelListaClientes = new JPanel();
		this.abonadosPrincipal.add(this.panelListaClientes);
		this.panelListaClientes.setLayout(new BorderLayout(0, 0));
		
		JList listaClientes = new JList();
		this.panelListaClientes.add(listaClientes, BorderLayout.CENTER);
		
		this.panelCentralAbonados = new JPanel();
		this.abonadosPrincipal.add(this.panelCentralAbonados);
		this.panelCentralAbonados.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipalCentral = new JPanel();
		this.panelCentralAbonados.add(panelPrincipalCentral, BorderLayout.CENTER);
		panelPrincipalCentral.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panelPrincipalCentral.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAgregarContratacion = new JLabel("Agregar contratacion");
		labelAgregarContratacion.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(labelAgregarContratacion, BorderLayout.NORTH);
		
		JPanel panelCentralAgregar = new JPanel();
		panelCentralAgregar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panel_4.add(panelCentralAgregar, BorderLayout.CENTER);
		panelCentralAgregar.setLayout(new GridLayout(4, 2, 10, 2));
		
		JPanel panel_10 = new JPanel();
		panelCentralAgregar.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Movil acompañamiento");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 0, 125, 29);
		panel_10.add(lblNewLabel_2);
		
		JPanel panelCheckbox = new JPanel();
		panelCentralAgregar.add(panelCheckbox);
		panelCheckbox.setLayout(null);
		
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
		this.spinner.setBounds(48, 5, 30, 20);
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
		this.spinner_1.setBounds(48, 5, 30, 20);
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
		this.textField_2.setBounds(34, 0, 86, 15);
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
		this.textField_3.setBounds(22, 0, 96, 15);
		this.panel_21.add(this.textField_3);
		this.textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panelPrincipalCentral.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_23 = new JPanel();
		panel_22.add(this.panel_23);
		this.panel_23.setLayout(null);
		
		this.btnNewButton = new JButton("Agregar contratacion");
		this.btnNewButton.setBounds(70, 11, 150, 23);
		this.panel_23.add(this.btnNewButton);
		
		this.panel_24 = new JPanel();
		panel_22.add(this.panel_24);
		this.panel_24.setLayout(null);
		
		this.btnNewButton_1 = new JButton("Eliminar contratacion");
		this.btnNewButton_1.setBounds(36, 24, 232, 23);
		this.panel_24.add(this.btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		panelPrincipalCentral.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_25 = new JPanel();
		panel_8.add(panel_25);
		panel_25.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Pagar factura");
		btnNewButton_2.setBounds(78, 52, 129, 23);
		panel_25.add(btnNewButton_2);
		
		JPanel panelContratacionesFacturas = new JPanel();
		this.abonadosPrincipal.add(panelContratacionesFacturas);
		panelContratacionesFacturas.setLayout(new GridLayout(2, 1, 0, 2));
		
		JPanel panelContrataciones = new JPanel();
		panelContrataciones.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		panelContratacionesFacturas.add(panelContrataciones);
		panelContrataciones.setLayout(new BorderLayout(0, 0));
		
		JLabel contrataciones = new JLabel("Contrataciones");
		contrataciones.setForeground(new Color(0, 0, 0));
		contrataciones.setHorizontalAlignment(SwingConstants.CENTER);
		panelContrataciones.add(contrataciones, BorderLayout.NORTH);
		
		JList listaContrataciones = new JList();
		panelContrataciones.add(listaContrataciones, BorderLayout.CENTER);
		
		JPanel panelFacturas = new JPanel();
		panelFacturas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
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
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
