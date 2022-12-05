package Vista;

import Modelo.Jugador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Tablero tablero;
    private PanelInformacion panelInformacion;
    private PanelRegistro panelRegistro;

    public Ventana(){
        init1();
    }

    private void init1(){
        panelRegistro = new PanelRegistro(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panelRegistro);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void empezarJuego(Jugador jugador){
        this.remove(panelRegistro);

        tablero = new Tablero(this, jugador);
        panelInformacion = new PanelInformacion(this, tablero, jugador);

        this.add(tablero, BorderLayout.CENTER);
        this.add(panelInformacion, BorderLayout.EAST);
        tablero.iniciarThread();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void iniciarThread(){
        tablero.iniciarThread();
    }

    public void actualizarPanelInfo(){
        panelInformacion.actualizarDatos();
    }

    public void mostrarResultado(){
        panelInformacion.mostrarResultadoDado();
    }
}
