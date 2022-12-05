package Vista;

import Modelo.Jugador;

import javax.swing.*;

public class PanelRegistro extends JPanel {
    private JLabel lbNombre = new JLabel("Nombre: ");
    private JLabel lbColor = new JLabel("Seleccionar color: ");
    private JTextField txtNombre = new JTextField("");
    private JComboBox<String> comboBox = new JComboBox<>();
    private JButton btnJugar = new JButton("Jugar");
    private Ventana ventana;

    public PanelRegistro(Ventana ventana) {
        init1();
        this.ventana = ventana;
    }

    private void init1() {
        this.setLayout(null);
        this.setSize(500,500);
        this.setPreferredSize(this.getSize());

        int x = this.getWidth() / 2;
        int y = 60;
        int altura = 30;
        int ancho = 150;

        int espacioY = altura + 10;

        lbNombre.setBounds(x - (ancho / 2),y,ancho, altura);
        y += espacioY;
        txtNombre.setBounds(x - (ancho / 2),y,ancho,altura);
        y += espacioY;
        lbColor.setBounds(x - (ancho / 2),y,ancho, altura);
        y += espacioY;
        comboBox.setBounds(x - (ancho / 2),y,ancho,altura);
        y += espacioY;
        btnJugar.setBounds(x - (ancho / 2),y,ancho,altura);

        btnJugar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String color = (String) comboBox.getSelectedItem();

            if (color == null){
                JOptionPane.showMessageDialog(null ,"Se debe seleccionar un color para continuar");
                return;
            }

            Jugador jugador = new Jugador(nombre, color);
            ventana.empezarJuego(jugador);
        });

        llenarComboBox();

        this.add(lbColor);
        this.add(lbNombre);
        this.add(txtNombre);
        this.add(comboBox);
        this.add(btnJugar);
    }

    private void llenarComboBox(){
        comboBox.addItem("rojo");
        comboBox.addItem("verde");
        comboBox.addItem("amarillo");
        comboBox.addItem("azul");
    }
}
