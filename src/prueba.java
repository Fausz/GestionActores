import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

import java.text.SimpleDateFormat;



public class prueba {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {

        long e = calcularEdad();
        System.out.println(e);

    }

    public static long calcularEdad(){
        LocalDate fNacimiento;
        fNacimiento = LocalDate.of(1992, 11, 14);
        //LocalDate fActual = LocalDate.now();
       return ChronoUnit.YEARS.between(fNacimiento, LocalDate.now());
        /*System.out.println("Tu edad es de " +
                ChronoUnit.YEARS.between(fNacimiento, LocalDate.now())
                + " años."
        );*/

    }
}





