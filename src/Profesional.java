public class Profesional extends Actor{

    private double sueldoBase;
    private double precioPorRepresentacion;
    private int numeroDeRepresentaciones;


    public Profesional(double peso, double altura, Raza raza, double sueldoBase, double precioPorRepresentacion, int numeroDeRepresentaciones) {
        super(peso, altura, raza);
        this.sueldoBase = sueldoBase;
        this.precioPorRepresentacion = precioPorRepresentacion;
        this.numeroDeRepresentaciones = numeroDeRepresentaciones;
    }

    public Profesional(String nif, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza, double sueldoBase, double precioPorRepresentacion, int numeroDeRepresentaciones) {
        super(nif, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
        this.sueldoBase = sueldoBase;
        this.precioPorRepresentacion = precioPorRepresentacion;
        this.numeroDeRepresentaciones = numeroDeRepresentaciones;
    }

    @Override
    public double calcularSueldo() {
        //Además los actores de más de 50 años
        //tienen un incremento de sueldo del 20% sobre el sueldo calculado.
        double sueldo=(precioPorRepresentacion*numeroDeRepresentaciones)+sueldoBase;

        return sueldo;
    }
}
