package ar.edu.unlam.pb1.TPIntegrador.Interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores.Equipo;
import ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores.OpcionesMenuPrincipal;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Participante;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Partido;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Prediccion;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Prode;
import ar.edu.unlam.pb1.TPIntegrador.dominio.Resultado;

public class InterfazProde2026 {
	static Scanner teclado = new Scanner(System.in);
	static final int TOTAL_PARTIDOS = 8;
	static final OpcionesMenuPrincipal[] opcionesMenum = OpcionesMenuPrincipal.values();
	
	public static void main(String[] args) {
		//le damos la bienvenida la prode, y posteriormente comienza el show :)
		imprimirBienvenida();
		int cantidadParticipantes = teclado.nextInt();
		Prode prode = new Prode(TOTAL_PARTIDOS, cantidadParticipantes);
		OpcionesMenuPrincipal opcion=null;
		boolean validacionRegistrarPartido = false;
		boolean validacionResultadosGenerados = false;

		while(opcion!=OpcionesMenuPrincipal.SALIR) {
			
			imprimirMenuPrincipal();
			opcion = ingresaOpcion();
			
			switch (opcion) {
			case REGISTRAR_PARTIDOS:
				registrarPartidosAutomaticamente(prode);
				validacionRegistrarPartido = true;
				break;
			case REGISTRAR_PARTICIPANTE:
				//Validación: para registrar predicciones se necesitán los partidos generados previamente.
				if(validacionRegistrarPartido == true) {
				registrarParticipante(prode);
				}else mostrarPorPantalla("\tPara registrar participantes se requiere antes registrar los partidos\n");
				break;
			case GENERAR_RESULTADOS:
				//validación: Las predicciones deben ser generadas antes de que existan los resultados reales.
				if (prode.getCantidadParticipantes() == prode.getParticipantes().length) {
					generarResultados(prode);
					validacionResultadosGenerados = true;
				} else {
					mostrarPorPantalla("No se han registrado aún la cantidad total de participantes.");
					mostrarPorPantalla("Cantidad registrada de participantes actuales "+ prode.getCantidadParticipantes());
				}
				break;
			case CALCULAR_GANADOR:
				//Validación: Se requieren los resultados de los partidos para calcular los puntajes.
				if(validacionResultadosGenerados){
					calcularGanador(prode);
				} else {
					System.out.println("Se deben generar primero los resultados antes de poder calcular un ganador");	
				}
				break;
			case SALIR:
				mostrarPorPantalla("¡Gracias por participar!");
				break;
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

		// for(int i=0; i<prode.getPartidos().length*2; i+=2){
		// 	registrarPartido(prode, equipos[i].getEquipo(), equipos[i+1].getEquipo());			
		// }

		//espacio al final
		mostrarPorPantalla("");
	}
	
	private static void registrarPartido(Prode prode, String equipoLocal, String equipoVisitante) {
		String partido = equipoLocal+" vs "+equipoVisitante;
		if(prode.registrarPartido(equipoLocal, equipoVisitante)) {
			mostrarPorPantalla("Partido registrado: "+partido);
		} else {
			mostrarPorPantalla("Partido no registrado: "+partido);
		}
	}
	
	private static void registrarParticipante(Prode prode) {

		//Validación de que el cupo de participantes no está lleno.
		if(prode.getCantidadParticipantes() < prode.getParticipantes().length){
			mostrarPorPantalla("Ingresar nombre del participante:");
			String nombreParticipante= teclado.next();
			
			//guardamos array de resultados a mostrar
			Resultado resultadosPosibles[] = Resultado.values();
			
			//instanciamos el nuevo participante
			Participante nuevoParticipante = new Participante(nombreParticipante, TOTAL_PARTIDOS);
			
			//recorremos los partidos para asignar una prediccion en cada uno
			Partido [] partidos = prode.getPartidos();
			for (int i = 0; i < partidos.length; i++) {
				//solicitamos los datos para instanciar la predicción.
				mostrarPorPantalla("\nPredicción "+(i+1)+" de "+partidos.length);
				mostrarPorPantalla("\n🔮¿Quién ganará?🔮");
				mostrarPorPantalla("⚽Equipo local: "+partidos[i].getEquipoLocal());
				mostrarPorPantalla("⚽Equipo visitante: "+partidos[i].getEquipoVisitante()+"\n");
				mostrarResultadosPosibles(resultadosPosibles);
				Resultado resultadoDelPartido = ingresarResultado(resultadosPosibles);
				
				//instanciamos la nueva prediccion
				Prediccion nuevaPrediccion = new Prediccion(partidos[i], resultadoDelPartido);
				
				//guardamos la prediccion
				if(nuevoParticipante.agregarPrediccion(nuevaPrediccion)){
					mostrarPorPantalla("Predicción registrada");
				}
			}
			if(prode.registrarParticipantes(nuevoParticipante)){
				mostrarPorPantalla("Participante agregado");
			} else {
				mostrarPorPantalla("El cupo de participantes está lleno.");
			}

		} else{
			mostrarPorPantalla("El cupo de participantes está lleno.");
		}
	}
	
	private static void mostrarResultadosPosibles(Resultado[] resultados){
		for (int i = 0; i < resultados.length-1; i++) {
			if(resultados[i] != null){
				mostrarPorPantalla((i+1)+" - "+resultados[i].getResultado());
			}
		}
	}
	
	private static Resultado ingresarResultado(Resultado[] resultados){
		int opcion = 0;
		//instanciamos opcion en 0 para que el usuario ponga una opcion valida del enum Resultado, con los resultados posibles.
		while (opcion < 1 || opcion > resultados.length-1) {
			mostrarPorPantalla("Ingresar predicción sobre el partido: ");
			opcion = teclado.nextInt();
			//En caso de que ponga incorrectamente la opcion del enum, lo mandamos a volver a poner la opcion corecta de las existentes en el enum Resultado.
			if (opcion < 1 || opcion>resultados.length-1) {
				mostrarPorPantalla("Opción inválida. Ingrese nuevamente.");
			}
		}
		//Retornamos la opcion que nos manda el usuario, con -1 para que sea la opcion correcta del enum.
		return resultados[opcion-1];
	}

	private static void generarResultados(Prode prode){
		prode.generarResultadosPartidos();
		mostrarPorPantalla("Resultados generados.");
	}

	private static void calcularGanador(Prode prode){
		prode.calcularPuntajes();
		Participante[] ganadores = prode.obtenerGanador();
		mostrarPorPantalla("GANADOR/ES: ");
		for (int i = 0; i < ganadores.length; i++) {
			if (ganadores[i]!=null) {
				mostrarPorPantalla("\t🏆 "+ganadores[i].getNombre() + " - Puntaje: "+ganadores[i].getPuntaje());
			}
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