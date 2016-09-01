package hoja6;

public class Desarrollador implements Comparable<Desarrollador>{
	//Atributos
	private String nombre;
	private int id;
	private boolean web,java,cel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Desarrollador(String nombre, boolean web, boolean java, boolean cel,int id) {
		super();
		this.nombre = nombre;
		this.web = web;
		this.java = java;
		this.cel = cel;
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public boolean isJava() {
		return java;
	}
	public void setJava(boolean java) {
		this.java = java;
	}
	public boolean isCel() {
		return cel;
	}
	public void setCel(boolean cel) {
		this.cel = cel;
	}
	@Override
	public String toString() {
		return "Desarrollador [nombre=" + nombre + "]";
	}
	@Override
	public int compareTo(Desarrollador arg0) {
		  Integer retorno = null;
		  return retorno = this.id - arg0.id;
	}
}
