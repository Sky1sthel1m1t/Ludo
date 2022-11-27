package Modelo;

import javax.swing.*;

public class Ficha extends JLabel {
    private String color;
    private int posicion;
    private Jugador jugador;
    private int numMovimientos;

    private Icon icon;

    public Ficha(String color, Jugador jugador) {
        this.color = color;
        this.jugador = jugador;
    }

    public int getNumMovimientos() {
        return numMovimientos;
    }

    public void setNumMovimientos(int numMovimientos) {
        this.numMovimientos = numMovimientos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
