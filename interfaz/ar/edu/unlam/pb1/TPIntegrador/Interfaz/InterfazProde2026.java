package ar.edu.unlam.pb1.TPIntegrador.Interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores.Equipo;
import ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores.OpcionesMenuPrincipal;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Prode;

public class InterfazProde2026 {
	static Scanner teclado = new Scanner(System.in);
	static final int TOTAL_PARTIDOS = 8;
	static final OpcionesMenuPrincipal[] opcionesMenum = OpcionesMenuPrincipal.values();
	
	public static void main(String[] args) {
		imprimirBienvenida();
		int cantidadParticipantes = teclado.nextInt();
		Prode prode = new Prode(TOTAL_PARTIDOS, cantidadParticipantes);
		OpcionesMenuPrincipal opcion=null;
		while(opcion!=OpcionesMenuPrincipal.SALIR) {
			
			imprimirMenuPrincipal();
			opcion = ingresaOpcion();
			
			switch (opcion) {
			case REGISTRAR_PARTIDOS:
				registrarPartidosAutomaticamente(prode);
				break;
			case REGISTRAR_PARTICIPANTE:
			case GENERAR_RESULTADOS:
			case CALCULAR_GANADOR:
			case SALIR:
			default:
				mostrarPorPantalla("Opción inválida");
			}
			
		}
		

	}

	private static void imprimirBienvenida() {
		System.out.println("=====================================\n" + "SISTEMA EL PRODE DEL MUNDIAL 2026\n"
				+ "=====================================\n" + "Ingresar cantidad de participantes:");
	}
	
	private static void registrarPartidosAutomaticamente(Prode prode) {
		//DATOS PRECARGADOS
		Equipo[]equipos = Equipo.values();
		
		for(int i=0; i< prode.getPartidos().length; i++) {
			int posicionInicial=i*2;
			registrarPartido(prode, equipos[posicionInicial].getEquipo(), equipos[posicionInicial+1].getEquipo());			
		}
		//espacio al final
		mostrarPorPantalla("");
	}
	
	private static void registrarPartido(Prode prode, String equipoLocal, String equipoVisitante) {
		if(prode.registrarPartido(equipoLocal, equipoVisitante)) {
			mostrarPorPantalla("Partido registrado: "+equipoLocal+" vs. "+equipoVisitante);
		} else {
			mostrarPorPantalla("Partido no registrado: "+equipoLocal+" vs. "+equipoVisitante);
		}
	}
	
	private static OpcionesMenuPrincipal ingresaOpcion() {
		int opcion= teclado.nextInt();
		return opcionesMenum[opcion-1];
	}
	private static void imprimirMenuPrincipal() {
		mostrarPorPantalla("Seleccione una opción: ");
		for(int i=0; i< opcionesMenum.length; i++) {
			mostrarPorPantalla((i+1)+" - "+opcionesMenum[i].toString());	
		}
	}
	
	private static void mostrarPorPantalla(String mensaje) {
		System.out.println(mensaje);
	}

}