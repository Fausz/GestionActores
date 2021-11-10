import java.util.Scanner;

public class Perro implements Contratable{

    private String nombrePerro;
    private String nombreDueño;
    private double sueldo;
    private int edad;

    public Perro() {
    }

    public Perro(String nombrePerro, String nombreDueño, double sueldo, int edad) {
        this.nombrePerro = nombrePerro;
        this.nombreDueño = nombreDueño;
        this.sueldo = sueldo;
        this.edad = edad;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombrePerro='" + nombrePerro + '\'' +
                ", nombreDueño='" + nombreDueño + '\'' +
                ", sueldo=" + sueldo +
                ", edad=" + edad +
                '}';
    }
    public String toStringListadoYSueldo() {
        return "Actor tipo: Perro, nombre: " +nombrePerro+", sueldo: " + sueldo;
    }

    @Override
    public double calcularSueldo() {
        return sueldo;
    }
}
