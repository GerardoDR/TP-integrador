package ar.edu.unlam.pb1.TPIntegrador.dominio;

public class Prode {
	private Participante participantes [];
	private Partido partidos[];
	private int cantidadParticipantes;
	

	public Prode (int maxParticipantes) {
		this.participantes = new Participante[maxParticipantes];
	}
	
	public boolean registrarParticipantes (Participante participantes) {
		return false;
	}
	
	public boolean inicializarPartidos(int totalPartidos) {
		this.partidos = new Partido[totalPartidos];
		return false;
	}

	public boolean registrarPartidos(int totalPartidos) {
		this.partidos = new Partido[totalPartidos];
		return false;
	}

	public Participante obtenerGanador() {
		return null;
	}
}
