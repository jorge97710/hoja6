package hoja6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 * Clase para manejar diversos procesos del programa. Especialmente usada para 
 * procesos de despliegue. Asimismo, de anadir datos.
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Logica {
	/*Atributos*/
	private Despliegue dialog  = new Despliegue();
	private  int contajava = 0, contaweb = 0, contacel = 0,
			contaweb1 = 0, contajavayweb = 0;
	private final static String newline = "\n", punto = ">";
	private  Set<Desarrollador> miSet;
	public Logica(){}

	/**
	 * Metodo simple para verificar si no se ingreso una opcion de implementacion
	 * adecuada.
	 * @param s contiene el texto ingresado por el usuario
	 */
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
	/**
	 * Metodo para instaciar la coleccion deseada.
	 * @param tipo para seleccionar implementacion a usar
	 */
	void listo(String tipo){
		SetFactory Creasets = Fabricador.set();
		miSet = Creasets.crearSet(tipo);	
	}

	/**
	 * Metodo para anadir elemento a la coleccion, parametros referentes a datos
	 * del desarrollador
	 * @param nombre	nombre del desarrollador
	 * @param opc1		ambiente1
	 * @param opc2		ambiente2
	 * @param opc3		ambiente3
	 * @param id		numero de desarrolladdor
	 */
	void anadir(String nombre,boolean opc1,boolean opc2,boolean opc3,int id){
		miSet.add(new Desarrollador(nombre, opc1,opc2, opc3, id));
	}


	/**
	 * Metodo para desplegar el JDialog con los datos solicitados de la coleccion
	 * 1. Desarrolladores con experiencia en Java, web y celulares.
	 * 2. Desarrolladores con experiencia en Java pero que no tengan experiencia en web.
	 * 3. Desarrolladores con experiencia en Web y Celulares (intersección de Web y Celuares),
	 *  pero que no tengan experiencia en java
	 * 4. Desarrolladores con experiencia en Web o Celulares (unión de Web y Celuares), 
	 * pero que no tengan experiencia en java.
	 * 5. Indicar SI o NO el conjunto de desarrolladores Java es un subconjunto de Desarrolladores Web.
	 * 6. El conjunto (Java, Web o Celulares) que tenga la cantidad más grande de desarrolladores, 
	 * y los nombres de esos desarrolladores.
	 * 7. Del conjunto que tenga la mayor cantidad de desarrolladores, 
	 * desplegar la lista de los nombres de sus integrantes en orden ascendente.
	 */
	void desplegar(){
		contajava = 0;
		contaweb = 0; contacel = 0;
		contaweb1 = 0; contajavayweb = 0;
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.textArea.setText("");
			//Inciso 1
			dialog.textArea.append("Desarrolladores con experiencia en Java, web y celulares: " + newline);
			vacio(1);
			for (Desarrollador der : miSet) {
				if (der.isJava() == true && der.isCel() == true
						&& der.isWeb() == true) {
					dialog.textArea.append(punto + der.getNombre()
					+ newline);
				}
			}
			//Inciso 2
			dialog.textArea.append(". Desarrolladores con experiencia en Java pero sin experiencia en web." + newline);
			vacio(2);
			for (Desarrollador der : miSet) {
				if (der.isJava() == true && der.isWeb() == false) {
					dialog.textArea.append(punto + der.getNombre()
					+ newline);

				}
			}
			//Inciso 3
			dialog.textArea.append("Desarrolladores con experiencia en Web y Celulares, pero que no tienen experiencia en java."
					+ newline);
			vacio(3);
			for (Desarrollador der : miSet) {
				if (der.isJava() == false
						&& (der.isCel() == true && der.isWeb() == true)) {
					dialog.textArea.append(punto + der.getNombre()
					+ newline);

				}
			}
			// Inciso 4
			dialog.textArea.append("Desarrolladores con experiencia en Web o Celulares (sin experiencia en java)"
					+ newline);
			vacio(4);
			for (Desarrollador der : miSet) {
				if (der.isJava() == false
						&& (der.isCel() == true || der.isWeb() == true)) {
					dialog.textArea.append(punto + der.getNombre()
					+ newline);

				}
			}

			//Inciso 5
			subconjunto();
			//Inciso 6
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
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Java " + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isJava() == true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);

					}
				}
			}
			if ((contajava == contaweb) && (contajava == contacel)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: los tres " + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					dialog.textArea.append(punto + der.getNombre()
					+ newline);
				}
			}
			if ((contajava == contaweb) && (contajava > contacel)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Java y Web " + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isJava() == true && der.isWeb()==true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);
					}
				}
			}
			if ((contaweb > contajava) && (contaweb== contacel)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Web y Movil " + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isWeb() == true && der.isCel()==true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);
					}
				}
			}
			if ((contacel == contajava) && (contacel>contaweb)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Java y Movil " + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isJava() == true && der.isCel()==true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);
					}
				}
			}
			if ((contaweb > contajava) && (contaweb > contacel)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Web" + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isWeb() == true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);

					}
				}
			}
			if ((contacel > contaweb) && (contacel > contajava)) {
				dialog.textArea.append("El conjunto que tiene la cantidad más grande de desarrolladores es: Movil" + newline);
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isCel() == true) {
						dialog.textArea.append(punto + der.getNombre()
						+ newline);
					}
				}

			}
			//Inciso 7 
			dialog.textArea
			.append("El conjunto mas grande de desarrolladores en orden ascendente:"
					+ newline);

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
			if ((contajava == contaweb) && (contajava == contacel)) {
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					a.add(der.getNombre());
				}
			}
			if ((contajava == contaweb) && (contajava > contacel)) {
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isJava() == true && der.isWeb()==true) {
						a.add(der.getNombre());
					}
				}
			}
			if ((contaweb > contajava) && (contaweb== contacel)) {
				dialog.textArea.append("Nombres:"	+ newline);
				for (Desarrollador der : miSet) {
					if (der.isWeb() == true && der.isCel()==true) {
						a.add(der.getNombre());
					}
				}
			}
			if ((contacel == contajava) && (contacel>contaweb)) {dialog.textArea.append("Nombres:"	+ newline);
			for (Desarrollador der : miSet) {
				if (der.isJava() == true && der.isCel()==true) {
					a.add(der.getNombre());
				}
			}
			}
			Collections.sort(a);
			for (String i : a) {
				dialog.textArea.append(punto + i + newline);
			}

		} catch (Exception ex) {
			System.out.println("no");
		}
	}
	/**
	 * Metodo para identificar si alguna opcion a desplegar en el metodo desplegar no tiene elementos.
	 * @param opc para indicar numero de opcion del metodo desplegar.
	 */
	void vacio(int opc){
		int cont=0;
		switch(opc){
		case 1:
			for (Desarrollador der : miSet) {
				if (der.isJava() == true && der.isCel() == true
						&& der.isWeb() == true) {
					cont++;
				}
			}
			break;
		case 2:
			for (Desarrollador der : miSet) {
				if (der.isJava() == true && der.isWeb() == false) {
					cont++;
				}
			}
			break;
		case 3:
			for (Desarrollador der : miSet) {
				if (der.isJava() == false
						&& (der.isCel() == true && der.isWeb() == true)) {
					cont++;
				}
			}
			break;
		case 4:
			for (Desarrollador der : miSet) {
				if (der.isJava() == false
						&& (der.isCel() == true || der.isWeb() == true)) {
					cont++;
				}
			}
			break;
		}
		if (cont==0){
			dialog.textArea.append(punto + "Vacio"
					+ newline);
		}

	}

	/**
	 *	Metodo aparte de desplegar para verificar si los desarrolladores de java estan 
	 *  inmersos en los que desarrollan Web. 
	 */
	void subconjunto(){
		dialog.textArea.append("¿Desarrolladores de java subconjunto de desarrolladores web?"
				+ newline);
		for (Desarrollador der : miSet) {
			if ((der.isJava() == true) && (der.isWeb() == true)) {
				contajavayweb++;
			}
			if (der.isJava() == true) {
				contaweb1++;
			}
		}
		if (contajavayweb == contaweb1) {
			dialog.textArea.append(punto + "Si es subconjunto"
					+ newline);
		} else {
			dialog.textArea.append(punto + "No es subconjunto"
					+ newline);
		}
	}
}
