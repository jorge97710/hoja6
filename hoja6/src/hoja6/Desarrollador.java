package hoja6;

/**
 * 
 * Esta clase simula a un desarrollador.
 * @author Carlos Calderon, 15219
 * @author Jorge Azmitia,15202
 * @version 3.0 Septiembre 3, 2016 
 * 
 */
public class Desarrollador {
	/*Atributos*/
	private String nombre;
	private int id;
	private boolean web,java,cel;

	/**
	 *  Constructor 
	 * @param nombre	nombre del desarrollador
	 * @param web		indicar si desarrolla web
	 * @param java		indicar si desarrolla java
	 * @param cel		indicar si desarrolla movil
	 * @param id		numero de desarrollador
	 */
	public Desarrollador(String nombre, boolean web, boolean java, boolean cel,int id) {
		super();
		this.nombre = nombre;
		this.web = web;
		this.java = java;
		this.cel = cel;
		this.id=id;
	}
	/**
	 * @return	el numero de desarrollador registrado en la coleccion
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id	id para cambiar (no se utiliza en este contexto)	
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return	el nombre del desarrollador
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre	nombre del desarrollador para cambiarlo (no se utiliza en este contexto)
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return	si desarrolla en ambiente web
	 */
	public boolean isWeb() {
		return web;
	}
	/**
	 * @param web	web para cambiar si no desarrolla en este ambiente (no se utiliza en este contexto)
	 */
	public void setWeb(boolean web) {
		this.web = web;
	}
	/**
	 * @return	si desarrolla en ambiente java 
	 */
	public boolean isJava() {
		return java;
	}
	/**
	 * @param java	java para cambiar si no desarrolla en este ambiente (no se utiliza en este contexto)
	 */
	public void setJava(boolean java) {
		this.java = java;
	}
	/**
	 * @return	si desarrolla en ambiente movil
	 */
	public boolean isCel() {
		return cel;
	}
	/**
	 * @param cel	movil para cambiar si no desarrolla en este ambiente (no se utiliza en este contexto)
	 */
	public void setCel(boolean cel) {
		this.cel = cel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Desarrollador [nombre=" + nombre + "]";
	}
	
	
}
