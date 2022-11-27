package Vista;

import javax.swing.*;

public class Ventana extends JFrame {
    private Tablero tablero;

    public Ventana(){
        tablero = new Tablero(this);
        init1();
        this.setVisible(true);
    }

    private void init1(){
        this.setLayout(null);
        this.setSize(tablero.getSize());
        this.setPreferredSize(this.getSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().add(tablero);
        this.pack();
    }
}
