package Vista;

import Modelo.Casilla;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Tablero extends JPanel {
    private Ventana ventana;
    private JLabel lbFondo = new JLabel();

    private HashMap<Integer, Casilla> casillas;

    public Tablero(Ventana ventana) {
        this.ventana = ventana;
        init1();
        this.setVisible(true);
    }

    public void init1(){
        this.setLayout(null);
        Dimension d = new Dimension(900,900);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Imagenes/istockphoto-493120080-1024x1024-transformed.jpeg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        lbFondo.setSize(900, 900);
        lbFondo.setLocation(0,0);

        Image dimg = img.getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lbFondo.setIcon(imageIcon);

        this.setSize(d);
        this.setPreferredSize(d);

//        lbFondo.setIcon(imgTablero);
//        lbFondo.setSize(tamaño);
//        lbFondo.setLocation(0,0);

        crearCasillas();
        posicionarCasillas();

        this.add(lbFondo);
    }

    // Metodo para iniciar las casillas
    private void crearCasillas(){
        casillas = new HashMap<>();
        for (int i = 0; i < 72; i++) {
            boolean especial = i + 1 > 52;
            Casilla c = new Casilla(i+1, especial);
            c.setSize(58,58);
            casillas.put(i+1, c);
            this.add(c);
        }
    }

    // 1125 -> 74
    // x -> 60

    // Metodo para settear la posicion de las casillas
    private void posicionarCasillas(){
        // Recorrido Normal
        casillas.get(1).setLocation(361,840);
        casillas.get(2).setLocation(361,780);
        casillas.get(3).setLocation(361,720);
        casillas.get(4).setLocation(361,660);
        casillas.get(5).setLocation(361,600);
        casillas.get(6).setLocation(361,540);
        casillas.get(7).setLocation(303,480);
        casillas.get(8).setLocation(243,480);
        casillas.get(9).setLocation(183,480);
        casillas.get(10).setLocation(123,480);
        casillas.get(11).setLocation(63,480);
        casillas.get(12).setLocation(3,480);
        casillas.get(13).setLocation(3,420);
        casillas.get(14).setLocation(3,360);
        casillas.get(15).setLocation(63,360);
        casillas.get(16).setLocation(123,360);
        casillas.get(17).setLocation(183,360);
        casillas.get(18).setLocation(243,360);
        casillas.get(19).setLocation(303,360);
        casillas.get(20).setLocation(361,303);
        casillas.get(21).setLocation(361,243);
        casillas.get(22).setLocation(361,183);
        casillas.get(23).setLocation(361,123);
        casillas.get(24).setLocation(361,63);
        casillas.get(25).setLocation(361,3);
        casillas.get(26).setLocation(421,3);
        casillas.get(27).setLocation(481,3);
        casillas.get(28).setLocation(481,63);
        casillas.get(29).setLocation(481,123);
        casillas.get(30).setLocation(481,183);
        casillas.get(31).setLocation(481,243);
        casillas.get(32).setLocation(481,303);
        casillas.get(33).setLocation(540,361);
        casillas.get(34).setLocation(600,361);
        casillas.get(35).setLocation(660,361);
        casillas.get(36).setLocation(720,361);
        casillas.get(37).setLocation(780,361);
        casillas.get(38).setLocation(840,361);
        casillas.get(39).setLocation(840,421);
        casillas.get(40).setLocation(840,481);
        casillas.get(41).setLocation(780,481);
        casillas.get(42).setLocation(720,481);
        casillas.get(43).setLocation(660,481);
        casillas.get(44).setLocation(600,481);
        casillas.get(45).setLocation(541,481);
        casillas.get(46).setLocation(481,540);
        casillas.get(47).setLocation(481,600);
        casillas.get(48).setLocation(481,660);
        casillas.get(49).setLocation(481,720);
        casillas.get(50).setLocation(481,780);
        casillas.get(51).setLocation(481,840);
        casillas.get(52).setLocation(421,840);
        // Zona segura azul
        casillas.get(53).setLocation(421,780);
        casillas.get(54).setLocation(421,720);
        casillas.get(55).setLocation(421,660);
        casillas.get(56).setLocation(421,600);
        casillas.get(57).setLocation(421,540);
        // Zona segura rojo
        casillas.get(58).setLocation(63,420);
        casillas.get(59).setLocation(123,420);
        casillas.get(60).setLocation(183,420);
        casillas.get(61).setLocation(243,420);
        casillas.get(62).setLocation(303,420);
        // Zona segura verde
        casillas.get(63).setLocation(421,63);
        casillas.get(64).setLocation(421,123);
        casillas.get(65).setLocation(421,183);
        casillas.get(66).setLocation(421,243);
        casillas.get(67).setLocation(421,303);
        // Zona segura amarilla
        casillas.get(68).setLocation(780,421);
        casillas.get(69).setLocation(720,421);
        casillas.get(70).setLocation(660,421);
        casillas.get(71).setLocation(600,421);
        casillas.get(72).setLocation(540,421);
    }


}
