package ar.edu.unlam.pb1.TPIntegrador.dominio;

public class Partido {
	private String equipoLocal;
	private String equipoVisitante;
	private Resultado resultadoReal;
	
	public Partido (String equipoLocal, String equipoVisitante) {

		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.resultadoReal = Resultado.NO_JUGADO;
	}
	
	public void setResultadoReal (Resultado resultadoReal) {
		
	}
	
	public Resultado getResultadoReal() {
		return this.resultadoReal;
	}
	
	public String getEquipoVisitante () {
		return this.equipoVisitante;
	}
	
	public String getEquipoLocal () {
		return this.equipoLocal;
	}

	@Override
	public String toString() {
		return this.equipoLocal+" vs "+this.equipoVisitante;
	}
}
