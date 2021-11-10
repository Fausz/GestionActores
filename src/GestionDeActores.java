import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.text.ParseException;

import java.text.SimpleDateFormat;

public class GestionDeActores {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contratable> lista = new ArrayList<>();

    public static void main(String[] args) {

        lista.add(actorAmateurPorDefecto());
        lista.add(actorProfesionalPorDefecto());
        lista.add(perroPorDefecto());

        boolean salir = false;
        do {
            salir = menu();
        } while (!salir);
    }

    public static boolean menu() {
        mostrarMenu();
        int opcion = introducirNumeroEntero();
        boolean salir = seleccionMenu(opcion);
        return salir;
    }

    private static boolean seleccionMenu(int opcion) {
        Actor a;
        switch (opcion) {
            case 0:
                System.out.println("Fin del programa.");
                return true;
            case 1:
                menuCrearActor();
                break;
            case 2:
                menuEliminarActor();
                break;
            case 3:
                cambioTipoAmateurAProfesional();
                break;
            case 4:
                cambiarHorasAmateur();
                break;
            case 5:
                aumentarRepresentacionesAProfesional();
                break;
            case 6:
                mostrarActoresPorNombreTipoYSueldo();
                break;
            case 7:
                mostrarActoresMenoresDeEdad();
                break;
            case 8:
                mostrarActoresMayoresDeEdad();
                break;
            case 9:
                mostrarActoresPorRaza();
                break;
            case 10:
                mostrarActoresSuperioresAUnaAltura();
                break;
            case 11:
                mostrarActoresSuperioresAUnPeso();
                break;
            case 12:
                mostrarActorQueMasCobra();
                break;
            case 13:
                mostrarActoresPorOrdenAlfabetico();
                break;
            case 14:
                listadoAlfabeticoDePerros();
                break;
            default:
                System.err.println("Has introducido un valor no valido.");
        }
        return false;
    }

    public static void listadoAlfabeticoDePerros() {
        System.out.println("\n------Opcion de mostrar Perros por orden alfabetico----------");
        Contratable aux;

        System.out.println();
        if (lista.isEmpty()) {
            System.out.println("No hay Actores");
        } else {

            ArrayList<Contratable> Lista = new ArrayList<Contratable>();//se crea un ArrayList nuevo para ordenar solo los Actores

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) instanceof Perro) {//solo se introducen perros
                    Lista.add(lista.get(i));
                }
            }
            if (Lista.isEmpty()) {
                System.out.println("Solo hay Personas en la Lista de Actores");

            } else {

                //se ordena el ArrayList Lista
                for (int i = 0; i < Lista.size() - 1; i++) {
                    for (int j = 0; j < Lista.size() - i - 1; j++) {
                        if ((((Perro) (Lista.get(j + 1))).getNombrePerro()).compareToIgnoreCase(((Perro) (Lista.get(j))).getNombrePerro()) < 0) {
                            aux = Lista.get(j + 1);
                            Lista.set(j + 1, Lista.get(j));
                            Lista.set(j, aux);
                        }
                    }
                }
                //se muestra el ArrayList Lista
                for (int i = 0; i < Lista.size(); i++) {
                    System.out.println(((Perro) Lista.get(i)).getNombrePerro() + " Sueldo: " + Lista.get(i).calcularSueldo());
                }
                System.out.println("--------------------\n");
            }
        }
    }

    private static void mostrarActoresPorOrdenAlfabetico() {
        System.out.println("\n------Opcion de mostrar Actores por orden alfabetico----------");
        ArrayList<Contratable> ActoresOrdenados = new ArrayList<Contratable>();//se crea un ArrayList nuevo para ordenar solo los Actores

        Contratable aux;

        System.out.println();
        //si no hay actores se muestra que no hay
        if (lista.isEmpty()) {
            System.out.println("No hay Actores");

        } else {
            //si hay actores que no sean de tipo perro se guardan en el nuevo array
            for (int i = 0; i < lista.size(); i++) {
                if (!(lista.get(i) instanceof Perro)) {//se buscan Actores en el ArrayList
                    ActoresOrdenados.add(lista.get(i));//se guardan los Actores en el ArrayList
                }
            }
            //si solo hay perros guardados en el nuevo array se dice que solo hay perros y no personas
            if (ActoresOrdenados.isEmpty()) {
                System.out.println("Solo hay perros en la lista de Actores");

            } else {
                //si hay actores se procede a ordenar el array
                //se ordena el ArrayList Lista
                for (int i = 0; i < ActoresOrdenados.size() - 1; i++) {
                    for (int j = 0; j < ActoresOrdenados.size() - i - 1; j++) {
                        if ((((Actor) (ActoresOrdenados.get(j + 1))).getNombre()).compareToIgnoreCase(((Actor) (ActoresOrdenados.get(j))).getNombre()) < 0) {
                            aux = (Contratable) ActoresOrdenados.get(j + 1);
                            ActoresOrdenados.set(j + 1, ActoresOrdenados.get(j));
                            ActoresOrdenados.set(j, aux);
                        }
                    }
                }
                //se muestra el ArrayList
                for (int i = 0; i < ActoresOrdenados.size(); i++) {
                    System.out.println(((Actor) ActoresOrdenados.get(i)).getNombre() + " Sueldo: " + ActoresOrdenados.get(i).calcularSueldo());
                }
                System.out.println("--------------------\n");

            }
        }
    }

    private static double introducirSueldoPerro(){
        double sueldoPerro;
        do {
            System.out.println("Introduce el sueldo del Perro: ");
            try {
                sueldoPerro = sc.nextDouble();
            }catch (Exception e){
                sc.nextLine();
                System.err.println("El valor introducido no es valido.");
                sueldoPerro=-1;
            }
        }while(sueldoPerro<0);
        return sueldoPerro;
    }

    private static void mostrarActorQueMasCobra() {
        double sueldo = 0;
        Actor actor = null;
        Perro p = null;
        boolean persona = true;
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            for (Contratable a : lista) {
                if (a.calcularSueldo() > sueldo) {
                    sueldo = a.calcularSueldo();
                    if (a instanceof Amateur || a instanceof Profesional) {
                        actor = (Actor) a;
                        persona = true;
                    } else {
                        p = (Perro) a;
                        persona = false;
                    }
                }
            }
            if (persona) {
                System.out.println("\nEl Actor que más cobra es: " + actor.toString());
            } else {
                System.out.println("\nEl Actor que más cobra es el: " + p.toString());
            }
        }
    }

    private static void mostrarActoresSuperioresAUnPeso() {
        double peso = introducirPeso();
        System.out.println("\nActores superiores al peso seleccionado (" + peso + "): \n---------------------------------------");
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            for (Contratable a : lista) {
                if (a instanceof Amateur || a instanceof Profesional) {
                    if (((Actor) a).getPeso() >= peso) {
                        System.out.println(a.toString());
                    }
                }
            }
        }
    }

    private static void mostrarActoresSuperioresAUnaAltura() {
        double altura = introducirAltura();
        System.out.println("\nActores superiores a la altura seleccionada (" + altura + "):\n---------------------------------------");
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            for (Contratable a : lista) {
                if (a instanceof Amateur || a instanceof Profesional) {
                    if (((Actor) a).getAltura() >= altura) {
                        System.out.println(a.toString());
                    }
                }
            }
        }
    }


    private static void mostrarActoresPorRaza() {
        System.out.println("\n------Opcion de mostrar Actores por Raza----------");
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            Raza raza;
            raza = introducirRaza();
            elegirTipoRaza(raza);
        }
    }

    private static void elegirTipoRaza(Raza r) {
        System.out.println("\n----Listado de raza de tipo: " + r.toString() + "--------");
        switch (r) {
            case HISPANO:
                mostrarActoresPorSuRaza(Raza.HISPANO);
                break;
            case ABORIGEN:
                mostrarActoresPorSuRaza(Raza.ABORIGEN);
                break;
            case CAUCASICO:
                mostrarActoresPorSuRaza(Raza.CAUCASICO);
                break;
            case NEGRO:
                mostrarActoresPorSuRaza(Raza.NEGRO);
                break;
            case ORIENTAL:
                mostrarActoresPorSuRaza(Raza.ORIENTAL);
                break;
        }
    }

    private static void mostrarActoresPorSuRaza(Raza r) {
        if (lista.isEmpty()) {
            System.out.println("No hay ningun Actor en la lista.");
        } else {
            ArrayList<Contratable> nuevaLista = new ArrayList<>();
            for (Contratable a : lista) {
                if (a instanceof Amateur || a instanceof Profesional) {
                    if (((Actor) a).getRaza().toString().equals(r.toString())) {
                        nuevaLista.add(a);
                    }
                }
            }
            if (nuevaLista.isEmpty()) {
                System.out.println("No hay ningun actor de la raza " + r.toString());

            } else {
                for (Contratable c : nuevaLista) {
                    if (c instanceof Amateur || c instanceof Profesional) {
                        if (((Actor) c).getRaza().toString().equals(r.toString())) {
                            System.out.println(c.toString());
                        }
                    }
                }
            }
        }
    }

    private static void mostrarActoresMayoresDeEdad() {
        System.out.println("\n------Opcion de mostrar Actores mayores de edad----------");
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            for (Contratable a : lista) {
                if (a instanceof Amateur || a instanceof Profesional) {
                    if (((Actor) a).calcularEdad() >= 18) {
                        System.out.println(a.toString());
                    }
                }
            }
        }
    }

    private static void mostrarActoresMenoresDeEdad() {
        System.out.println("\n------Opcion de mostrar Actores menores de edad----------");
        if (lista.isEmpty()) {
            System.out.println("No hay actores en la lista.");
        } else {
            for (Contratable a : lista) {
                if (a instanceof Amateur || a instanceof Profesional) {
                    if (((Actor) a).calcularEdad() < 18) {
                        System.out.println(a.toString());
                    }
                }
            }
        }
    }

    private static void aumentarRepresentacionesAProfesional() {
        sc.nextLine();
        boolean encontrado;
        boolean salir = false;
        String dni;
        System.out.println("\n------Opcion de aumentar representaciones de un Actor de tipo Profesional----------");
        do {
            mostrarActoresProfesionales();
            dni = introducirDni();
            if (dni.equals("0")) {
                salir = true;
            }
            encontrado = comprobarDNIEnLista(dni);
        } while (!encontrado && !salir);
        if (!salir) {
            Actor a = obtenerActor(dni);
            if (a instanceof Profesional) {
                System.out.println("El numero de representaciones actuales es de: " + ((Profesional) a).getNumeroDeRepresentaciones());
            }
            int representaciones = introducirNumeroDeRepresentaciones();
            sc.nextLine();
            if (a instanceof Profesional) {
                ((Profesional) a).setNumeroDeRepresentaciones(representaciones);
            }

            boolean confirmar = confirmarAccion();
            if (confirmar) {
                lista.remove(a);
                lista.add((Contratable) a);
                System.out.println("Se han cambiado el numero de representaciones de un Actor Profesional.");
            } else {
                System.out.println("No se han cambiado el numero de representaciones de un Actor Profesional.");
            }
        } else {
            System.out.println("No se han cambiado el numero de representaciones de un Actor Profesional.");
        }
    }

    private static void cambiarHorasAmateur() {
        sc.nextLine();
        boolean encontrado;
        boolean salir = false;
        String dni;
        System.out.println("\n------Opcion de cambio de horas de un Actor de tipo Amateur ----------");
        do {
            mostrarActoresAmateur();
            dni = introducirDni();
            if (dni.equals("0")) {
                salir = true;
            }
            encontrado = comprobarDNIEnLista(dni);

        } while (!encontrado && !salir);
        if (!salir) {
            Actor a = obtenerActor(dni);
            if (a instanceof Amateur) {
                System.out.println("El numero de horas actuales es de: " + ((Amateur) a).getNumeroHoras());
            }
            int horas = introducirNumeroHoras();
            sc.nextLine();
            if (a instanceof Amateur) {
                ((Amateur) a).setNumeroHoras(horas);
            }
            boolean confirmar = confirmarAccion();
            if (confirmar) {
                lista.remove(a);
                lista.add((Contratable) a);
                System.out.println("Se han cambiado las horas que interpreta un Actor Amateur.");
            } else {
                System.out.println("No se han cambiado las horas que interpreta un Actor Amateur.");
            }
        } else {
            System.out.println("No se han cambiado las horas que interpreta un Actor Amateur.");
        }
    }

    private static void mostrarActoresAmateur() {
        for (Contratable a : lista) {
            if (a instanceof Amateur) {
                System.out.println(a.toString());
            }
        }
    }

    private static void mostrarActoresProfesionales() {
        for (Contratable a : lista) {
            if (a instanceof Profesional) {
                System.out.println(a.toString());
            }
        }
    }

    private static void cambioTipoAmateurAProfesional() {
        sc.nextLine();
        boolean encontrado;
        boolean salir = false;
        String dni;
        System.out.println("\n------Opcion de cambio de Actor de tipo Amateur a Profesional----------");
        do {
            mostrarActoresAmateur();
            dni = introducirDni();
            if (dni.equals("0")) {
                salir = true;
            }
            encontrado = comprobarDNIEnLista(dni);

        } while (!encontrado && !salir);
        if (!salir) {
            Actor a = obtenerActor(dni);
            Actor cambio = cambiarTipo(a);
            System.out.println("Datos antiguos:\n" + a.toString() + "\n");
            System.out.println("Datos nuevos: \n" + cambio.toString() + "\n");
            boolean confirmacion = confirmarAccion();
            if (confirmacion) {
                lista.remove(a);
                lista.add((Contratable) cambio);
                System.out.println("Se ha realizado el cambio correctamente.");
            } else {
                System.out.println("No se ha realizado ningun cambio.");
            }
        } else {
            System.out.println("No se ha realizado ningun cambio.");
        }
    }

    private static Profesional cambiarTipo(Actor a) {
        mostrarActoresAmateur();
        String dni = a.getDni();
        String nombre = a.getNombre();
        Fecha f = a.getFechaNacimiento();
        Direccion d = a.getDomicilio();
        Genero g = a.getSexo();
        String telefono = a.getTelefono();
        double peso = a.getPeso();
        double altura = a.getAltura();
        Raza r = a.getRaza();
        double sueldoBase = introducirSueldoBase();
        double precioPorRepresentacion = introducirPrecioPorRepresentacion();
        int numeroRepresentaciones = introducirNumeroDeRepresentaciones();
        sc.nextLine();
        return new Profesional(dni, nombre, f, d, g, telefono, peso, altura, r, sueldoBase, precioPorRepresentacion, numeroRepresentaciones);
    }

    private static void menuCrearActor() {
        System.out.println("\n------Opcion de Añadir Actores----------");
        boolean salirMenuCrear = false;
        do {
            mostrarMenuEleccionActor();
            int opcion = introducirNumeroEntero();
            salirMenuCrear = menuOpcionCrearActor(opcion);
        } while (!salirMenuCrear);

    }

    private static void menuEliminarActor() {
        System.out.println("\n------Opcion de Eliminar Actores----------");
        boolean salirMenuEliminar = false;
        do {
            mostrarMenuEleccionActor();
            int opcion = introducirNumeroEntero();
            salirMenuEliminar = menuOpcionEliminarActor(opcion);
        } while (!salirMenuEliminar);

    }

    private static boolean menuOpcionCrearActor(int opcion) {
        switch (opcion) {
            case 0:
                return true;
            case 1:
                crearActor();
                break;
            case 2:
                crearPerro();
                break;
            default:
                System.out.println("Opcion fuera de rango.");
        }
        return false;
    }

    private static boolean menuOpcionEliminarActor(int opcion) {
        switch (opcion) {
            case 0:
                return true;
            case 1:
                eliminarActor();
                break;
            case 2:
                eliminarActorPerro();
                break;
            default:
                System.out.println("Opcion fuera de rango.");
        }
        return false;
    }

    private static void eliminarActorPerro(){
        sc.nextLine();
        boolean encontrado;
        boolean salir = false;
        String nombrePerro;
        do {
            System.out.println("\nListado de Perros:\n-----------------");
            mostrarTodosPerros();
            nombrePerro = introducirNombrePerro();
            if (nombrePerro.equals("0")) {
                salir = true;
            }
            encontrado = comprobarNombrePerroEnLista(nombrePerro);
        } while (!encontrado && !salir);
        if (!salir) {
            Perro p = obtenerPerro(nombrePerro);
            boolean confirmacion = confirmarAccion();
            if (confirmacion && p != null) {
                lista.remove(p);
                System.out.println("Se ha eliminado el perro de la lista.");
            } else {
                System.out.println("No se ha eliminado el perro");
            }
        } else {
            System.out.println("No se ha eliminado el perro");
        }
    }

    private static void mostrarTodosPerros(){
        if(lista.isEmpty()){
            System.out.println("La lista está vacia.");
        }else {
            ArrayList<Perro> listaPerros = new ArrayList<>();
            for (Contratable p : lista) {
                if (p instanceof Perro) {
                    listaPerros.add((Perro) p);
                }
            }
            if(listaPerros.isEmpty()){
                System.out.println("No hay perros en la lista");
            }else{
                for(Perro perro : listaPerros){
                    System.out.println(perro.toString());
                }
            }
        }
    }

    private static void eliminarActor() {
        sc.nextLine();
        boolean encontrado;
        boolean salir = false;
        String dni;
        do {
            mostrarTodosActores();
            dni = introducirDni();
            if (dni.equals("0")) {
                salir = true;
            }
            encontrado = comprobarDNIEnLista(dni);
        } while (!encontrado && !salir);
        if (!salir) {
            Actor a = obtenerActor(dni);
            boolean confirmacion = confirmarAccion();
            if (confirmacion && a != null) {
                lista.remove(a);
                System.out.println("Se ha eliminado el actor de la lista.");
            } else {
                System.out.println("No se ha eliminado el actor");
            }
        } else {
            System.out.println("No se ha eliminado el actor");
        }
    }

    private static void mostrarMenuEleccionActor(){
        System.out.println("\nSelecciona el tipo de Actor:\n-------------------- ");
        System.out.println("0 - Salir");
        System.out.println("1 - Persona");
        System.out.println("2 - Perro");
    }

    private static Actor obtenerActor(String dni){
        Actor actor=null;
        for(Contratable a : lista) {
            if (a instanceof Amateur || a instanceof Profesional) {
                if (((Actor) a).getDni().equals(dni)) {
                    actor = (Actor) a;
                    break;
                }
            }
        }
        return actor;
    }

    private static Perro obtenerPerro(String nombrePerro){
        Perro p=null;
        for(Contratable a : lista) {
            if (a instanceof Perro) {
                if (((Perro) a).getNombrePerro().equals(nombrePerro)) {
                    p = (Perro) a;
                    break;
                }
            }
        }
        return p;
    }

    private static String introducirDni(){
        String dni;
        do {
            System.out.println("Introduce el DNI del Actor (0 para salir): ");
            dni = sc.nextLine();
        }while(!validar(dni) && !dni.equals("0"));
        return dni;
    }

    private static String introducirNombrePerro(){
        String nombrePerro;

        System.out.println("Introduce el nombre del Perro (0 para salir): ");
        nombrePerro = sc.nextLine().toUpperCase();
        return nombrePerro;
    }

    private static boolean comprobarNombrePerroEnLista(String nombrePerro){
        boolean encontrado=false;
        if(lista.isEmpty()){
            return false;
        }else {
            ArrayList<Contratable> listaPerros = new ArrayList<>();
            for (Contratable p : lista) {
                if(p instanceof Perro) {
                        listaPerros.add(p);
                    }
                }
            if(listaPerros.isEmpty()) {
                System.out.println("No hay ningun perro en la lista.");
            }else{
                for (Contratable lp : listaPerros) {
                    if (lp instanceof Perro) {
                        if (((Perro) lp).getNombrePerro().equals(nombrePerro)) {
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
        }

        if (!encontrado) {
                System.out.println("No se ha encontrado el nombre del perro en la lista.");
        }
        return encontrado;
    }

    private static boolean comprobarDNIEnLista(String dni){
        boolean encontrado=false;
        if(lista.isEmpty()){
            return false;
        }else {
            for (Contratable p : lista) {
                if(p instanceof Amateur || p instanceof Profesional) {
                    if (((Actor) p).getDni().equals(dni)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            return encontrado;
        }
    }

    private static void mostrarActoresPorNombreTipoYSueldo(){
        System.out.println("\n------Opcion de mostrar Actores por nombre, tipo y sueldo----------");
        if(lista.isEmpty()){
            System.out.println("No hay Actores en la lista.");
        }else {
            for (Contratable p : lista) {
                if (p instanceof Amateur) {
                    System.out.println(((Amateur) p).toStringListadoYSueldo());
                } else if (p instanceof Profesional) {
                    System.out.println(((Profesional) p).toStringListadoYSueldo());
                }else{
                    System.out.println(((Perro) p).toStringListadoYSueldo());
                }
            }
        }
    }

    private static void crearPerro() {
        sc.nextLine();
        Perro p = new Perro();
        String nombrePerro = "";
        String nombreDueño = "";
        double sueldo = 0;
        int edad = 0;
        boolean cancelarCreacion;

        nombrePerro = introducirNombrePerro();
        if (nombrePerro.equals("0")) {
            System.out.println("No se ha añadido el Perro.");
        } else {
            nombreDueño=introducirNombreDueñoPero();
            sueldo = introducirSueldoPerro();
            edad = introducirEdadPerro();
            sc.nextLine();
            cancelarCreacion = confirmarAccion();
            if (!cancelarCreacion) {
                System.out.println("No se ha añadido el Perro.");
            } else {
                p = new Perro(nombrePerro, nombreDueño, sueldo, edad);
                System.out.println(p.toString());
                lista.add((Contratable) p);
                System.out.println("Se ha añadido el perro a la lista.");
            }
        }
    }

    private static int introducirEdadPerro(){
        int edad;
        do{
            System.out.println("Introduce la edad del Perro: ");
            edad=introducirNumeroEntero();
        }while (!comprobarEdadPerro(edad));
        return edad;
    }

    private static boolean comprobarEdadPerro(int edad){
        if(edad>=30) {
            System.out.println("Tiempo de vida demasiado alto para un perro.");
            return false;
        }else if(edad<=0){
            System.out.println("El perro aun no ha nacido.");
            return false;
        }else{
            return true;
        }
    }

    private static String introducirNombreDueñoPero(){
        String nombreDueño;
        do{
            System.out.println("Introduce el nombre del Dueño del Perro: ");
            nombreDueño = sc.nextLine();
        }while(!comprobarTexto(nombreDueño));
        return nombreDueño;
    }

    private static void crearActor() {
        boolean salir = false;
        int tipo;
        Actor a;
        do {
            mostrarMenuTipoActor();
            tipo=introducirNumeroEntero();
        }while(!comprobarTipoActor(tipo));
        a = seleccionarOpcionCrearActor(tipo);
        if(a==null){
            System.out.println("No se ha añadido el Actor.");
        }else {
            System.out.println(a.toString());
            lista.add((Contratable) a);
            System.out.println("Se ha añadido el actor a la lista.");
        }
    }

    private static Actor seleccionarOpcionCrearActor(int tipo) {
        Actor a=null;
        switch (tipo){
            case 0:
                System.out.println("Cancelar creacion de actor.");
                break;
            case 1:
                sc.nextLine();
                System.out.println("Creación de Actor Amateur\n--------------------");
                a = crearAmateur();
                break;
            case 2:
                sc.nextLine();
                System.out.println("Crear profesional\n--------------------");
                a = crearProfesional();
                break;
        }
        return a;
    }

    private static Profesional crearProfesional(){
        boolean cancelarCreacion=false;
        boolean continuarCreacion=true;
        Profesional p = null;
        String dni;
        String nombre;
        Fecha fechaNacimiento;
        Direccion domicilio;
        Genero sexo;
        String telefono;
        double peso=0;
        double altura=0;
        Raza raza=Raza.HISPANO;
        double sueldoBase=0;
        double precioPorRepresentacion=0;
        int numeroDeRepresentaciones=0;
        do {
            //Datos de Persona
            boolean dniCorrecto = true;
            do {
                dni = introducirDni();
                if(dni.equals("0")){
                    return p=null;
                }
                if (comprobarDNIEnLista(dni)) {
                    System.out.println("Este DNI ya está registrado.");
                    dniCorrecto = false;
                }
            }while(!dniCorrecto);
            nombre = introducirNombre();
            fechaNacimiento = introducirFecha();
            domicilio = introducirDomicilio();
            sexo = introducirGenero();
            telefono = introducirTelefono();
            if (continuarCreacion = continuarCreacion()) {
                //Datos de Actor
                peso = introducirPeso();
                altura = introducirAltura();
                raza = introducirRaza();
                //Datos de Amateur
                sueldoBase = introducirSueldoBase();
                precioPorRepresentacion = introducirPrecioPorRepresentacion();
                numeroDeRepresentaciones = introducirNumeroDeRepresentaciones();
                sc.nextLine();
            }
            cancelarCreacion = confirmarAccion();
        }while(!continuarCreacion && !cancelarCreacion);
        if(cancelarCreacion){
            p=null;
            return p;
        }
        return new Profesional(dni,nombre,fechaNacimiento,domicilio,sexo,telefono,peso,altura,raza,sueldoBase,precioPorRepresentacion,numeroDeRepresentaciones);
    }

    private static int introducirNumeroDeRepresentaciones(){
        int numeroDeRepresentaciones;
        do{
            System.out.println("Introduce el numero de representaciones del Actor Profesional: ");
            numeroDeRepresentaciones = introducirNumeroEntero();
        }while(!comprobarNumeroEnteroPositivo(numeroDeRepresentaciones));
        return numeroDeRepresentaciones;
    }

    private static double introducirPrecioPorRepresentacion(){
        double precioPorRepresentacion;
        do{
            System.out.println("Introduce el precio de representacion del Actor Profesional: ");
            precioPorRepresentacion = sc.nextDouble();
        }while(!comprobarSueldoBase(precioPorRepresentacion));
        return precioPorRepresentacion;
    }

    private static double introducirSueldoBase(){
        double sueldoBase;
        do{
            System.out.println("Introduce el sueldo base del Actor Profesional: ");
            sueldoBase = sc.nextDouble();
        }while(!comprobarSueldoBase(sueldoBase));
        return sueldoBase;
    }

    private static boolean comprobarSueldoBase(double sueldoBase){
        if(sueldoBase<0){
            System.out.println("No puedes cobrar en negativo.");
            return false;
        }else{
            return true;
        }
    }

    private static Amateur crearAmateur(){
        boolean cancelarCreacion=false;
        boolean continuarCreacion=true;
        Amateur a = null;
        String dni;
        String nombre;
        Fecha fechaNacimiento;
        Direccion domicilio;
        Genero sexo;
        String telefono;
        double peso=0;
        double altura=0;
        Raza raza=Raza.HISPANO;
        double importeHora=50;
        int numeroHoras=10;
        do {
            //Datos de Persona
            boolean dniCorrecto = true;
            do {
                dni = introducirDni();
                if(dni.equals("0")){
                    return a=null;
                }
                if (comprobarDNIEnLista(dni)) {
                    System.out.println("Este DNI ya está registrado.");
                    dniCorrecto = false;
                }
            }while(!dniCorrecto);
            nombre = introducirNombre();
            fechaNacimiento = introducirFecha();
            domicilio = introducirDomicilio();
            sexo = introducirGenero();
            telefono = introducirTelefono();
            if (continuarCreacion = continuarCreacion()) {
                //Datos de Actor
                peso = introducirPeso();
                altura = introducirAltura();
                raza = introducirRaza();
                //Datos de Amateur
                importeHora = introducirImporteHora();
                numeroHoras = introducirNumeroHoras();
                sc.nextLine();
            }
            cancelarCreacion = confirmarAccion();
        }while(!continuarCreacion && !cancelarCreacion);
        if(cancelarCreacion){
            a=null;
            return a;
        }
        return new Amateur(dni,nombre,fechaNacimiento,domicilio,sexo,telefono,peso,altura,raza,importeHora,numeroHoras);
    }

    private static int introducirNumeroHoras(){
        int numeroHoras;
        do{
            System.out.println("Introduce el numero de horas del Actor Amateur: ");
            numeroHoras = sc.nextInt();
        }while (!comprobarNumeroEnteroPositivo(numeroHoras));
        return numeroHoras;
    }

    private static double introducirImporteHora(){
        double importeHora;
        do{
            System.out.println("Introduce el importe por hora del Actor Amateur: ");
            importeHora = sc.nextDouble();
        }while (!comprobarImporteHora(importeHora));
        return importeHora;
    }

    private static boolean comprobarImporteHora(double importeHora){
        if(importeHora<0){
            System.out.println("No puedes cobrar en negativo.");
            return false;
        }else{
            return true;
        }
    }

    private static Direccion introducirDomicilio(){
        String nombreCalle = introducirNombreCalle();
        int numero = introducirNumeroDireccion();
        int piso = introducirPiso();
        char letra = introducirLetra();
        String codigoPostal = introducirCodigoPostal();
        String poblacion = introducirPoblacion();
        String provincia = introducirProvincia();
        String pais = introducirPais();
        return new Direccion(nombreCalle,numero,piso,letra,codigoPostal,poblacion,provincia,pais);
    }

    private static String introducirPais(){
        String pais;
        do{
            System.out.println("Introduce el pais: ");
            pais = sc.nextLine();
        }while (!comprobarTexto(pais));
        return pais;
    }

    private static String introducirProvincia(){
        String provincia;
        do{
            System.out.println("Introduce la provincia: ");
            provincia = sc.nextLine();
        }while (!comprobarTexto(provincia));
        return provincia;
    }

    private static String introducirPoblacion(){
        String poblacion;
        do{
            System.out.println("Introduce la poblacion: ");
            poblacion = sc.nextLine();
        }while(!comprobarTexto(poblacion));
        return poblacion;
    }

    private static String introducirCodigoPostal(){
        String codigoPostal;
        do{
            System.out.println("Introduce el codigo postal: ");
            codigoPostal = sc.nextLine();
        }while(!comprobarDigitosCodigoPostal(codigoPostal) || !comprobarTamanyoCodigoPostal(codigoPostal));
        return codigoPostal;
    }

    private static boolean comprobarDigitosCodigoPostal(String codigoPostal){
        boolean correcto = false;
        for(int i = 0;i<codigoPostal.length();i++) {
            char c = codigoPostal.charAt(i);
            if (c=='0' || c=='1' ||c=='2' ||c=='3' ||c=='4' ||c=='5' ||c=='6' ||c=='7' ||c=='8' ||c=='9') {
                correcto = true;
            }
        }
        return correcto;
    }

    private static boolean comprobarTamanyoCodigoPostal(String codigoPostal){
        if(codigoPostal.length()!=5){
            System.out.println("No has introducido 5 digitos para el codigo postal.");
            return false;
        }else{
            return true;
        }
    }

    private static char introducirLetra(){
        sc.nextLine();
        String letra;
        do{
            System.out.println("Introduce la letra del piso: ");
            letra=sc.nextLine();
        }while(!comprobarCharLetra(letra));
        char c = letra.charAt(0);
        return c;
    }

    private static boolean comprobarCharLetra(String letra){
        char c = letra.charAt(0);
        if(Character.isLetter(c) && letra.length()==1){
            return true;
        }else{
            return false;
        }
    }

    private static boolean comprobarChar(String texto){
        if(texto.length()>1){
            return false;
        }else{
            return true;
        }
    }

    private static int introducirPiso(){
        int piso;
        do{
            System.out.println("Introduce el numero de la planta: ");
            piso = introducirNumeroEntero();
        }while(!comprobarNumeroEnteroPositivo(piso));
        return piso;
    }

    private static int introducirNumeroDireccion(){
        int numero;
        do{

            System.out.println("Introduce el numero de la direccion: ");
            numero = introducirNumeroEntero();
        }while (!comprobarNumeroEnteroPositivo(numero));
        return numero;
    }
    private static String introducirNombreCalle(){
        sc.nextLine();
        String nombreCalle;
        do {
            System.out.println("Introducir el nombre de la calle: ");
            nombreCalle = sc.nextLine();
        }while(!comprobarTexto(nombreCalle));
        return nombreCalle;
    }

    private static Fecha introducirFecha(){
        int dia = introducirDia();
        int mes = introducirMes();
        int año = introducirAño();
        String fecha = dia+"/"+mes+"/"+año;
        boolean res=true;
        res=validarFecha(fecha);
        if(res==true && comprobarFechaPresente(dia,mes,año)){
            //si esta bien esta bien, sino mostramos mensaje de error
        }else {
            System.out.println("La fecha no es valida");
        }
        return new Fecha(dia,mes,año);
    }

    private static boolean comprobarFechaPresente(int dia, int mes, int año){
        boolean valido=true;
        LocalDate current_date = LocalDate.now();
        int dA = current_date.getDayOfMonth();
        int mA = current_date.getMonthValue();
        int yA = current_date.getYear();
        if(año==yA){
            if(mes==mA){
                if(dia>dA){
                    valido = false;
                }else{
                    valido = true;
                }
            }
        }
        return valido;
    }

    private static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private static int introducirAño(){
        int año;
        do{
            System.out.println("Introduce el año de nacimiento: ");
            año = introducirNumeroEntero();
        }while (!comprobarRangoAño(año));
        return año;
    }

    private static boolean comprobarRangoAño(int n){
        LocalDate current_date = LocalDate.now();
        int current_Year = current_date.getYear();
        if(n<=current_Year-120 || n>current_Year){
            if(n<=current_Year-120){
                System.out.println("El año introducido implica tener mas de 120 años...");
            }else{
                System.out.println("El año introducido es mayor al actual, aun no has nacido.");
            }
            return false;
        }else{
            return true;
        }
    }

    private static int introducirMes(){
        int mes;
        do{
            System.out.println("Introduce el mes de nacimiento: ");
            mes = introducirNumeroEntero();
        }while (!comprobarRangoMesesAño(mes));
        return mes;
    }

    private static boolean comprobarRangoMesesAño(int n){
        if(n<=0 || n>12){
            return false;
        }else{
            return true;
        }
    }

    private static int introducirDia(){
        int dia;
        do{
            System.out.println("Introduce el dia de nacimiento: ");
            dia = introducirNumeroEntero();
        }while (!comprobarRangoDiasMes(dia));
        return dia;
    }

    private static boolean comprobarRangoDiasMes(int n){
        if(n<=0 || n>31){
            return false;
        }else{
            return true;
        }
    }

    private static boolean comprobarNumeroEnteroPositivo(int n){
        if(n<=-1){
            return false;
        }else{
            return true;
        }
    }

    private static String introducirTelefono(){
        String telefono;
        do{
            System.out.println("Introduce el numero de telefono: ");
            telefono = sc.nextLine();
        }while(!comprobarNumeros(telefono) || !comprobarTamañoTelefono(telefono));
        return telefono;
    }

    private static boolean comprobarTamañoTelefono(String telefono){
        if(telefono.length()!=9){
            System.out.println("El telefono no tiene 9 digitos.");
            return false;
        }else{
            return true;
        }
    }

    private static boolean comprobarNumeros(String cadena){
        char c;
        for(int i = 0; i<cadena.length();i++){
            c=cadena.charAt(i);
            if(Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    private static Genero introducirGenero(){
        String genero;
        do {
            System.out.println("Introduce el genero del actor de las siguientes opciones:\n----------------------------- ");

            mostrarGeneros();
            genero = sc.nextLine().toUpperCase();
        }while(!comprobarGenero(genero));
        return Genero.valueOf(genero);
    }

    private static void mostrarGeneros(){
        Object [] possibleValues = Genero.values();
        for (Object o : possibleValues) {
            System.out.println(o.toString());
        }
    }

    private static boolean comprobarGenero(String genero){
        boolean encontrado=false;
        //METER EN UN ARRAY LAS RAZAS Y COMPRARAR EL VALOR CON TODOS LOS VALORES DEL ARRAY
        Object [] possibleValues = Genero.values();
        for (Object o : possibleValues) {
            if(genero.equals(o.toString())){
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
        }
        if(!encontrado){
            System.out.println("El genero introducido no es una de la lista.");
        }
        return encontrado;
    }

    private static String introducirNombre(){
        String nombre;
        do {
            System.out.println("Introduce un nombre: ");
            nombre = sc.nextLine();
        }while(!comprobarTexto(nombre));
        return nombre;
    }

    private static boolean comprobarTexto(String nombre){
        char n;
        for(int i = 0; i<nombre.length();i++){
           n = nombre.charAt(i);
           if(Character.isDigit(n)){
               return false;
           }
        }
        return true;
    }

    private static boolean validar(String dni){
        String letraMayuscula="";
        //Si no tiene 9 caracteres o el caracter numero 9 no es una letra devolvemos que está mal
        if(dni.length() !=9 || Character.isLetter(dni.charAt(8))==false){
            return false;
        }
        //obtenemos la letra del ultimo caracter en mayuscula
        letraMayuscula = dni.substring(8).toUpperCase();
        //si los 8 primeros digitos son numeros y la letra del dni es correcta entonces está validado
        if(soloNumeros(dni) == true /*&& letraDni(dni).equals(letraMayuscula)*/){
            return true;
        }else{
            return false;
        }
    }

    /*private static String letraDNI(String dni){
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String [] asignacionLetra = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

        resto = miDNI % 23;
        miLetra = asignacionLetra[resto];

        return miLetra;
    }*/

    private static boolean soloNumeros(String dni){
        int i, j = 0;
        String numero = "";
        String miDNI = "";
        String [] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
        for(i=0;i<dni.length()-1;i++){
            numero = dni.substring(i,i+1);
            for(j=0;j<unoNueve.length;j++) {
                if (numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }
        if(miDNI.length()!=8){
            return false;
        }else{
            return true;
        }
    }

    private static boolean continuarCreacion(){
        String respuesta;
        do {
            System.out.println("¿Desea continuar con la creacion de este Actor? (Y o N)");
            respuesta = sc.nextLine().toUpperCase();
        }while(!validarRespuesta(respuesta));
        return comprobarRespuesta(respuesta);
    }

    private static boolean confirmarAccion(){
        String respuesta;
        do {
            System.out.println("¿Desea confirmar la accion? (Y o N)");
            respuesta = sc.nextLine().toUpperCase();
        }while(!validarRespuesta(respuesta));
        return comprobarRespuesta(respuesta);
    }

    private static boolean comprobarRespuesta(String respuesta){
        if(respuesta.equals("Y")){
            return true;
        }else{
            return false;
        }
    }

    private static boolean validarRespuesta(String respuesta){
        if(respuesta.length()>1){
            return false;
        }else{
            if(respuesta.equals("Y") || respuesta.equals("N")){
                return true;
            }else{
                return false;
            }
        }
    }

    private static Raza introducirRaza(){
        String raza;
        sc.nextLine();
        do {
            System.out.println("\nIntroduce la raza del actor de las siguientes opciones:\n----------------------------- ");
            //System.out.println(Raza.CAUCASICO + " ," + Raza.HISPANO + " ," + Raza.NEGRO + " ," + Raza.ORIENTAL + " o " + Raza.ABORIGEN);
            mostrarRazas();
            raza = sc.nextLine().toUpperCase();
        }while(!comprobarRaza(raza));
        return Raza.valueOf(raza);
    }

    private static void mostrarRazas(){
        Object [] possibleValues = Raza.values();
        for (Object o : possibleValues) {
            System.out.println(o.toString());
        }
    }
    private static boolean comprobarRaza(String raza){
        boolean encontrado=false;
        //METER EN UN ARRAY LAS RAZAS Y COMPRARAR EL VALOR CON TODOS LOS VALORES DEL ARRAY
        Object [] possibleValues = Raza.values();
        for (Object o : possibleValues) {
            if(raza.equals(o.toString())){
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
        }
        if(!encontrado){
            System.out.println("La raza introducida no es una de la lista.");
        }
        return encontrado;
    }

    private static double introducirPeso(){
        double peso=0;
        do{
            System.out.println("Introduce el peso del actor en KG: ");
            try{
                peso=sc.nextDouble();
            }catch (Exception e){
                sc.nextLine();
                System.err.println("El valor introducido no es valido.");
                peso=-1;
            }
        }while(!comprobarPeso(peso));
        return peso;
    }

    private static boolean comprobarPeso(double peso){
        if(peso>300 || peso<10){
            System.out.println("Peso fuera del rango humano");
            return false;
        }else{
            return true;
        }
    }

    private static double introducirAltura(){
        double altura=0;
        do{
            System.out.println("Introduce la altura del actor: ");
            try{
                altura=sc.nextDouble();
            }catch (Exception e){
                sc.nextLine();
                System.err.println("El valor introducido no es valido.");
                altura=-1;
            }
        }while(!comprobarAltura(altura));
        return altura;
    }

    private static boolean comprobarAltura(double altura){
        if(altura>3 || altura<0.4){
            System.out.println("Altura fuera del rango humano.");
            return false;
        }else{
            return true;
        }
    }

    private static void mostrarMenuTipoActor(){
        System.out.println("\nElige un tipo de actor: \n------------------- ");
        System.out.println("0 - Salir");
        System.out.println("1 - Amateur");
        System.out.println("2 - Profesional");
    }

    private static boolean comprobarTipoActor(int tipo){
        if(tipo>2 || tipo<0){
            System.out.println("Has introducido un valor no valido.");
            return false;
        }else{
            return true;
        }
    }

    private static int introducirNumeroEntero(){
        int opcion=0;
            try{
                opcion=sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
                return -1;
            }
        return opcion;
    }

    private static void mostrarMenu(){
        System.out.println("\nMenu Gestion De Actores\n-----------------------");
        System.out.println("0 - Salir");
        System.out.println("1 - Altas actores.");
        System.out.println("2 - Bajas actores.");
        System.out.println("3 - Cambio de Amateur a Profesional.");
        System.out.println("4 - Aumentar horas a un actor Amateur.");
        System.out.println("5 - Aumentar representaciones a un actor Profesional.");
        System.out.println("6 - Listado de actores y sueldos.");
        System.out.println("7 - Listado de actores menores de edad.");
        System.out.println("8 - Listado de de actores mayores de edad");
        System.out.println("9 - Listado de actores de una raza.");
        System.out.println("10 - Actores superiores a una altura.");
        System.out.println("11 - Actores superiores a un peso.");
        System.out.println("12 - Actor que más cobra.");
        System.out.println("13 - Listado alfabético de actores.");
        System.out.println("14 - Listado alfabético de perros.\n----------------------------------------");
    }

    private static void mostrarTodosActores(){
        if(lista.isEmpty()){
            System.out.println("No hay Actores en la lista.");
        }else {
            ArrayList<Contratable> listaActores = new ArrayList<>();
            for (Contratable a : lista) {
                if(a instanceof Profesional || a instanceof Amateur){
                    listaActores.add(a);
                }
            }
            if(listaActores.isEmpty()){
                System.out.println("No hay ningun actor en la lista.");
            }else{
                for(Contratable c : listaActores){
                    if(c instanceof Profesional || c instanceof Amateur){
                        System.out.println(c.toString());
                    }
                }
            }
        }
    }

    private static Amateur actorAmateurPorDefecto(){
        Fecha f = new Fecha(23,04,2010);
        Direccion d = new Direccion("España",34,1,'f',"45434","Elche","Alicante","España");
        return new Amateur("12345678F","Fran",f,d,Genero.HOMBRE,"565434554",87,1.7,Raza.HISPANO,60,21);
    }

    private static Profesional actorProfesionalPorDefecto(){
        Fecha f = new Fecha(12,10,1992);
        Direccion d = new Direccion("Tercios",12,4,'c',"67876","Mieres","Asturias","España");
        return new Profesional("12345643J","Flavia",f,d,Genero.MUJER,"654354654",50,1.55,Raza.ORIENTAL,200,100,2);
    }
    private static Perro perroPorDefecto(){
        return new Perro("Cora","Faus",5000,7);
    }
}