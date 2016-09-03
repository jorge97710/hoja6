package hoja6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Esta clase es la fabrica de las implementaciones de Set.
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Fabrica implements SetFactory {


	/* (non-Javadoc)
	 * @see hoja6.setfactory#crearSet(java.lang.String)
	 * Dependiendo el String, sera la implementacion a usar
	 */
	@Override
	public Set crearSet(String tipoSet) {

		if ("HS".equalsIgnoreCase(tipoSet)) {
			return new HashSet<Desarrollador>();
		}
		if ("TS".equalsIgnoreCase(tipoSet)) {
			return new TreeSet<Desarrollador>();

		}

		if ("LHS".equalsIgnoreCase(tipoSet)) {
			return new LinkedHashSet<Desarrollador>();

		}

		return null;	}

}
