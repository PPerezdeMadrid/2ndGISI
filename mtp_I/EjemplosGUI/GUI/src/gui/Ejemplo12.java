package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejemplo12 extends JFrame {
    private JButton boton;
       
    public Ejemplo12(){
        super("Ejemplo Botón con pitido"); 
        boton = new JButton("¡Pulsa!");
        add(boton);
        boton.addActionListener(new OyenteBoton());
        setSize(250, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void main(String[] args) {
         Ejemplo12 aplicacion = new Ejemplo12();
    }
}