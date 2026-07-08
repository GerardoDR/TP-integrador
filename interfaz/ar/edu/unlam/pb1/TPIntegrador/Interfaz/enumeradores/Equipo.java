package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public enum Equipo {
	PARAGUAY("Paraguay","PAR"),
	FRANCIA("Francia","FRA"),
	CANADA("Canadá","CAN"),
	MARRUECOS("Marruecos","MAR"),
	PORTUGAL("Portugal","POR"),
	ESPANA("España","ESP"),
	EEUU("Estados Unidos","EEUU"),
	BELGICA("Bélgica","BEL"),
	BRASIL("Brasil","BRA"),
	NORUEGA("Noruega","NOR"),
	MEXICO("México","MEX"),
	INGLATERRA("Inglaterra", "ING"),
	ARGENTINA("Argentina", "ARG"),
	EGIPTO("Egipto","EGI"),
	SUIZA("Suiza","SUI"),
	COLOMBIA("Colombia","COL");
	
	private String equipo;
	private String acronimo;
	
	Equipo(String equipo, String acronimo){
		this.equipo= equipo;
		this.acronimo= acronimo;
		
	}
	
	public String getEquipo(){
		return this.equipo;
	}
	
	@Override
	public String toString() {
		return this.equipo;
	}
}
