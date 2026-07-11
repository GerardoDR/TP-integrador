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
	
	public void calcularPuntaje (Partido[] partidos) {
		for (int i = 0; i < partidos.length; i++) {
			for (int j = 0; j < predicciones.length; j++) {
				if(partidos[i].getEquipoLocal().equals(
					predicciones[j].getPartido().getEquipoLocal()
				) && partidos[i].getEquipoVisitante().equals(
						predicciones[j].getPartido().getEquipoVisitante()
					)
				) {
						if(partidos[i].getResultadoReal().equals(predicciones[j].getResultadoElegido())){
							this.setPuntaje(this.getPuntaje()+1);
						}
				}
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
