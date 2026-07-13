package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public enum Equipo {
	PARAGUAY("Paraguay"),
	FRANCIA("Francia"),
	CANADA("Canadá"),
	MARRUECOS("Marruecos"),
	PORTUGAL("Portugal"),
	ESPANA("España"),
	EEUU("Estados Unidos"),
	BELGICA("Bélgica"),
	BRASIL("Brasil"),
	NORUEGA("Noruega"),
	MEXICO("México"),
	INGLATERRA("Inglaterra"),
	ARGENTINA("Argentina"),
	EGIPTO("Egipto"),
	SUIZA("Suiza"),
	COLOMBIA("Colombia");
	
	private String equipo;
	
	Equipo(String equipo){
		this.equipo= equipo;	
	}
	
	public String getEquipo(){
		return this.equipo;
	}
	
	@Override
	public String toString() {
		return this.equipo;
	}
}
