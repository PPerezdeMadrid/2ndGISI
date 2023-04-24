package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

class Ejemplo9 extends JFrame {

    public Ejemplo9() {
        super("Horno Microondas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Configurar layout
        //Creamos el panel p1 para los botones y ponemos un GridLayout
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        
        //Añadimos los botones al panel
        for(int i = 1; i <= 9; i++) {
            p1.add(new JButton("" + i));
        }
        p1.add(new JButton("" + 0));
        p1.add(new JButton("Start"));
        p1.add(new JButton("Stop"));
        
        //Añadimos el panel p2 para poner el campo de texto y p1
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(new JTextField("Aquí el tiempo"), BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        
        //Añadimos p2 y un botón al frame principal
        add(p2, BorderLayout.EAST);
        add(new JButton("Aquí la comida"), BorderLayout.CENTER);

        setSize(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo9 aplicacion = new Ejemplo9();
    }
} 
