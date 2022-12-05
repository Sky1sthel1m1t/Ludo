package Vista;

import Modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class PanelInformacion extends JPanel {
    private Frame frame;
    private Tablero tablero;
    private Jugador jugador;

    private JLabel lbTurno = new JLabel();
    private JLabel lbDado = new JLabel();
    private JLabel lbColor = new JLabel();
    private JLabel lbColorJugador = new JLabel();

    private JButton btnDado = new JButton("Girar dado");

    public PanelInformacion(Frame frame, Tablero tablero, Jugador jugador) {
        this.frame = frame;
        this.tablero = tablero;
        this.jugador = jugador;
        init1();
    }

    private void init1(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(300,frame.getHeight()));
        this.setSize(this.getPreferredSize());

        int x = this.getWidth() / 2;
        int y = 20;
        int ancho = 150;
        int altura = 30;
        int espacioY = altura + 10;

        lbTurno.setBounds(x - ancho, y, ancho, altura);
        lbTurno.setText("Es el turno del color: ");
        lbTurno.setHorizontalAlignment(JLabel.RIGHT);
        lbColor.setBounds(x,y,30,altura);
        lbColor.setOpaque(true);
        y += espacioY;
        lbColorJugador.setBounds(x-(ancho/ 2), y,ancho, altura);
        lbColorJugador.setText(jugador.getNombre() + " tu color es: " + jugador.getColor().toUpperCase());
        lbColorJugador.setHorizontalAlignment(JLabel.CENTER);
        y += espacioY;
        btnDado.setBounds(x - (ancho / 2),y,ancho,altura);
        y += espacioY;
        lbDado.setBounds(x - (ancho / 2),y,ancho,altura);

        actualizarDatos();

        btnDado.addActionListener(e -> {
            if (tablero.getResultadoDado() <= 0){
                tablero.girarDado();
            }
            mostrarResultadoDado();
        });

        this.add(lbColor);
        this.add(lbDado);
        this.add(lbTurno);
        this.add(btnDado);
        this.add(lbColorJugador);
    }

    public void actualizarDatos(){
        actualizarColor();
        mostrarResultadoDado();
    }

    private void actualizarColor(){
        switch (tablero.getTurnoColor()){
            case "azul":
                lbColor.setBackground(Color.BLUE);
                break;
            case "verde":
                lbColor.setBackground(Color.green);
                break;
            case "amarillo":
                lbColor.setBackground(Color.yellow);
                break;
            case "rojo":
                lbColor.setBackground(Color.red);
                break;
        }
    }

    public void mostrarResultadoDado(){
        StringBuilder sb = new StringBuilder("El resultado del dado es: ");

        if (tablero.getResultadoDado() <= 0){
            sb.append("?");
        } else {
            sb.append(tablero.getResultadoDado());
        }

        lbDado.setText(sb.toString());
    }

}
