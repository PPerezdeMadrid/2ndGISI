package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejemplo15 extends JFrame {
    private JButton rojo = new JButton("Rojo");
    private JButton azul = new JButton("Azul");
    Container p;
       
    public Ejemplo15(){
        super("Ejemplo Color de Fondo");
        p = this.getContentPane();
        setLayout(new FlowLayout());
        add(rojo);
        add(azul);
        rojo.addActionListener(new OyenteRojo());
        azul.addActionListener(new OyenteAzul());
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class OyenteRojo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setBackground(Color.red);
        }        
    }
    
    private class OyenteAzul implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setBackground(Color.blue);
        }        
    }

    public static void main(String[] args) {
         Ejemplo15 aplicacion = new Ejemplo15();
    }
}