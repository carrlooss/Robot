package org.iesalandalus.programacion.robot.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Menú");
        System.out.println("----");
        System.out.println("1.- Controlar un robot por defecto indicando su zona");
        System.out.println("2.- Controlar un robot por defecto indicando su zona y orientación");
        System.out.println("3.- Controlar un robot por defecto indicando su zona, orientación y coordenada incial");
        System.out.println("4.- Ejecutar comando");
        System.out.println("5.- Salir");
    }

    public static int elegirOpcion() {
        int numero;
        mostrarMenuPrincipal();
        do {
            System.out.println("Introduce un número por teclado para elegir la opción");
            numero = Entrada.entero();
        } while (numero < 1 || numero > 5);
        return numero;
    }

    public static Zona elegirZona() {
        int numeroAncho = 0;
        int numeroAlto = 0;
        do {
            System.out.println("Introduce el ancho");
            numeroAncho = Entrada.entero();
            System.out.println("Introduce el alto");
            numeroAlto = Entrada.entero();
        } while (numeroAlto < 10 || numeroAlto > 100 || numeroAncho < 10 || numeroAncho > 100);
        Zona zona = new Zona(numeroAncho, numeroAlto);
        return (zona);
    }
    public static void mostrarMenuOrientacion () {
        System.out.println("Menu orientación");
        System.out.println("----------------");
        System.out.println("1.- Norte");
        System.out.println("2.- Noreste");
        System.out.println("3.- Este");
        System.out.println("4.- Sureste");
        System.out.println("5.- Sur");
        System.out.println("6.- Suroeste");
        System.out.println("7.- Oeste");
        System.out.println("8.- Noroeste");
    }
    public static Orientacion elegirOrientacion() {
        int numero;
        mostrarMenuOrientacion();
        do {
            System.out.println("Introduce un número por teclado para elegir la opción");
            numero = Entrada.entero();
        } while (numero < 1 || numero > 8);
        Orientacion orientacion;
        switch (numero) {
            case 1 -> orientacion = Orientacion.NORTE;
            case 2 -> orientacion = Orientacion.NORESTE;
            case 3 -> orientacion = Orientacion.ESTE;
            case 4 -> orientacion = Orientacion.SURESTE;
            case 5 -> orientacion = Orientacion.SUR;
            case 6 -> orientacion = Orientacion.SUROESTE;
            case 7 -> orientacion = Orientacion.OESTE;
            case 8 -> orientacion = Orientacion.NOROESTE;
            default -> orientacion = Orientacion.NORTE;
        }
        return orientacion;
    }
    public static Coordenada elegirCoordenada() {
        int numeroX;
        int numeroY;
        System.out.println("Elige la coordenada X: ");
        numeroX = Entrada.entero();
        System.out.println("Elige la coordenada Y: ");
        numeroY = Entrada.entero();
        return (new Coordenada(numeroX, numeroY));
    }
    public static char elegirComando() {
        char letra;
        System.out.println("Elige el comando a ejecutar: ");
        System.out.println("D.- Girar a la derecha");
        System.out.println("I.- Girar a la izquierda");
        System.out.println("A.- Avanzar");
        do {
            System.out.println("Elige una letra para realizar una accion");
            letra = Entrada.caracter();
        } while (letra != 'A' && letra != 'a' && letra != 'D' && letra != 'd' && letra != 'I' && letra != 'i');
        return letra;
    }
    public static void mostrarRobot(Robot robot) {
        if (robot == null){
            System.out.println("El robot no puede ser nulo.");
            return;
        }
        System.out.println(robot.getOrientacion());
        System.out.println(robot.getCoordenada());
    }
    public static void despedirse() {
        System.out.println("Adios.");
    }
}
