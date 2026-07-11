package ar.edu.unlam.pb1.TPIntegrador.dominio;

public class Prode {
	private Participante participantes [];
	private Partido partidos[];
	private int cantidadParticipantes;
	private int cantidadPartidosRegistrados;
	private boolean puntajesCalculados = false;
	

	public Prode (int maxPartidos,int maxParticipantes) {
		this.participantes = new Participante[maxParticipantes];
		this.partidos= new Partido[maxPartidos];
		this.cantidadParticipantes=0;
		this.cantidadPartidosRegistrados=0;
	}
	
	public boolean registrarParticipantes (Participante participante) {
		//guardamos el nuevo participante en el array de participantes
		if(this.cantidadParticipantes< this.participantes.length){
			this.participantes[cantidadParticipantes] = participante;
			this.cantidadParticipantes++;
			return true;
		}
		return false;
	}
	

	public Partido registrarPartido(String equipoLocal, String equipoVisitante) {
		if(cantidadPartidosRegistrados<partidos.length) {
			this.partidos[cantidadPartidosRegistrados] = new Partido(equipoLocal,equipoVisitante);
			cantidadPartidosRegistrados++;
			return this.partidos[cantidadPartidosRegistrados-1];
		}
		return null;
	}

	public void generarResultadosPartidos(){
		for (int i = 0; i < partidos.length; i++) {
			partidos[i].setResultadoReal(obtenerResultadoRandom());
		}
	}

	private Resultado obtenerResultadoRandom(){
		Resultado[] resultados = Resultado.values();
		int resultado = (int) (Math.random()*(resultados.length-1));
		return resultados[resultado];
	}
	
	public void calcularPuntajes (){
		for (int i = 0; i < participantes.length; i++) {
			participantes[i].calcularPuntaje(partidos);
		}
		this.puntajesCalculados =true;
	}

	public Participante[] obtenerGanador() {
		if(!puntajesCalculados){
			this.calcularPuntajes();
		}
		ordenarParticipantesPorPuntaje();
		
		Participante [] ganadores = new Participante[participantes.length];
		//guardamos al primer ganador
		ganadores[0]=participantes[0];
		for (int i = 1; i < participantes.length; i++) {
			if(ganadores[0].getPuntaje() == participantes[i].getPuntaje()){
				for(int j=1; j < ganadores.length; j++){
					if (ganadores[j]==null) {
						ganadores[j]=participantes[i];
					}
				}
			}
		}
		return ganadores;
	}

	private void ordenarParticipantesPorPuntaje(){
		for(int i=0; i<participantes.length-1; i++) {
			for(int j=0; j<participantes.length-1; j++) {
				if(participantes[j] != null && participantes[j+1] != null && participantes[j].getPuntaje() < participantes[j+1].getPuntaje()) {
					Participante auxiliar;
					auxiliar = participantes[j];
					participantes[j] = participantes[j+1];
					participantes[j+1] = auxiliar;
				}
			}
		}
	}
	
	public Partido[] getPartidos() {
		return this.partidos;
	}

	public Participante[] getParticipantes(){
		return this.participantes;
	}

	public int getCantidadParticipantes(){
		return this.cantidadParticipantes;
	}
}
