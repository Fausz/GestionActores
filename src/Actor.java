public abstract class Actor extends Persona{
    double peso;
    double altura;
    Raza raza;

    public Actor(double peso, double altura, Raza raza) {
        this.peso = peso;
        this.altura = altura;
        this.raza = raza;
    }

    public Actor(String nif, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza) {
        super(nif, nombre, fechaNacimiento, domicilio, sexo, telefono);
        this.peso = peso;
        this.altura = altura;
        this.raza = raza;
    }

    public abstract double calcularSueldo();
    public void calcularEdad(){

    }
}
