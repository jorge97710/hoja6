package hoja6;
/**
 * Interfaz para la fabrica de Sets
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Fabricador {



	/**
	 * @return La fabrica de Sets
	 */
	public static SetFactory set(){

		return new Fabrica();


	}
}
