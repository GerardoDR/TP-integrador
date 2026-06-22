package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public class PruebaEnum {

	public static void main(String[] args) {
		PartidosPredefinidos[] partidos= PartidosPredefinidos.values();
		for(int i=0;i<partidos.length;i++) {
			System.out.println(partidos[i].getEquipoLocal().toString());
			System.out.println(partidos[i].getEquipoVisitante().toString());
			System.out.println(partidos[i].toString());
		}
	}

}
