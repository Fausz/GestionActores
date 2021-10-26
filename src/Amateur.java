public class Amateur extends Actor{

    private double importeHora;
    private int numeroHoras;


    public Amateur(double peso, double altura, Raza raza, double importeHora, int numeroHoras) {
        super(peso, altura, raza);
        this.importeHora = importeHora;
        this.numeroHoras = numeroHoras;
    }

    public Amateur(String nif, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza, double importeHora, int numeroHoras) {
        super(nif, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
        this.importeHora = importeHora;
        this.numeroHoras = numeroHoras;
    }

    @Override
    public double calcularSueldo() {
        //El salario de un actor amateur se calcula multiplicando el importe de la hora por el número de
        //horas. Si es menor de edad tienen un incremento de sueldo del 10% sobre el sueldo calculado
        //si han trabajado más de 40 horas.
        double salario=importeHora*numeroHoras;

        return salario;
    }
}
