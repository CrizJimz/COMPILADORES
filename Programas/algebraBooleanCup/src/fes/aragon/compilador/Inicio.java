package fes.aragon.compilador;

import java.net.URISyntaxException;

public class Inicio {
	private String ruta;
	public Inicio() {
		// TODO Auto-generated constructor stub
	}
	public String getRuta() throws URISyntaxException {
		ruta=this.getClass().getResource("/fes/aragon/compilador/Fuente.txt").toURI().getPath();
		return ruta;
		
	}
	public static void main(String[] args) {
		TablaSimbolos tabla=new TablaSimbolos();
		Inicio app=new Inicio();
		parser pr=new parser();
		try {
			pr.cargar(app.getRuta(), tabla);
			tabla.imprimir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
