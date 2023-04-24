package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;

class MiBoton extends JButton {

    public MiBoton(String text) {
        super(text);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(getWidth(), 0, 0, getHeight());
    }
} 

class Ejemplo11b extends JFrame {
   
    public Ejemplo11b(){
        super("Ejemplo Gráfico con JPanel"); 
        add(new MiBoton("Pulsa sobre el botón"));
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         Ejemplo11b aplicacion = new Ejemplo11b();
    }
}