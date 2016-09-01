package hoja6;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;

public class gui {
	static String tipo = "", tipoL = "", tipoS = "";
	public boolean opcion = false, opcion1 = false, opcion2 = false;
	static Logica milogica = new Logica();
	private JButton btnEnviar, btnMostrarResultados;
	private JFrame frame;
	private JTextField txtNombrea;
	private JCheckBox chckbxJava = new JCheckBox("Java");
	private JCheckBox chckbxWeb = new JCheckBox("Web");
	private JCheckBox chckbxMovil = new JCheckBox("Movil");
	private Set<Desarrollador> miSet;
	private int id = 0, contajava = 0, contaweb = 0, contacel = 0,
			contaweb1 = 0, contajavayweb = 0;
	private JTextArea textarea;
	private String despliegue = "";
	private JTextArea textArea = new JTextArea();
	private final static String newline = "\n", punto = ">";

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
	// ---------------------------------------------------------------------------
	// Metodo constructor

	// ____________________________________________________________________________

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

	private class ManejadorEventos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

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

				id++;
				miSet.add(new Desarrollador(txtNombrea.getText(), opcion1,
						opcion, opcion2, id));

			}
			if (e.getSource() == btnMostrarResultados) {
				try {
					Despliegue dialog = new Despliegue();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.textArea.append("saben los 3:" + newline);
					// System.out
					// .println("Interseccion de conjuntos, Desarrolladores con experiencia en 3");
					for (Desarrollador der : miSet) {
						if (der.isJava() == true && der.isCel() == true
								&& der.isWeb() == true) {
							// System.out.println(der.getNombre());
							dialog.textArea.append(punto + der.getNombre()
									+ newline);
						}
					}

					// System.out.println("Saben Java pero no saben web");
					dialog.textArea.append("saben java pero no web:" + newline);
					// System.out
					for (Desarrollador der : miSet) {
						if (der.isJava() == true && der.isWeb() == false) {
							// System.out.println(der.getNombre());
							dialog.textArea.append(punto + der.getNombre()
									+ newline);

						}
					}
					// System.out.println("Saben web y celular pero no java");
					dialog.textArea.append("saben web y celular pero no java: "
							+ newline);

					for (Desarrollador der : miSet) {
						if (der.isJava() == false
								&& (der.isCel() == true && der.isWeb() == true)) {
							// System.out.println(der.getNombre());
							dialog.textArea.append(punto + der.getNombre()
									+ newline);

						}
					}

					// System.out
					// .println("Desarrolladores con experiencia en web o celular y no en java");
					dialog.textArea.append("saben web o celular pero no java:"
							+ newline);

					for (Desarrollador der : miSet) {
						if (der.isJava() == false
								&& (der.isCel() == true || der.isWeb() == true)) {
							// System.out.println(der.getNombre());
							dialog.textArea.append(punto + der.getNombre()
									+ newline);

						}
					}

					// ver si java es subconjunto de web

					for (Desarrollador der : miSet) {
						if ((der.isJava() == true) && (der.isWeb() == true)
								&& (der.isCel() == false)) {
							contajavayweb++;
						}
						if (der.isWeb() == true) {
							contaweb1++;
						}
					}

					if (contajavayweb <= contaweb1) {
						dialog.textArea.append(punto + "Si es subconjunto"
								+ newline);
					} else {
						dialog.textArea.append(punto + "No es subconjunto"
								+ newline);
					}
					// 5
					// System.out.println("El conjunto mas grande de desarrolladores");
					dialog.textArea
							.append("El conjunto mas grande de desarrolladores"
									+ newline);

					for (Desarrollador der : miSet) {
						if (der.isJava() == true) {
							contajava++;
						}
						if (der.isWeb() == true) {
							contaweb++;
						}
						if (der.isCel() == true) {
							contacel++;
						}
					}

					if ((contajava > contaweb) && (contajava > contacel)) {
						dialog.textArea.append("java" + newline);
						for (Desarrollador der : miSet) {
							if (der.isJava() == true) {
								// System.out.println(der.getNombre());
								dialog.textArea.append(punto + der.getNombre()
										+ newline);

							}
						}
					}
					if ((contaweb > contajava) && (contaweb > contacel)) {
						dialog.textArea.append("web" + newline);

						for (Desarrollador der : miSet) {
							if (der.isWeb() == true) {
								// System.out.println(der.getNombre());
								dialog.textArea.append(punto + der.getNombre()
										+ newline);

							}
						}
					}
					if ((contacel > contaweb) && (contacel > contajava)) {
						dialog.textArea.append("movil" + newline);

						for (Desarrollador der : miSet) {
							if (der.isCel() == true) {
								// System.out.println(der.getNombre());
								dialog.textArea.append(punto + der.getNombre()
										+ newline);

							}
						}

					}
					// 6
					// System.out
					// .println("El conjunto mas grande de desarrolladores en orden");
					dialog.textArea
							.append("El conjunto mas grande de desarrolladores en orden:"
									+ newline);

					// TreeSet<String> miTree = new TreeSet<String>();
					ArrayList<String> a = new ArrayList<String>();
					if ((contajava > contaweb) && (contajava > contacel)) {
						for (Desarrollador der : miSet) {
							if (der.isJava() == true) {
								a.add(der.getNombre());

							}
						}
					}
					if ((contaweb > contajava) && (contaweb > contacel)) {
						for (Desarrollador der : miSet) {
							if (der.isWeb() == true) {
								a.add(der.getNombre());
							}
						}
					}
					if ((contacel > contaweb) && (contacel > contajava)) {
						for (Desarrollador der : miSet) {
							if (der.isCel() == true) {
								a.add(der.getNombre());
							}
						}
					}

					// System.out.println(miTree);
					Collections.sort(a);
					for (String i : a) {
						dialog.textArea.append(punto + i + newline);
					}

				} catch (Exception ex) {

				}
			}
		}
	}
}