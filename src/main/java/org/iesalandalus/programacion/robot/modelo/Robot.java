package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {

    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
        this.setZona(new Zona());
        this.setOrientacion (Orientacion.NORTE);
        this.setCoordenada(new Coordenada(5,5));
    }
    public Robot(Zona zona) {
        this.setZona(zona);
        this.setOrientacion(Orientacion.NORTE);
        this.setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.setZona(zona);
        this.setOrientacion(orientacion);
        this.setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this.setZona(zona);
        this.setOrientacion(orientacion);
        this.setCoordenada(coordenada);
    }
    public Robot(Robot robot)
    {
        if (robot == null)
            throw new NullPointerException("El robot no puede ser nulo.");

        this.setZona(new Zona(robot.getZona().ancho(), robot.getZona().alto()));
        this.setOrientacion(robot.getOrientacion());
        this.setCoordenada(new Coordenada(robot.getCoordenada().x(), robot.getCoordenada().y()));
    }

    public Zona getZona()
    {
        return zona;
    }

    private void setZona(Zona zona)
    {
        if (zona == null)
            throw new NullPointerException("La zona no puede ser nula.");

        this.zona = zona;
    }
    public Orientacion getOrientacion() { return orientacion;}
    private void setOrientacion(Orientacion orientacion) {
        if (orientacion == null)
            throw new NullPointerException("La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    private void setCoordenada(Coordenada coordenada) {
        if (coordenada == null)
            throw new NullPointerException("La coordenada no puede ser nula.");

        if (!this.zona.pertenece(coordenada))
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        this.coordenada = coordenada;
    }

    public void avanzar() throws OperationNotSupportedException {
        Coordenada nuevaCoordenada = new Coordenada(-1,-1);

        switch (orientacion){
            case NORTE ->  nuevaCoordenada = new Coordenada(this.coordenada.x(), this.coordenada.y() + 1);
            case NORESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() + 1, this.coordenada.y() + 1);
            case ESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() + 1,this.coordenada.y());
            case SURESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() + 1, this.coordenada.y() - 1);
            case SUR -> nuevaCoordenada = new Coordenada(this.coordenada.x(), this.coordenada.y() - 1);
            case SUROESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() - 1, this.coordenada.y()- 1);
            case OESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() - 1, this.coordenada.y());
            case NOROESTE -> nuevaCoordenada = new Coordenada(this.coordenada.x() - 1, this.coordenada.y() + 1);
        }

        if (!this.zona.pertenece(nuevaCoordenada))
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");

        this.setCoordenada(nuevaCoordenada);
    }
    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> this.setOrientacion(Orientacion.NORESTE);
            case NOROESTE -> this.setOrientacion(Orientacion.NORTE);
            case ESTE -> this.setOrientacion(Orientacion.SURESTE);
            case SURESTE -> this.setOrientacion(Orientacion.SUR);
            case SUR -> this.setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> this.setOrientacion(Orientacion.OESTE);
            case OESTE -> this.setOrientacion(Orientacion.NOROESTE);
            case NORESTE -> this.setOrientacion( Orientacion.ESTE);
        }
    }
    public void girarALaIzquierda() {
        switch (orientacion) {
            case NORTE -> this.setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> this.setOrientacion(Orientacion.OESTE);
            case ESTE -> this.setOrientacion(Orientacion.NORESTE);
            case SURESTE -> this.setOrientacion(Orientacion.ESTE);
            case SUR -> this.setOrientacion(Orientacion.SURESTE);
            case SUROESTE -> this.setOrientacion(Orientacion.SUR);
            case OESTE -> this.setOrientacion(Orientacion.SUROESTE);
            case NORESTE -> this.setOrientacion(Orientacion.NORTE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, orientacion, coordenada);
    }
}
