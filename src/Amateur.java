public class Amateur extends Actor implements Contratable{

    private double importeHora;
    private int numeroHoras;
    private double sueldo;

    public Amateur(double peso, double altura, Raza raza, double importeHora, int numeroHoras) {
        super(peso, altura, raza);
        this.importeHora = importeHora;
        this.numeroHoras = numeroHoras;
    }

    public Amateur(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza, double importeHora, int numeroHoras) {
        super(dni, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
        this.importeHora = importeHora;
        this.numeroHoras = numeroHoras;
        this.sueldo = calcularSueldo();
    }

    @Override
    public double calcularSueldo() {
        //El salario de un actor amateur se calcula multiplicando el importe de la hora por el número de
        //horas. Si es menor de edad tienen un incremento de sueldo del 10% sobre el sueldo calculado
        //si han trabajado más de 40 horas.
        double sueldo = importeHora*numeroHoras;
        return sueldo;
    }

    public Amateur(double peso, double altura, Raza raza) {
        super(peso, altura, raza);
    }

    public Amateur(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza) {
        super(dni, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
    }

    @Override
    public long calcularEdad() {
        long edad = super.calcularEdad();
        return edad;
    }

    @Override
    public String getDni() {
        return super.getDni();
    }

    @Override
    public void setDni(String dni) {
        super.setDni(dni);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public Fecha getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    @Override
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento);
    }

    @Override
    public Direccion getDomicilio() {
        return super.getDomicilio();
    }

    @Override
    public void setDomicilio(Direccion domicilio) {
        super.setDomicilio(domicilio);
    }

    @Override
    public Genero getSexo() {
        return super.getSexo();
    }

    @Override
    public void setSexo(Genero sexo) {
        super.setSexo(sexo);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    public double getImporteHora() {
        return importeHora;
    }

    public void setImporteHora(double importeHora) {
        this.importeHora = importeHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String toStringListadoYSueldo() {
        return "Actor tipo: Amateur, nombre: " + super.getNombre() + ", sueldo: " + sueldo ;
    }

    @Override
    public String toString() {
        return
                super.toString()+
                " tipo = AMATEUR, " +
                "peso = " + getPeso() +
                ", altura = " + getAltura() +
                ", raza = " + getRaza() +
                ", importeHora = " + importeHora +
                ", numeroHoras = " + numeroHoras +
                ", sueldo = " + sueldo;
    }
}
