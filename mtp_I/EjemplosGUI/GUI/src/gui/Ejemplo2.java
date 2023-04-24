package gui;

import javax.swing.*;

class Ejemplo2 {

    public Ejemplo2() {
        //No herencia, directamente del objeto
        JFrame frame = new JFrame("Hola 2, sin herencia!!!");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo2 aplicacion = new Ejemplo2();
    }
} 
