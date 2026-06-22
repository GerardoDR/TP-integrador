package ar.edu.unlam.pb1.TPIntegrador.Interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.TPIntegrador.dominio.Prode;

public class InterfazProde2026 {
	static Scanner teclado = new Scanner(System.in);
	static final int TOTAL_PARTIDOS = 8;
	public static void main(String[] args) {
		imprimirMenuInicial();
		int cantidadParticipantes = teclado.nextInt();
		Prode prode = new Prode(cantidadParticipantes);
		prode.inicializarPartidos(TOTAL_PARTIDOS);

		imprimirMenuPrincipal();

	}

	public static void imprimirMenuInicial() {
		System.out.println("=====================================\n\n" + "SISTEMA EL PRODE DEL MUNDIAL 2026\n\n"
				+ "=====================================\n\n\n" + "Ingresar cantidad de participantes:");
	}

	public static void imprimirMenuPrincipal() {
		System.out.println("=====================================\n\n" + "SISTEMA EL PRODE DEL MUNDIAL 2026\n\n"
				+ "=====================================\n\n\n" + "1 - Agregar nuevo partido\n\n"
				+ "2 - Registrar participante\n\n" + "3 - Llenar prode\n\n" + "4 - Actualizar partido\n\n"
				+ "5 - Generar resultados aleatorios\n\n" + "6 - Calcular ganador\n\n" + "0 - Salir\n\n\n"
				+ "Seleccione una opción:");
	}

}