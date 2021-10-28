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



    public Profesional(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza, double sueldoBase, double precioPorRepresentacion, int numeroDeRepresentaciones) {
        super(dni, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
        this.sueldoBase = sueldoBase;
        this.precioPorRepresentacion = precioPorRepresentacion;
        this.numeroDeRepresentaciones = numeroDeRepresentaciones;
    }

    public Profesional(double peso, double altura, Raza raza) {
        super(peso, altura, raza);
    }

    public Profesional(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono, double peso, double altura, Raza raza) {
        super(dni, nombre, fechaNacimiento, domicilio, sexo, telefono, peso, altura, raza);
    }

    @Override
    public long calcularEdad() {
        long edad =super.calcularEdad();
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

    @Override
    public double calcularSueldo() {
        //Además los actores de más de 50 años
        //tienen un incremento de sueldo del 20% sobre el sueldo calculado.

        double sueldo=(precioPorRepresentacion*numeroDeRepresentaciones)+sueldoBase;
        if(calcularEdad()>50){
            sueldo= sueldo + (sueldo*20)/100;
        }

        return sueldo;
    }


    public String toStringListadoYSueldo() {
        return "Actor tipo: Profesional, nombre: " + super.getNombre()+", sueldo: " + calcularSueldo();
    }

    @Override
    public String toString() {
        return
                super.toString()+
                ", tipo = PROFESIONAL" +
                "sueldoBase = " + sueldoBase +
                ", precioPorRepresentacion = " + precioPorRepresentacion +
                ", numeroDeRepresentaciones = " + numeroDeRepresentaciones;
    }
}
