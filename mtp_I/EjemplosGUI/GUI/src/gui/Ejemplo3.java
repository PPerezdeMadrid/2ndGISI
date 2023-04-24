package gui;

import java.awt.Container;
import javax.swing.*;

class Ejemplo3 extends JFrame {
    private Container panel;
    private JButton miboton;

    public Ejemplo3() {
        super("Ejemplo 3 con Container"); 
        //Configurar componentes
        miboton = new JButton("Aceptar");
        panel = getContentPane();
        panel.add(miboton);
        
        setSize(350, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo3 aplicacion = new Ejemplo3();
    }
} 
