package gui;

import java.awt.GridLayout;
import javax.swing.*;

class Ejemplo7 extends JFrame {

    public Ejemplo7() {
        super("Ejemplo de GridLayout");
        //Configurar layout
        setLayout(new GridLayout(3, 4, 5, 5));
        for(int i = 0; i < 3 * 4; i++)
            add(new JButton(Integer.toString(i + 1)));

        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo7 aplicacion = new Ejemplo7();
    }
} 
