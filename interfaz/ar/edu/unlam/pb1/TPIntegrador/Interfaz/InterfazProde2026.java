package ar.edu.unlam.pb1.TPIntegrador.Interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores.OpcionesMenuPrincipal;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Prode;

public class InterfazProde2026 {
	static Scanner teclado = new Scanner(System.in);
	static final int TOTAL_PARTIDOS = 8;
	static final OpcionesMenuPrincipal[] opcionesMenum = OpcionesMenuPrincipal.values();
	
	public static void main(String[] args) {
		imprimirBienvenida();
		int cantidadParticipantes = teclado.nextInt();
		Prode prode = new Prode(cantidadParticipantes);
		prode.inicializarPartidos(TOTAL_PARTIDOS);

		imprimirMenuPrincipal();

	}

	private static void imprimirBienvenida() {
		System.out.println("=====================================\n" + "SISTEMA EL PRODE DEL MUNDIAL 2026\n"
				+ "=====================================\n" + "Ingresar cantidad de participantes:");
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