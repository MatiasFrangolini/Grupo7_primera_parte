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

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;

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
		
		JLabel labelTP = new JLabel("Trabajo Práctico Grupo 7");
		labelTP.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(labelTP, BorderLayout.CENTER);
		
		JPanel panelMes = new JPanel();
		panelMedio.add(panelMes);
		
		JPanel abonados = new JPanel();
		tabbedPane.addTab("Abonados", null, abonados, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
