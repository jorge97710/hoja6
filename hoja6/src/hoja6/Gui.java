package hoja6;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
/**
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Gui {
	/*Atributos*/
	static String tipo = "";
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	static Logica milogica = new Logica();
	private JButton btnEnviar, btnMostrarResultados;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("Java");
	private JCheckBox chckbxWeb = new JCheckBox("Web");
	private JCheckBox chckbxMovil = new JCheckBox("Movil");
	private int id = 0;
	

	/**
	 * Correr el programa 
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
		milogica.listo(tipo);
		Gui window = new Gui();
		window.frame.setVisible(true);

	}

	/**
	 * Crear la aplicacion
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Inicializar componentes graficos
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 361, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 23, 46, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblAmbientes = new JLabel("Ambientes de desarrollo");
		lblAmbientes.setBounds(164, 23, 143, 14);
		frame.getContentPane().add(lblAmbientes);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(164, 162, 86, 35);
		frame.getContentPane().add(btnEnviar);

		btnMostrarResultados = new JButton("Mostrar Resultados");
		btnMostrarResultados.setBounds(10, 162, 146, 35);
		frame.getContentPane().add(btnMostrarResultados);

		chckbxJava = new JCheckBox("Java");
		chckbxJava.setBounds(164, 44, 108, 35);
		frame.getContentPane().add(chckbxJava);

		chckbxWeb = new JCheckBox("Web");
		chckbxWeb.setBounds(164, 82, 108, 35);
		frame.getContentPane().add(chckbxWeb);

		chckbxMovil = new JCheckBox("Movil");
		chckbxMovil.setBounds(164, 120, 108, 35);
		frame.getContentPane().add(chckbxMovil);

		txtNombrea = new JTextField();
		txtNombrea.setBounds(10, 48, 134, 20);
		frame.getContentPane().add(txtNombrea);
		txtNombrea.setColumns(10);

		// Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
		btnMostrarResultados.addActionListener(new ManejadorEventos());
		chckbxJava.addActionListener(new ManejadorEventos());
		chckbxWeb.addActionListener(new ManejadorEventos());
		chckbxMovil.addActionListener(new ManejadorEventos());
	}
	//Inner class para manejar eventos
	private class ManejadorEventos implements ActionListener {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//Para enviar datos, y asignar ambientes
			if (e.getSource() == btnEnviar) {

				if (chckbxJava.isSelected()) {
					opcion = true;
				} else {
					opcion = false;

				}
				if (chckbxWeb.isSelected()) {
					opcion1 = true;

				} else {
					opcion1 = false;

				}
				if (chckbxMovil.isSelected()) {
					opcion2 = true;

				} else {
					opcion2 = false;

				}
				//Anadir elementos a coleccion
				id++;
				milogica.anadir(txtNombrea.getText(), opcion1,
						opcion, opcion2, id);

			}
			//Desplegar resultados
			if (e.getSource() == btnMostrarResultados) {
				milogica.desplegar();
			}
		}
	}

	
}