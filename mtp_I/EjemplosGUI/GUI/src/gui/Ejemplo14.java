package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejemplo14 extends JFrame {
    private JButton boton1;
    private JLabel etiqueta1;
    private int contador;
       
    public Ejemplo14(){
        super("Ejemplo Contar Pulsaciones");
        contador = 0;
        boton1 = new JButton("¡Pulsa!");
        etiqueta1 = new JLabel("Pulsaciones: 0");
        add(boton1);
        add(etiqueta1);
        setLayout(new FlowLayout());
        
        boton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contador++;
                    etiqueta1.setText("Pulsaciones: " + contador);
                }
            }   
        );
        
        setSize(350, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         Ejemplo14 aplicacion = new Ejemplo14();
    }
}