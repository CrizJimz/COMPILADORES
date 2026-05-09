package fes.aragon.compilador;

import java.util.HashMap;
import java.util.Iterator;

public class TablaSimbolos {
	private HashMap<String, Datos> t;
	public TablaSimbolos() {
		t=new HashMap<>();
	}
	
	public Datos insertar(String nombre) {
		Datos ss=new Datos();
		ss.setLexema(sym.ID);
		ss.setNombreVariable(nombre);
		ss.setValor("0");
		t.put(nombre, ss);
		return ss;
		
	}
	public Datos buscar(String nombre) {

        return (Datos)(t.get(nombre));
	}
	public void imprimir() {
		System.out.println("Valores de la tabla de simbolos");
		Iterator<Datos> it=t.values().iterator();
		while(it.hasNext()) {
			Datos s=(Datos)it.next();
			System.out.println(s.getNombreVariable()+":"+s.getValor());
			
		}
	}
}
