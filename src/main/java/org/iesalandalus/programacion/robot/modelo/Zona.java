package org.iesalandalus.programacion.robot.modelo;

public record Zona(int ancho, int alto) {
    private static final int ANCHO_MINIMO = 10;
    private static final int ANCHO_MAXIMO = 100;
    private static final int ALTO_MINIMO = 10;
    private static final int ALTO_MAXIMO = 100;
    private static Zona zona;
    private static int centro;
    private static int pertenece;
    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }
    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }
    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        } else if (ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }
    private void validarAlto(int alto) {
        if (alto < ALTO_MINIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        } else if (alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro()
    {
        int centroX = ancho / 2;
        int centroY = alto / 2;
        return new Coordenada(centroX, centroY);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null)
            throw new NullPointerException("La coordenada no puede ser nula.");

        if (perteneceX(coordenada.x()) && perteneceY(coordenada.y()))
            return true;
        return false;
    }

    private boolean perteneceX(int x)
    {
        if (x>=0 && x<ancho)
            return true;
        return false;
    }
    private boolean perteneceY(int y) {
        if (y >= 0 && y < alto)
            return true;
        return false;
    }
}
