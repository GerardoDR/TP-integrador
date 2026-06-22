package ar.edu.unlam.pb1.TPIntegrador.dominio;


public class Participante {
	private String nombre;
	private Prediccion predicciones [];
	private int cantidadPredicciones;
	
	public Participante (String nombre, int maxPredicciones) {
		this.nombre = nombre;
		this.predicciones = new Prediccion [maxPredicciones];
	} 
	
	public boolean agregarPrediccion (Prediccion predicciones[]) {
		//hacer un for
		for (cantidadPredicciones = 0; cantidadPredicciones < this.predicciones.length; cantidadPredicciones++) {
			
		}
		return false;
	}
	
	public int calcularPuntaje () {
		return 1;
	}
	
	public String getNombre () {
		return this.nombre;
	}
}
