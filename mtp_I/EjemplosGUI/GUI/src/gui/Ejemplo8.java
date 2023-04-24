package gui;

import java.awt.BorderLayout;
import javax.swing.*;

class Ejemplo8 extends JFrame {

    public Ejemplo8() {
        super("Ejemplo de BorderLayout");
        //Configurar layout
        add(new JButton("Norte"), BorderLayout.NORTH);
        add(new JButton("Oeste"), BorderLayout.WEST);
        add(new JButton("Centro"), BorderLayout.CENTER);
        add(new JButton("Este"), BorderLayout.EAST);
        add(new JButton("Sur"), BorderLayout.SOUTH);

        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo8 aplicacion = new Ejemplo8();
    }
} 
