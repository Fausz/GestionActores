import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;

import java.text.SimpleDateFormat;

public class GestionDeActores {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Actor> lista = new ArrayList<>();



    public static void main(String[] args) {

        lista.add(actorAmateurPorDefecto());
        lista.add(actorProfesionalPorDefecto());

        boolean salir=false;
        do{
            salir=menu();
        }while(!salir);
    }

    public static boolean menu() {
        mostrarMenu();
        int opcion = introducirNumeroEntero();
        boolean salir = seleccionMenu(opcion);
        return salir;
    }

    private static boolean seleccionMenu(int opcion) {
        Actor a;
        switch (opcion){
            case 0:
                System.out.println("Fin del programa.");
                return true;
            case 1:
                //añadirActor();
                a = añadirActor();
                if(a==null){
                    System.out.println("No se ha añadido el Actor.");
                }else {
                    lista.add(a);
                    System.out.println("Se ha añadido el actor a la lista.");
                }
                break;
            case 2:
                sc.nextLine();
                a = eliminarActor();
                if(a==null){
                    System.out.println("No se ha eliminado el actor");
                }else{
                    lista.remove(a);
                    System.out.println("Se ha eliminado el actor de la lista.");
                }
                break;
            case 3:
                System.out.println("Cambio de amateur a profesional");
                break;
            case 4:
                System.out.println("Aumentar horas a un actor amateur");
                break;
            case 5:
                System.out.println("Aumentar representaciones a un actor profesional");
                break;
            case 6:
                mostrarActores();
                break;
            case 7:
                System.out.println("Listado de actores menores de edad");
                break;
            case 8:
                System.out.println("Listado de actores mayores de una edad");
                break;
            case 9:
                System.out.println("Listado de actores de una raza");
                break;
            case 10:
                System.out.println("Actores superiores a una altura");
                break;
            case 11:
                System.out.println("Actores superiores a un peso");
                break;
            case 12:
                System.out.println("Actor que más cobra");
                break;
            case 13:
                System.out.println("Listado alfabético de actores");
                break;
            default:
                System.err.println("Has introducido un valor no valido.");
        }
        return false;
    }

    private static Actor eliminarActor(){
        boolean encontrado;
        String dni;
        do {
            dni = introducirDniParaBuscarActor();
            if(dni.equals("0")){
                return null;
            }
            encontrado = comprobarDNIEnLista(dni);
        }while(!encontrado);
        Actor a = obtenerActor(dni);
        return a;
    }

    private static Actor obtenerActor(String dni){
        Actor actor=null;
        for(Actor a : lista){
            if(a.getDni().equals(dni)){
                actor=a;
                break;
            }
        }
        return actor;
    }
    private static String introducirDniParaBuscarActor(){
        String dni;
        do {
            for(Actor a : lista){
                System.out.println("DNI: "+a.getDni()+" del actor: "+a.toString());
            }
            System.out.println("Introduce el DNI del Actor (0 para salir): ");
            dni = sc.nextLine();
        }while(!validar(dni) && !dni.equals("0"));
        return dni;
    }

    private static boolean comprobarDNIEnLista(String dni){
        boolean encontrado=false;
        if(lista.isEmpty()){
            return false;
        }else {
            for (Persona p : lista) {
                if (p.getDni().equals(dni)) {
                    encontrado = true;
                    break;
                }
            }
            return encontrado;
        }
    }

    private static void mostrarActores(){
        if(lista.isEmpty()){
            System.out.println("No hay Actores en la lista.");
        }else {
            for (Persona p : lista) {
                if (p instanceof Amateur) {
                    System.out.println(p.toString());
                } else if (p instanceof Profesional) {
                    System.out.println(p.toString());
                }
            }
        }
    }

    private static Actor añadirActor() {
        boolean salir = false;
        int tipo;
        Actor a;
        do {

            mostrarMenuTipoActor();
            tipo=introducirNumeroEntero();


        }while(!comprobarTipoActor(tipo));
        a = seleccionarOpcionCrearActor(tipo);

        return a;
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
            dni = introducirDni();
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
            }

            cancelarCreacion = cancelarCreación();
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
            dni = introducirDni();
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
            }

            cancelarCreacion = cancelarCreación();
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
        }while(!comprobarDigitosCodigoPostal(codigoPostal) || !comprobarTamañoCodigoPostal(codigoPostal));
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
    private static boolean comprobarTamañoCodigoPostal(String codigoPostal){
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

            Object [] possibleValues = Genero.values();
            for (Object o : possibleValues) {
                System.out.println(o.toString());
            }

            genero = sc.nextLine().toUpperCase();

        }while(!comprobarGenero(genero));
        return Genero.valueOf(genero);
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

    private static String introducirDni(){
        String dni;
        do {
            System.out.println("Introduce el DNI del Actor: ");
            dni = sc.nextLine();
        }while(!validar(dni) || !comprobarDNIRepetido(dni));
        return dni;
    }

    private static boolean comprobarDNIRepetido(String dni){
        boolean encontrado=true;
        if(lista.isEmpty()){
            return true;
        }else {
            for (Persona p : lista) {
                if (p.getDni().equals(dni)) {
                    System.out.println("Este DNI ya está registrado.");
                    encontrado = false;
                    break;
                }
            }
            return encontrado;
        }
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

    private static boolean cancelarCreación(){
        sc.nextLine();
        String respuesta;
        do {
            System.out.println("¿Desea confiarmar la creacion de este Actor? (Y o N)");
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
            System.out.println("Introduce la raza del actor de las siguientes opciones:\n----------------------------- ");
            //System.out.println(Raza.CAUCASICO + " ," + Raza.HISPANO + " ," + Raza.NEGRO + " ," + Raza.ORIENTAL + " o " + Raza.ABORIGEN);
            Object [] possibleValues = Raza.values();
            for (Object o : possibleValues) {
                System.out.println(o.toString());
            }
            raza = sc.nextLine().toUpperCase();
        }while(!comprobarRaza(raza));
        return Raza.valueOf(raza);
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
        System.out.println("12 - Actor que más cobra");
        System.out.println("13 - Listado alfabético de actores.\n----------------------------------------");
    }
    private static Actor actorAmateurPorDefecto(){
        Fecha f = new Fecha(23,04,1990);
        Direccion d = new Direccion("España",34,1,'f',"45434","Elche","Alicante","España");
        return new Amateur("12345678F","Fran",f,d,Genero.HOMBRE,"565434554",87,1.7,Raza.CAUCASICO,60,21);
    }
    private static Profesional actorProfesionalPorDefecto(){
        Fecha f = new Fecha(12,10,1942);
        Direccion d = new Direccion("Tercios",12,4,'c',"67876","Mieres","Asturias","España");
        return new Profesional("12345643J","Flavia",f,d,Genero.MUJER,"654354654",50,1.55,Raza.ORIENTAL,200,100,2);
    }
}
