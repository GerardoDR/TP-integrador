package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public enum Equipo {
	ARGENTINA("Argentina"), ARGELIA("Argelia"), INGLATERRA("Inglaterra"), CROACIA("Croacia"), UZBEKISTAN("Uzbekistan"), COLOMBIA("Colombia"), QATAR("Qatar"), SUIZA("Suiza"), PORTUGAL("Portugal"), CONGO("Congo"), EEUU("Estados Unidos"), PARAGUAY("Paraguay"), MEXICO("Mexico"), COREA("Corea"), PANAMA("Panamá"), GHANA("Ghana");
	
	private String valor;
	
	Equipo(String descripcion){
		this.valor= descripcion;
	}
	
	@Override
	public String toString() {
		return valor;
	}
}
