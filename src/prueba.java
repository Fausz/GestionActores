import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

import java.text.SimpleDateFormat;



public class prueba {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {

        char c = introducirLetra();
        System.out.println(c);

    }

    private static char introducirLetra(){
        String letra;
        do{
            System.out.println("Introduce la letra del piso: ");
            letra=sc.nextLine();
        }while(!comprobarCharLetra(letra));
        char c = letra.charAt(0);
        return c;
    }

    private static boolean comprobarCharLetra(String letra){
        char c = letra.charAt(0);
        if(Character.isLetter(c) && letra.length()==1){
            return true;
        }else{
            return false;
        }
    }
    private static boolean comprobarChar(String texto){
        if(texto.length()>1){
            return false;
        }else{
            return true;
        }
    }





}