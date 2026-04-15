package fes.aragon.tokens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class TestArchivo {
    public static void main(String[] args) {
        try{
            Reader rd=new BufferedReader(new FileReader("Fuente.txt"));
            Lexico lexico=new Lexico(rd);
            Tokens resultado;
            do {
                resultado=lexico.yylex();
                if(resultado!=null){
                    System.out.print("("+resultado+")");
                    System.out.println(lexico.lexema+ "-> Lexema");
                }
                if(Tokens.ERROR==resultado){
                    System.out.println("Línea "+lexico.getYyline() +
                            " Columna "+lexico.getYycolumn());
                }

            }while(Tokens.ERROR!=resultado);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
