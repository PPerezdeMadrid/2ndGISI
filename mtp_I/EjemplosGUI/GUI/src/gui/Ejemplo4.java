package gui;

import javax.swing.*;

class Ejemplo4 extends JFrame {
    private JButton miboton;

    public Ejemplo4() {
        super("Ejemplo 4 sin Container"); 
        //Configurar componentes
        miboton = new JButton("Aceptar");
        add(miboton);
        
        setSize(350, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo4 aplicacion = new Ejemplo4();
    }
} 
