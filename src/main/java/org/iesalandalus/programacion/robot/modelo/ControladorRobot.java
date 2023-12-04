package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public class ControladorRobot {
    private Robot robot;
    public ControladorRobot(Robot robot) {
        this.robot = new Robot(robot);
    }
    public Robot getRobot() {
        return new Robot(this.robot);
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        if (comando == 'A' || comando == 'a') {
            this.robot.avanzar();
            return;
        }

        if (comando == 'D' || comando == 'd') {
            this.robot.girarALaDerecha();
            return;
        }

        if (comando == 'I' || comando == 'i') {
            this.robot.girarALaIzquierda();
            return;
        }
        throw new OperationNotSupportedException("Comando desconocido.");

    }
}
