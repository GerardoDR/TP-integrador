package ar.edu.unlam.pb1.TPIntegrador.dominio;


public class Participante {
	private String nombre;
	private Prediccion predicciones [];
	private int cantidadPredicciones;
	private int puntaje;
	
	public Participante (String nombre, int maxPredicciones) {
		this.nombre = nombre;
		this.predicciones = new Prediccion [maxPredicciones];
		this.cantidadPredicciones=0;
		this.puntaje=0;
	} 
	
	public boolean agregarPrediccion (Prediccion prediccion) {

		if(cantidadPredicciones < predicciones.length){
			this.predicciones[cantidadPredicciones]= prediccion;
			cantidadPredicciones++;
			return true;
		}
		return false;
	}

	public Prediccion[] getPredicciones(){
		return predicciones;
	}
	
	public void calcularPuntaje () {
		for (int i = 0; i < predicciones.length; i++) {
			if(this.predicciones[i].esAcertada()){
				this.setPuntaje(getPuntaje()+1);
			}
		}
	}
	
	private void setPuntaje(int puntaje){
		this.puntaje=puntaje;
	}

	public int getPuntaje() {
		return this.puntaje;
	}
	public String getNombre () {
		return this.nombre;
	}
}
