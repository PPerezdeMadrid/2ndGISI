package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

class EjemploCanvas extends Canvas {
    String cad = "Escrito en canvas";
    
    @Override
    public void paint(Graphics g) {
        //Obtenemos el color original
        Color colorOriginal = g.getColor();
        //Escribimos el texto gráfico en la ventana y recuadro
        g.drawString(cad, 40, 20);
        g.drawRect(35, 8, (cad.length()*7), 14);
        //Dibujamos algunas líneas
        for(int i = 20; i < 50; i = i + 3) {
            if ((i % 2) == 0) { g.setColor(Color.blue); }
            else {g.setColor(Color.red); }
            g.drawLine(40, (90-i), 120, 25+i);
        }
        //Dibujamos y rellenamos un óvalo
        g.drawOval(40, 95, 120, 20);
        g.fillOval(40, 95, 120, 20);
        g.setColor(colorOriginal);
    }
} 

class Ejemplo10 extends JFrame {
   
    public Ejemplo10(){
        super("Ejemplo Gráfico con Canvas"); 
        add(new EjemploCanvas());

        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         Ejemplo10 aplicacion = new Ejemplo10();
    }
}