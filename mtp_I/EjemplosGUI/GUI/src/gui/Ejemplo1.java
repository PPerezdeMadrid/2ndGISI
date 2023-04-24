package gui;

import javax.swing.*;

class Ejemplo1 extends JFrame {

    public Ejemplo1() {
        //con herencia
        setTitle("Hola!!!");
        setSize(300, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new Ejemplo1();

        frame.setVisible(true);
    }
} 
