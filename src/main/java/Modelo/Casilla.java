package Modelo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Casilla extends JLabel {
    private ArrayList<Ficha> fichas;
    private int numCasilla;
    private boolean especial;

    public Casilla(int numCasilla, boolean especial) {
        this.numCasilla = numCasilla;
        this.especial = especial;
        this.fichas = new ArrayList<>();
        init1();
    }

    public Ficha getFichaAMover(String color, int num) {
        Ficha ficha = null;

        for (int i = 0; i < fichas.size(); i++) {
            Ficha aux = fichas.get(i);
            if (aux.getColor().equals(color) && (aux.getNumMovimientos() + num) <= 57) {
                ficha = fichas.remove(i);
                break;
            }
        }

        if (fichas.size() == 0){
            this.setIcon(null);
        } else {
            for (Ficha f: fichas) {
                this.setIcon(f.getIcon());
            }
        }


        return ficha;
    }

    private void init1() {
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        this.setText(numCasilla + "");
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBorder(border);
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
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
