package ar.edu.unlam.pb1.TPIntegrador.dominio;

public enum Resultado {
		LOCAL("Gana el equipo local"), 
		EMPATE("Empate"), 
		VISITANTE("Gana el equipo visitante"), 
		NO_JUGADO("No se jugó aún");
		
	private String resultado;
	
	Resultado(String resultado){
		this.resultado= resultado;
	}

	public String getResultado() {
		return resultado;
	}
}
