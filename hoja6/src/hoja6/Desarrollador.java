package hoja6;

public class Desarrollador implements Comparable<Desarrollador>{
	//Atributos
	private String nombre;
	private boolean web=false,java=false,cel=false;
	
	public Desarrollador(String nombre, boolean web, boolean java, boolean cel) {
		super();
		this.nombre = nombre;
		this.web = web;
		this.java = java;
		this.cel = cel;
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
		  return retorno = this.nombre.compareTo(arg0.nombre);
	}
}
