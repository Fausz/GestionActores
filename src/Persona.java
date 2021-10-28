public abstract class Persona {

    private String dni;
    private String nombre;
    private Fecha fechaNacimiento;
    private Direccion domicilio;
    private Genero sexo;
    private String telefono;

    public Persona() {
    }

    public Persona(String dni, String nombre, Fecha fechaNacimiento, Direccion domicilio, Genero sexo, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.sexo = sexo;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {

        return
                "dni = '" + dni + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", fechaNacimiento = " + fechaNacimiento +
                ", domicilio = " + domicilio +
                ", sexo = " + sexo +
                ", telefono = '" + telefono + '\'';
    }
}
