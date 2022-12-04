package Modelo;

import javax.swing.*;
import java.awt.*;

public class Ficha extends JLabel {
    private String color;
    private int posicion;
    private Jugador jugador;
    private int numMovimientos;
    private Point posicionInicial;
    private Icon icon;

    public Ficha(String color, Point posicionInicial, int tamaño) {
        this.color = color;
        this.posicionInicial = posicionInicial;
        this.setLocation(posicionInicial);
        this.setSize(tamaño,tamaño);
        ajustarImagen();
    }

    private void ajustarImagen(){
        ImageIcon aux = new ImageIcon("Imagenes/pieza_" + color + ".png");
        Icon icon = new ImageIcon(aux.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.icon = icon;
        this.setIcon(icon);
    }

    public void aumentarMovimientos(int num){
        this.numMovimientos += num;
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

    public Point getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(Point posicionInicial) {
        this.posicionInicial = posicionInicial;
    }
}
