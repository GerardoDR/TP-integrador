package ar.edu.unlam.pb1.TPIntegrador.dominio;

public class Prode {
	private Participante participantes [];
	private Partido partidos[];
	private int cantidadParticipantes;
	private int cantidadPartidosRegistrados;
	

	public Prode (int maxPartidos,int maxParticipantes) {
		this.participantes = new Participante[maxParticipantes];
		this.partidos= new Partido[maxPartidos];
		this.cantidadParticipantes=0;
		this.cantidadPartidosRegistrados=0;
	}
	
	public boolean registrarParticipantes (Participante participantes) {
		return false;
	}
	

	public boolean registrarPartido(String equipoLocal, String equipoVisitante) {
		if(cantidadPartidosRegistrados<partidos.length) {
			this.partidos[cantidadPartidosRegistrados] = new Partido(equipoLocal,equipoVisitante);
			return true;
		}
		return false;
	}

	public Participante obtenerGanador() {
		return null;
	}
	
	public Partido[] getPartidos() {
		return this.partidos;
	}
}
