package ar.edu.unlam.pb1.TPIntegrador.dominio;


public class Participante {
	private String nombre;
	private Prediccion predicciones [];
	private int cantidadPredicciones;
	
	public Participante (String nombre, int maxPredicciones) {
		this.nombre = nombre;
		this.predicciones = new Prediccion [maxPredicciones];
		this.cantidadPredicciones=0;
	} 
	
	public boolean agregarPrediccion (Prediccion prediccion) {

		if(cantidadPredicciones < predicciones.length){
			this.predicciones[cantidadPredicciones]= prediccion;
			cantidadPredicciones++;
			return true;
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
