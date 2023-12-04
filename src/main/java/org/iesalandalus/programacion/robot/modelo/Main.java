package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public class Main {
    private ControladorRobot controladorRobot = new ControladorRobot(new Robot());

    private void  ejecutarOpcion (int opcion){
        switch (opcion)
        {
            case 1: {
                Zona zona = Consola.elegirZona();
                controladorRobotZona(zona);
                break;
            }

            case 2: {
                Zona zona = Consola.elegirZona();
                Orientacion orientacion = Consola.elegirOrientacion();
                controlarRobotZonaOrientacion(zona, orientacion);
                break;
            }

            case 3: {
                Zona zona = Consola.elegirZona();
                Orientacion orientacion = Consola.elegirOrientacion();
                Coordenada coordenada = Consola.elegirCoordenada();
                controlarRobotZonaOrientacionCoordenada(zona, orientacion, coordenada);
                break;
            }

            case 4: {
                ejecutarComando();
                break;
            }

            case 5: {
                Consola.despedirse();
                break;
            }
        }
    }
    private void controlarRobotDefecto () {
        Robot robot = new Robot();
        controladorRobot = new ControladorRobot(robot);
    }

    private void controladorRobotZona(Zona zona) {
        Robot robot = new Robot(zona);
        controladorRobot = new ControladorRobot(robot);
    }
    private void controlarRobotZonaOrientacion(Zona zona, Orientacion orientacion) {
        Robot robot = new Robot(zona, orientacion);
        controladorRobot = new ControladorRobot(robot);
    }
    private void controlarRobotZonaOrientacionCoordenada(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        Robot robot = new Robot(zona, orientacion, coordenada);
        controladorRobot = new ControladorRobot(robot);
    }
     private void ejecutarComando(){
        char comando = Consola.elegirComando();
         try
         {
             controladorRobot.ejecutar(comando);
         }
         catch (OperationNotSupportedException ex)
         {
             System.out.println("Comando no soportado");
         }
    }

    public static void main(String[] args) {
        Main instancia = new Main();
        int opcion;

        do {
            opcion = Consola.elegirOpcion();
            instancia.ejecutarOpcion(opcion);
            Consola.mostrarRobot(instancia.controladorRobot.getRobot());
        }while(opcion != 5);
    }

}
