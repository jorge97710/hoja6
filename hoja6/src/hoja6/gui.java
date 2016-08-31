package hoja6;

import java.awt.EventQueue;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class gui {
	static String tipo = "", tipoL = "", tipoS = "";
	public String opcion = "", opcion1 = "", opcion2 = "";
	static Logica milogica = new Logica();
	private JButton btnEnviar;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("Java");
	private JCheckBox chckbxWeb = new JCheckBox("Web");
	private JCheckBox chckbxMovil = new JCheckBox("Movil");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"Por favor ingrese el ADT que desee utilizar\n"
						+ "Para HashSet enlazadas ingrese ''HS''\n"
						+ "Para TreeSet ingrese ''TS''\n"
						+ "Para LinkedHashSet ingrese ''LHS''\n",
				"Datos necesarios", JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el tipo: ");
		milogica.defensiva(tipo);

		gui window = new gui();
		window.frame.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 308, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 23, 46, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblAmbientes = new JLabel("Ambientes de desarrollo");
		lblAmbientes.setBounds(164, 23, 134, 14);
		frame.getContentPane().add(lblAmbientes);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnviar.setBounds(164, 162, 86, 35);
		frame.getContentPane().add(btnEnviar);

		JButton btnMostrarResultados = new JButton("Mostrar Resultados");
		btnMostrarResultados.setBounds(10, 162, 146, 35);
		frame.getContentPane().add(btnMostrarResultados);

		JCheckBox chckbxJava = new JCheckBox("Java");
		chckbxJava.setBounds(164, 44, 108, 35);
		frame.getContentPane().add(chckbxJava);

		JCheckBox chckbxWeb = new JCheckBox("Web");
		chckbxWeb.setBounds(164, 82, 108, 35);
		frame.getContentPane().add(chckbxWeb);

		JCheckBox chckbxMovil = new JCheckBox("Movil");
		chckbxMovil.setBounds(164, 120, 108, 35);
		frame.getContentPane().add(chckbxMovil);

		txtNombrea = new JTextField();
		txtNombrea.setBounds(10, 48, 134, 20);
		frame.getContentPane().add(txtNombrea);
		txtNombrea.setColumns(10);
		btnEnviar.addActionListener(new ManejadorEventos());
	}

	private class ManejadorEventos implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnEnviar) {

				if (e.getSource() == chckbxJava) {
					opcion = "si";
				} else {
					opcion = "no";

				}
				if (e.getSource() == chckbxWeb) {
					opcion1 = "si";

				} else {
					opcion1 = "no";

				}
				if (e.getSource() == chckbxMovil) {
					opcion2 = "si";

				} else {
					opcion2 = "no";

				}
				setfactory Creasets = fabricador.set();
				Set miSet = Creasets.crearSet(tipo);
				miSet.add(txtNombrea.getText());
				miSet.add(opcion);
				miSet.add(opcion1);
				miSet.add(opcion2);

			}

		}
	}
}
