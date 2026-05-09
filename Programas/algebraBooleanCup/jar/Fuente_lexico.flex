package fes.aragon.compilador;
import java_cup.runtime.Symbol;
import java.io.Reader;
%%
%{
    private TablaSimbolos tabla;

    // Constructor para integrar con la tabla de símbolos si es necesario
    public Lexico(java.io.Reader in, TablaSimbolos t){
       this(in);
       this.tabla = t;
    }

    public int getYyline() {
        return yyline;
    }

    public int getYycolumn() {
        return yycolumn;
    }
%}

%class Lexico
%public
%char
%line
%column
%cup
%ignorecase
%type java_cup.runtime.Symbol

%eofval{
    return new Symbol(sym.EOF, new String("Fin del archivo"));
%eofval}

/* Macros */
DIGITO = [0-9]
LETRA  = [a-zA-Z]
ID     = {LETRA}({LETRA}|{DIGITO})*
ESPACIO = [ \t\f]
SALTO   = \n|\r|\r\n

%%

/* Operadores Lógicos y Palabras Reservadas */
"OR"    { System.out.println("Token: OR"); return new Symbol(sym.OR); }
"AND"   { System.out.println("Token: AND"); return new Symbol(sym.AND); }
"NOT"   { System.out.println("Token: NOT"); return new Symbol(sym.NOT); }
"TRUE"  { System.out.println("Token: TRUE"); return new Symbol(sym.TRUE); }
"FALSE" { System.out.println("Token: FALSE"); return new Symbol(sym.FALSE); }

/* Símbolos de Puntuación */
";"     { System.out.println("Token: PUNTOYCOMA"); return new Symbol(sym.PUNTOYCOMA); }
"("     { System.out.println("Token: LPAREN"); return new Symbol(sym.LPAREN); }
")"     { System.out.println("Token: RPAREN"); return new Symbol(sym.RPAREN); }

/* Identificadores (por si los ocupas en la gramática como variables) */
{ID} {
       Datos s;
       if(tabla != null){
           if((s = tabla.buscar(yytext())) == null){
              s = tabla.insertar(yytext());
           }
           System.out.println("ID detectado: " + yytext());
           return new Symbol(sym.ID, s);
       }
       System.out.println("ID detectado (sin tabla): " + yytext());
       return new Symbol(sym.ID, yytext());
}

/* Ignorar Blancos y Saltos */
{ESPACIO} { /* Ignorar */ }
{SALTO}   { /* Ignorar */ }

/* Error Léxico */
. {
    System.out.println("Error léxico: <" + yytext() + "> en línea " + (yyline+1) + ", columna " + (yycolumn+1));
}