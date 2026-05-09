package fes.aragon.compilador;

public class Simbolo {
	private String nombre;
	private Integer valor;
	public Simbolo(String nombre, Integer valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
