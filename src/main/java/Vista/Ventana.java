package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Tablero tablero;
    private PanelInformacion panelInformacion;

    public Ventana(){
        init1();
    }

    private void init1(){
        tablero = new Tablero(this);
        panelInformacion = new PanelInformacion(this, tablero);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(tablero, BorderLayout.CENTER);
        this.add(panelInformacion, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
