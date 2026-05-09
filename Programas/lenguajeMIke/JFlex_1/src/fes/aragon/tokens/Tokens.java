package fes.aragon.tokens;

public enum Tokens {
	// Palabras Reservadas y Control
	INICIO,

	// Operadores de Asignación y Relacionales
	ASIGNACION,       // =
	IGUAL_QUE,        // ==
	MAYOR_QUE,        // >
	MENOR_QUE,        // <
	MAYOR_IGUAL_QUE,  // >=
	MENOR_IGUAL_QUE,  // <=
	DIFERENTE,        // !=

	// Operadores Aritméticos
	SUMA,             // +
	RESTA,            // -
	MULTIPLICACION,   // *
	DIVISION,         // /

	// Signos de Puntuación y Agrupación
	PAR_ABIERTO,      // (
	PAR_CERRADO,      // )
	PUNTO_COMA,       // ;
	DOS_PUNTOS,       // :
	ADMIRACION,       // !

	// Literales e Identificadores
	ID,               // Variables
	INT,              // Números enteros
	FLOAT,            // Números decimales (ruta q3-q5-q6-q7)

	// Errores
	ERROR
}