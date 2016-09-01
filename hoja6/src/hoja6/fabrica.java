package hoja6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 *Clase fabrica para los Stacks
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 2.0 agosto 15, 2016
 * 
 */
public class fabrica implements setfactory {

	
	@Override
	public Set<Desarrollador> crearSet(String tipoSet) {

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
