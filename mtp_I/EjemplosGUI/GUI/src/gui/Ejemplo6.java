package gui;

import java.awt.FlowLayout;
import javax.swing.*;

class Ejemplo6 extends JFrame {

    public Ejemplo6() {
        super("Ejemplo de Layout");
        //Configurar layout
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        for(int i = 1; i <= 10; i++)
            add(new JButton("Componente " + i));

        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo6 aplicacion = new Ejemplo6();
    }
} 
