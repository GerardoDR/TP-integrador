package ar.edu.unlam.pb1.TPIntegrador.dominio;

public class Prediccion {
	private Partido partido;
	private Resultado resultadoElegido;
	
	public Prediccion (Partido partido, Resultado resultadoElegido) {
		this.partido = partido;
		this.resultadoElegido = resultadoElegido;
	}
	
	public Partido getPartido () {
		return this.partido;
	}
	
	public Resultado getResultadoElegido () {
		return this.resultadoElegido;
	}
	
	public boolean esAcertada (Resultado resultadoReal) {
		if(resultadoReal.equals(this.resultadoElegido)){
			return true;
		}
		return false;
	}
}
