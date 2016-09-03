package hoja6;

import java.util.Set;


/**
 * 
 *Interfaz para las fabricas de Sets.
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 2.0 agosto 15, 2016
 * 
 */
/**
 * @author Carlos
 *
 */
public interface SetFactory {

	
	/**
	 * @param tipoSet para conocer que implementacion se creara
	 * @return	la implementacion escogida
	 */
	Set crearSet (String tipoSet);
}
