package gui;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MiPanel extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Interfaz Gráfica", 40, 40);
        g.drawRect(40, 50, 100, 50);
    }
} 

class Ejemplo11 extends JFrame {
   
    public Ejemplo11(){
        super("Ejemplo Gráfico con JPanel"); 
        add(new MiPanel());
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         Ejemplo11 aplicacion = new Ejemplo11();
    }
}