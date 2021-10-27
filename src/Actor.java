import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public abstract class Actor extends Persona{
    double peso;
    double altura;
    Raza raza;

    public Actor(double peso, double altura, Raza raza) {
        this.peso = peso;
        this.altura = altura;
        this.raza = raza;
    }

    public Actor(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza) {
        super(dni, nombre, fechaNacimiento, domicilio, sexo, telefono);
        this.peso = peso;
        this.altura = altura;
        this.raza = raza;
    }

    public abstract double calcularSueldo();
    public long calcularEdad(){
        LocalDate fNacimiento;
        fNacimiento = LocalDate.of(getFechaNacimiento().getAño(), getFechaNacimiento().getMes(), getFechaNacimiento().getDia());
        //LocalDate fActual = LocalDate.now();
        long edad = ChronoUnit.YEARS.between(fNacimiento, LocalDate.now());
        /*System.out.println("Tu edad es de " +
                ChronoUnit.YEARS.between(fNacimiento, LocalDate.now())
                + " años."
        );*/
        return edad;
    }
}
