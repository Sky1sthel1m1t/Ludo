package Vista;

import Modelo.Casilla;
import Modelo.Dado;
import Modelo.Ficha;
import Modelo.Jugador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tablero extends JPanel implements MouseListener, Runnable {
    private Ventana ventana;
    private JLabel lbFondo = new JLabel();
    private JLabel lbFichasMetidasRojas = new JLabel("");
    private JLabel lbFichasMetidasAmarillas = new JLabel("");
    private JLabel lbFichasMetidasVerdes = new JLabel("");
    private JLabel lbFichasMetidasAzules = new JLabel("");
    private int tamañoCasillas = 58;

    private Ficha[] fichasRojas = new Ficha[4];
    private Ficha[] fichasAzules = new Ficha[4];
    private Ficha[] fichasVerdes = new Ficha[4];
    private Ficha[] fichasAmarillas = new Ficha[4];
    private HashMap<Integer, Casilla> casillas;
    private Dado dado = new Dado();

    private int inicioAzul = 2;
    private int inicioRojo = 15;
    private int inicioVerde = 28;
    private int inicioAmarillo = 41;
    private int inicioZonaSeguraAzul = 53;
    private int inicioZonaSeguraRojo = 58;
    private int inicioZonaSeguraVerde = 63;
    private int inicioZonaSeguraAmarillo = 68;

    private int puntosAzul = 0;
    private int puntosRojo = 0;
    private int puntosVerde = 0;
    private int puntosAmarillo = 0;

    private String[] colores = new String[]{"azul", "rojo", "verde", "amarillo"};
    private int numTurno;
    private String turnoColor;
    private int resultadoDado;
    private Jugador jugador;
    private boolean hayGanador = false;

    private Thread hilo;

    public Tablero(Ventana ventana, Jugador jugador) {
        this.ventana = ventana;
        this.jugador = jugador;
        init1();
        elegirColorInicio();
    }

    private void init1() {
        Dimension d = new Dimension(900, 900);
        this.setLayout(null);
        this.setSize(d);
        this.setPreferredSize(d);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Imagenes/istockphoto-493120080-1024x1024-transformed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbFondo.setSize(d);
        lbFondo.setLocation(0, 0);

        Image dimg = img.getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lbFondo.setIcon(imageIcon);

        crearCasillas();
        posicionarCasillas();
        iniciarFichas();

        lbFichasMetidasRojas.setBounds(361, 420, tamañoCasillas, tamañoCasillas);
        lbFichasMetidasRojas.setHorizontalAlignment(JLabel.CENTER);
        lbFichasMetidasAzules.setBounds(421, 482, tamañoCasillas, tamañoCasillas);
        lbFichasMetidasAzules.setHorizontalAlignment(JLabel.CENTER);
        lbFichasMetidasAmarillas.setBounds(482, 420, tamañoCasillas, tamañoCasillas);
        lbFichasMetidasAmarillas.setHorizontalAlignment(JLabel.CENTER);
        lbFichasMetidasVerdes.setBounds(421, 361, tamañoCasillas, tamañoCasillas);
        lbFichasMetidasVerdes.setHorizontalAlignment(JLabel.CENTER);

        this.add(lbFichasMetidasRojas);
        this.add(lbFichasMetidasVerdes);
        this.add(lbFichasMetidasAmarillas);
        this.add(lbFichasMetidasAzules);
        this.add(lbFondo);
    }

    // Metodo para iniciar las casillas
    private void crearCasillas() {
        casillas = new HashMap<>();
        for (int i = 0; i < 72; i++) {
            boolean especial = i + 1 > 52;
            Casilla c = new Casilla(i + 1, especial);
            c.setSize(tamañoCasillas, tamañoCasillas);
            c.addMouseListener(this);
            casillas.put(i + 1, c);
            this.add(c);
        }
    }

    // 1125 -> 74
    // x -> 60

    // Metodo para settear la posicion de las casillas
    private void posicionarCasillas() {
        // Recorrido Normal
        casillas.get(1).setLocation(361, 840);
        casillas.get(2).setLocation(361, 780);
        casillas.get(3).setLocation(361, 720);
        casillas.get(4).setLocation(361, 660);
        casillas.get(5).setLocation(361, 600);
        casillas.get(6).setLocation(361, 540);
        casillas.get(7).setLocation(303, 480);
        casillas.get(8).setLocation(243, 480);
        casillas.get(9).setLocation(183, 480);
        casillas.get(10).setLocation(123, 480);
        casillas.get(11).setLocation(63, 480);
        casillas.get(12).setLocation(3, 480);
        casillas.get(13).setLocation(3, 420);
        casillas.get(14).setLocation(3, 360);
        casillas.get(15).setLocation(63, 360);
        casillas.get(16).setLocation(123, 360);
        casillas.get(17).setLocation(183, 360);
        casillas.get(18).setLocation(243, 360);
        casillas.get(19).setLocation(303, 360);
        casillas.get(20).setLocation(361, 303);
        casillas.get(21).setLocation(361, 243);
        casillas.get(22).setLocation(361, 183);
        casillas.get(23).setLocation(361, 123);
        casillas.get(24).setLocation(361, 63);
        casillas.get(25).setLocation(361, 3);
        casillas.get(26).setLocation(421, 3);
        casillas.get(27).setLocation(481, 3);
        casillas.get(28).setLocation(481, 63);
        casillas.get(29).setLocation(481, 123);
        casillas.get(30).setLocation(481, 183);
        casillas.get(31).setLocation(481, 243);
        casillas.get(32).setLocation(481, 303);
        casillas.get(33).setLocation(540, 361);
        casillas.get(34).setLocation(600, 361);
        casillas.get(35).setLocation(660, 361);
        casillas.get(36).setLocation(720, 361);
        casillas.get(37).setLocation(780, 361);
        casillas.get(38).setLocation(840, 361);
        casillas.get(39).setLocation(840, 421);
        casillas.get(40).setLocation(840, 481);
        casillas.get(41).setLocation(780, 481);
        casillas.get(42).setLocation(720, 481);
        casillas.get(43).setLocation(660, 481);
        casillas.get(44).setLocation(600, 481);
        casillas.get(45).setLocation(541, 481);
        casillas.get(46).setLocation(481, 540);
        casillas.get(47).setLocation(481, 600);
        casillas.get(48).setLocation(481, 660);
        casillas.get(49).setLocation(481, 720);
        casillas.get(50).setLocation(481, 780);
        casillas.get(51).setLocation(481, 840);
        casillas.get(52).setLocation(421, 840);
        // Zona segura azul
        casillas.get(53).setLocation(421, 780);
        casillas.get(54).setLocation(421, 720);
        casillas.get(55).setLocation(421, 660);
        casillas.get(56).setLocation(421, 600);
        casillas.get(57).setLocation(421, 540);
        // Zona segura rojo
        casillas.get(58).setLocation(63, 420);
        casillas.get(59).setLocation(123, 420);
        casillas.get(60).setLocation(183, 420);
        casillas.get(61).setLocation(243, 420);
        casillas.get(62).setLocation(303, 420);
        // Zona segura verde
        casillas.get(63).setLocation(421, 63);
        casillas.get(64).setLocation(421, 123);
        casillas.get(65).setLocation(421, 183);
        casillas.get(66).setLocation(421, 243);
        casillas.get(67).setLocation(421, 303);
        // Zona segura amarilla
        casillas.get(68).setLocation(780, 421);
        casillas.get(69).setLocation(720, 421);
        casillas.get(70).setLocation(660, 421);
        casillas.get(71).setLocation(600, 421);
        casillas.get(72).setLocation(540, 421);
        // Casillas especiales
        casillas.get(2).setEspecial(true);
        casillas.get(15).setEspecial(true);
        casillas.get(28).setEspecial(true);
        casillas.get(41).setEspecial(true);
    }

    private void iniciarFichas() {
        Point point = new Point(93, 93);
        fichasRojas[0] = new Ficha("rojo", point, tamañoCasillas);
        point = new Point(213, 93);
        fichasRojas[1] = new Ficha("rojo", point, tamañoCasillas);
        point = new Point(93, 213);
        fichasRojas[2] = new Ficha("rojo", point, tamañoCasillas);
        point = new Point(213, 213);
        fichasRojas[3] = new Ficha("rojo", point, tamañoCasillas);

        point = new Point(93, 629);
        fichasAzules[0] = new Ficha("azul", point, tamañoCasillas);
        point = new Point(213, 629);
        fichasAzules[1] = new Ficha("azul", point, tamañoCasillas);
        point = new Point(93, 749);
        fichasAzules[2] = new Ficha("azul", point, tamañoCasillas);
        point = new Point(213, 749);
        fichasAzules[3] = new Ficha("azul", point, tamañoCasillas);

        point = new Point(629, 93);
        fichasVerdes[0] = new Ficha("verde", point, tamañoCasillas);
        point = new Point(749, 93);
        fichasVerdes[1] = new Ficha("verde", point, tamañoCasillas);
        point = new Point(629, 213);
        fichasVerdes[2] = new Ficha("verde", point, tamañoCasillas);
        point = new Point(749, 213);
        fichasVerdes[3] = new Ficha("verde", point, tamañoCasillas);

        point = new Point(629, 629);
        fichasAmarillas[0] = new Ficha("amarillo", point, tamañoCasillas);
        point = new Point(749, 629);
        fichasAmarillas[1] = new Ficha("amarillo", point, tamañoCasillas);
        point = new Point(629, 749);
        fichasAmarillas[2] = new Ficha("amarillo", point, tamañoCasillas);
        point = new Point(749, 749);
        fichasAmarillas[3] = new Ficha("amarillo", point, tamañoCasillas);

        for (Ficha f : fichasAzules) {
            f.addMouseListener(this);
        }

        for (Ficha f : fichasAmarillas) {
            f.addMouseListener(this);
        }

        for (Ficha f : fichasVerdes) {
            f.addMouseListener(this);
        }

        for (Ficha f : fichasRojas) {
            f.addMouseListener(this);
        }

        this.add(fichasRojas[0]);
        this.add(fichasRojas[1]);
        this.add(fichasRojas[2]);
        this.add(fichasRojas[3]);

        this.add(fichasAzules[0]);
        this.add(fichasAzules[1]);
        this.add(fichasAzules[2]);
        this.add(fichasAzules[3]);

        this.add(fichasVerdes[0]);
        this.add(fichasVerdes[1]);
        this.add(fichasVerdes[2]);
        this.add(fichasVerdes[3]);

        this.add(fichasAmarillas[0]);
        this.add(fichasAmarillas[1]);
        this.add(fichasAmarillas[2]);
        this.add(fichasAmarillas[3]);
    }

    private void moverFicha(int numCasillaInicial, Ficha ficha, int numPosicionesMover) {
        int numCasillaFinal = numCasillaInicial + numPosicionesMover;
        ficha.aumentarMovimientos(numPosicionesMover);

        if (numCasillaFinal > 52) {
            numCasillaFinal -= 52;
        }

        if (ficha.getNumMovimientos() > 51) {
            numCasillaFinal = enviarARectaFinal(ficha.getNumMovimientos() - 51);
        }

        if (ficha.getNumMovimientos() == 57) {
            ficha.setPosicion(100);
            aumentarPunto();
            actualizarFichasMetidas();
            return;
        }

        Casilla casillaFinal = casillas.get(numCasillaFinal);

        if (casillaFinal.isEspecial()) {
            casillaFinal.getFichas().add(ficha);
        } else {
            validarCasillaFinal(casillaFinal, ficha);
        }

        ficha.setPosicion(numCasillaFinal);
        casillaFinal.setIcon(ficha.getIcon());

        if (resultadoDado == 6) {
            resultadoDado = -1;
        } else {
            cambiarTurno();
        }

        ventana.actualizarPanelInfo();
    }

    private void validarCasillaFinal(Casilla casilla, Ficha ficha) {
        ArrayList<Ficha> fichas = casilla.getFichas();
        int tamañoArray = fichas.size();

        if (tamañoArray == 0) {
            fichas.add(ficha);
        } else {
            if (tamañoArray > 1 && !fichas.get(0).getColor().equals(ficha.getColor())) {
                ficha.setNumMovimientos(0);
                ficha.setPosicion(0);
                ficha.setVisible(true);
                return;
            }

            String color = fichas.get(0).getColor();
            if (color.equals(ficha.getColor())) {
                fichas.add(ficha);
                ficha.setPosicion(casilla.getNumCasilla());
            } else {
                Ficha fichaComida = casilla.getFichas().remove(0);
                fichaComida.setPosicion(0);
                fichaComida.setNumMovimientos(0);
                fichaComida.setVisible(true);
                fichas.add(ficha);
                resultadoDado = 6;
            }
        }
    }

    private void sacarFichaCasa(Ficha ficha) {
        String color = ficha.getColor();
        int inicio = 0;

        switch (color) {
            case "azul":
                inicio = inicioAzul;
                break;
            case "verde":
                inicio = inicioVerde;
                break;
            case "amarillo":
                inicio = inicioAmarillo;
                break;
            case "rojo":
                inicio = inicioRojo;
                break;
        }

        ficha.setVisible(false);
        ficha.aumentarMovimientos(1);
        ficha.setPosicion(inicio);
        casillas.get(inicio).getFichas().add(ficha);
        casillas.get(inicio).setIcon(ficha.getIcon());
        resultadoDado = -1;
        ventana.actualizarPanelInfo();
    }

    public void cambiarTurno() {
        numTurno++;
        if (numTurno >= colores.length) {
            numTurno = 0;
        }
        turnoColor = colores[numTurno];
        resultadoDado = -1;
        ventana.actualizarPanelInfo();
    }

    private void elegirColorInicio() {
        numTurno = (int) (Math.random() * colores.length);
        turnoColor = colores[numTurno];
        resultadoDado = -1;
    }

    public void girarDado() {
        resultadoDado = dado.getResultado();
        ventana.mostrarResultado();
        if (resultadoDado != 6) {
            if (!validarMovimiento(resultadoDado)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cambiarTurno();
//                if (!jugador.getColor().equals(turnoColor) && !hilo.isAlive()){
//                    try {
//                        hilo.start();
//                    } catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                }
            }
        }
    }

    private boolean validarMovimiento(int num) {
        return switch (turnoColor) {
            case "azul" -> validarMovimiento(fichasAzules, num);
            case "amarillo" -> validarMovimiento(fichasAmarillas, num);
            case "verde" -> validarMovimiento(fichasVerdes, num);
            case "rojo" -> validarMovimiento(fichasRojas, num);
            default -> false;
        };
    }

    private boolean validarMovimiento(Ficha[] fichas, int num) {
        int numFichasFuera = 0;
        int numFichasZonaSegura = 0;
        ArrayList<Ficha> fichasZonaSegura = new ArrayList<>();
        boolean puedeMover = false;

        for (Ficha f : fichas) {
            if (f.getPosicion() != 0 && f.getPosicion() != 100) {
                numFichasFuera++;
                if (f.getNumMovimientos() >= 52) {
                    numFichasZonaSegura++;
                    fichasZonaSegura.add(f);
                }
            }
        }
        if (numFichasFuera == 0) {
            return false;
        }
        if (numFichasFuera == numFichasZonaSegura) {
            for (Ficha f : fichasZonaSegura) {
                if (f.getNumMovimientos() + num <= 57) {
                    puedeMover = true;
                    break;
                }
            }
        } else {
            puedeMover = true;
        }

        return puedeMover;
    }

    private int enviarARectaFinal(int num) {

        int resultado = switch (turnoColor) {
            case "rojo" -> (inicioZonaSeguraRojo - 1) + num;
            case "verde" -> (inicioZonaSeguraVerde - 1) + num;
            case "amarillo" -> (inicioZonaSeguraAmarillo - 1) + num;
            case "azul" -> (inicioZonaSeguraAzul - 1) + num;
            default -> 0;
        };

        return resultado;
    }

    private void actualizarFichasMetidas() {
        switch (turnoColor) {
            case "verde" -> {
                if (puntosVerde == 0) {
                    break;
                }
                lbFichasMetidasVerdes.setText("" + puntosVerde);
            }
            case "rojo" -> {
                if (puntosRojo == 0) {
                    break;
                }
                lbFichasMetidasRojas.setText("" + puntosRojo);
            }
            case "amarillo" -> {
                if (puntosAmarillo == 0) {
                    break;
                }
                lbFichasMetidasAmarillas.setText("" + puntosAmarillo);
            }
            case "azul" -> {
                if (puntosAzul == 0) {
                    break;
                }
                lbFichasMetidasAzules.setText("" + puntosAzul);
            }
        }
    }

    private void aumentarPunto() {
        switch (turnoColor) {
            case "verde" -> puntosVerde++;
            case "rojo" -> puntosRojo++;
            case "amarillo" -> puntosAmarillo++;
            case "azul" -> puntosAzul++;
        }
    }

    private void moverIA(){
        Ficha[] fichas = getFichasAMover();
        ArrayList<Ficha> fichasMovibles = new ArrayList<>();
        Ficha fichaAMover;
        boolean puedeSacar = resultadoDado == 6;

        for (Ficha f:fichas) {
            int numMovimientos = f.getNumMovimientos() + resultadoDado;

            if (puedeSacar && f.getPosicion() != 100 && numMovimientos <= 57){
                fichasMovibles.add(f);
            } else if (f.getPosicion() != 0 && f.getPosicion() != 100 && numMovimientos <= 57) {
                fichasMovibles.add(f);
            }
        }

        int numFicha = (int) (Math.random() * fichasMovibles.size());
        fichaAMover = fichasMovibles.get(numFicha);
        int numCasillaFicha = fichaAMover.getPosicion();

        if (fichaAMover.getPosicion() == 0){
            sacarFichaCasa(fichaAMover);
            System.out.println("Se esta sacando la ficha"+fichaAMover);
        } else {
            int numMovimientos = resultadoDado;
            Casilla casilla = casillas.get(numCasillaFicha);
            fichaAMover = casilla.getFichaAMover(turnoColor, resultadoDado);
            moverFicha(numCasillaFicha, fichaAMover, resultadoDado);
            System.out.println("Se movio la ficha "+fichaAMover + " desde la casilla " + numCasillaFicha + ", se movio" + numMovimientos);
        }
    }

    private Ficha[] getFichasAMover(){
        return switch (turnoColor) {
            case "verde" -> fichasVerdes;
            case "rojo" -> fichasRojas;
            case "azul" -> fichasAzules;
            case "amarillo" -> fichasAmarillas;
            default -> null;
        };
    }

    private void turnoIA(){
        while (!turnoColor.equals(jugador.getColor())){
            System.out.println(turnoColor);
            String turnoAntesGirarDado = turnoColor + "";
            girarDado();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (turnoAntesGirarDado.equals(turnoColor)){
                moverIA();
            }
        }
    }

    public void iniciarThread(){
        hilo = new Thread(this);
        hilo.start();
    }

    private boolean esTurnoJugador(){
        return jugador.getColor().equals(turnoColor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!esTurnoJugador()){
            return;
        }

        if (resultadoDado <= 0) {
            JOptionPane.showMessageDialog(null, "Se debe girar el dado antes de mover " +
                    "alguna pieza");
            return;
        }

        if (e.getSource() instanceof Ficha) {
            Ficha fichaSeleccionada = (Ficha) e.getSource();

            if (fichaSeleccionada.getColor().equals(turnoColor) && resultadoDado == 6) {
                sacarFichaCasa(fichaSeleccionada);
            }
        }

        if (e.getSource() instanceof Casilla) {
            Casilla casilla = (Casilla) e.getSource();
            int numCasilla = casilla.getNumCasilla();

            Ficha fichaSeleccionada = casilla.getFichaAMover(turnoColor, resultadoDado);

            if (fichaSeleccionada == null) {
                return;
            }

            moverFicha(numCasilla, fichaSeleccionada, resultadoDado);

//            if (!jugador.getColor().equals(turnoColor)){
//                hilo.start();
//            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String getTurnoColor() {
        return turnoColor;
    }

    public int getResultadoDado() {
        return resultadoDado;
    }

    @Override
    public void run() {
        while (!hayGanador){
            turnoIA();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
