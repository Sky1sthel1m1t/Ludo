package Modelo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Casilla extends JLabel {
    private List<Ficha> fichas;
    private int numCasilla;
    private boolean especial;

    public Casilla(int numCasilla, boolean especial) {
        this.numCasilla = numCasilla;
        this.especial = especial;
        if (especial){
            fichas = new ArrayList<>();
        } else {
            fichas = new LinkedList<>();
        }
        init1();
    }

    private void init1(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        this.setOpaque(true);
        this.setText(numCasilla+"");
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBorder(border);
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public int getNumCasilla() {
        return numCasilla;
    }

    public void setNumCasilla(int numCasilla) {
        this.numCasilla = numCasilla;
    }
}
