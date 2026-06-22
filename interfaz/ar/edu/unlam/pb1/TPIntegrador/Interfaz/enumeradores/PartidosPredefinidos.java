package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public enum PartidosPredefinidos {
	PARTIDO1(0),PARTIDO2(1),PARTIDO3(2),PARTIDO4(3),PARTIDO5(4),PARTIDO6(5),PARTIDO7(6),PARTIDO8(7);
	
private Equipo equipoLocal;
private Equipo equipoVisitante;
//private final int posicion;
	
	PartidosPredefinidos(int posicion) {
		int posicionInicial=posicion*2;
		Equipo[] equiposDisponibles = Equipo.values();
		this.equipoLocal=equiposDisponibles[posicionInicial];
		this.equipoVisitante=equiposDisponibles[posicionInicial+1];
	}
	
	public Equipo getEquipoLocal(){
		return this.equipoLocal;
	}
	
	public Equipo getEquipoVisitante(){
		return this.equipoVisitante;
	}
	
	public String toString(){
		return this.equipoLocal.toString()+" vs. "+this.equipoVisitante.toString();
	}
}
