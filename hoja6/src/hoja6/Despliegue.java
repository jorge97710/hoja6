package hoja6;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
/**
 * 
 * Esta clase extiende de JDialog, se utiliza para desplegar en otra ventana a los desarrolladores
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Despliegue extends JDialog{

	/*Atributos*/
	public JTextArea textArea = new JTextArea();
	
	/**
	 * Constructor para inicializar el JDialog
	 */
	public Despliegue() {
		initialize();
	}
	/**
	 * Inicializar contenidos del Frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.DARK_GRAY);
		//Tamano
		setBounds(100, 100, 706, 457);
		JScrollPane scrollPane = new JScrollPane();
		JLabel lblNewLabel = new JLabel("Resultados\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//Layout tipo Group
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(292)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addGap(293))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(20)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
				);
		//No editable
		textArea.setEditable(false);
		textArea.setForeground(Color.DARK_GRAY);
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
		//Se agrega el layout al JDialog 
		getContentPane().setLayout(groupLayout);
	}
}


