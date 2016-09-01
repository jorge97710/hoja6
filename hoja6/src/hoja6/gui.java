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
	public boolean opcion =false, opcion1 = false, opcion2 = false;
	static Logica milogica = new Logica();
	private JButton btnEnviar,btnMostrarResultados;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("Java");
	private JCheckBox chckbxWeb = new JCheckBox("Web");
	private JCheckBox chckbxMovil = new JCheckBox("Movil");
	private Set<Desarrollador> miSet;
	private int id=0;

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
		setfactory Creasets = fabricador.set();
		miSet = Creasets.crearSet(tipo);
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
		
		//Agregar listeners
		btnEnviar.addActionListener(new ManejadorEventos());
		btnMostrarResultados.addActionListener(new ManejadorEventos());
		chckbxJava.addActionListener(new ManejadorEventos());
		chckbxWeb.addActionListener(new ManejadorEventos());
		chckbxMovil.addActionListener(new ManejadorEventos());
	}

	private class ManejadorEventos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnEnviar) {

				if (chckbxJava.isSelected() ) {
					opcion = true;
				} else {
					opcion = false;

				}
				if (chckbxWeb.isSelected() ) {
					opcion1 = true;

				} else {
					opcion1 =  false;

				}
				if (chckbxMovil.isSelected() ) {
					opcion2 = true;

				} else {
					opcion2 =  false;

				}
		
				id++;
				miSet.add(new Desarrollador(txtNombrea.getText(),opcion1,opcion,opcion2,id));
				
			}
		if (e.getSource() == btnMostrarResultados ) {
			System.out.println("Interseccion de conjuntos\n Desarrolladores con experiencia en 3");
			for (Desarrollador der: miSet){
				if (der.isJava()==true && der.isCel()==true && der.isWeb()==true){
					System.out.println(der.getNombre());
				}
			}
			System.out.println("Saben Java pero no saben web");
			for (Desarrollador der: miSet){
				if (der.isJava()==true && der.isWeb()==false){
					System.out.println(der.getNombre());
				}
			}
			System.out.println("No saben java pero pueden tener de lo otro");
			for (Desarrollador der: miSet){
				if (der.isJava()==false){
					System.out.println(der.getNombre());
				}
			}
			
		}
		}
	}
}