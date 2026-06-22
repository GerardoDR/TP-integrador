package ar.edu.unlam.pb1.TPIntegrador.Interfaz.enumeradores;

public enum OpcionesMenuPrincipal {
	REGISTRAR_PARTIDOS("Registrar partidos automáticamente"), REGISTRAR_PARTICIPANTE("Registrar participante"),
	GENERAR_RESULTADOS("Generar resultados aleatorios"), CALCULAR_GANADOR("Calcular ganador"),;

	private String descripcion;

	OpcionesMenuPrincipal(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return descripcion;
	}
}
