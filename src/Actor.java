import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Actor extends Persona{
    private double peso;
    private double altura;
    private Raza raza;

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

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

    @Override
    public String toString() {

        return
                super.toString()+
                "peso = " + peso +
                ", altura = " + altura +
                ", raza = " + raza;
    }
}
