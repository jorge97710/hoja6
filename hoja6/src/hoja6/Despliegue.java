package hoja6;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Despliegue extends JDialog{

		//Atributos
		private String despliegue="";
		private JTextArea textArea = new JTextArea();
		//Metodo constructor 
		public Despliegue() {
			getContentPane().setBackground(Color.DARK_GRAY);
			//Se establece el tamaño
			setBounds(100, 100, 706, 457);
			JScrollPane scrollPane = new JScrollPane();
			JLabel lblNewLabel = new JLabel("Resultados\n");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
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


