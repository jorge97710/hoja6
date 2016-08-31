package hoja6;

import java.util.Set;

import javax.swing.JOptionPane;

public class Logica {
	private Set<String> miSet;

	public void setMiSet(Set<String> miSet) {
		this.miSet = miSet;
	}

	void defensiva(String s) {
		if (s == null) {
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			System.exit(0);
		} else if (!(s.equalsIgnoreCase("HS") || s.equalsIgnoreCase("TS") || s
				.equalsIgnoreCase("LHS"))) {
			JOptionPane.showMessageDialog(null,
					"No ha ingresado una opcion valida");
			System.exit(0);
		}
	}
}
