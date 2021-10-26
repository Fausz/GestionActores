public class Direccion {

    private String nombreCalle;
    private int numero;
    private int piso;
    private char letra;
    private int codigoPostal;
    private String poblacion;
    private String provincia;
    private String pais;

    public Direccion() {
    }

    public Direccion(String nombreCalle, int numero, int piso, char letra, int codigoPostal, String poblacion, String provincia, String pais) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
        this.codigoPostal = codigoPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "nombreCalle='" + nombreCalle + '\'' +
                ", numero=" + numero +
                ", piso=" + piso +
                ", letra=" + letra +
                ", codigoPostal=" + codigoPostal +
                ", poblacion='" + poblacion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
