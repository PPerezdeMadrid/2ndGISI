package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejemplo16 extends JFrame {
    private JTextField cantidad = new JTextField(10);
    private JButton boton1 = new JButton("A Euros");
    private JButton boton2 = new JButton("A Pesetas");
       
    public Ejemplo16(){
        super("Conversor Euros-Pesetas");
        setLayout(new FlowLayout());
        JLabel etiqueta = new JLabel("Valor del cambio: ");
        cantidad.setText("0");
        add(etiqueta); add(cantidad);
        add(boton1); add(boton2);
        boton1.addActionListener(new OyenteBoton());
        boton2.addActionListener(new OyenteBoton());
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Float f = new Float(cantidad.getText());
            float valor = f.floatValue();
            String s = (String)e.getActionCommand();
            if (s.equals("A Euros")) {
                valor = (float) (valor / 166.386);
            } else if (s.equals("A Pesetas")) {
                valor = (float) (valor * 166.386);
            }
            cantidad.setText(Float.toString(valor));
        }        
    }

    public static void main(String[] args) {
         Ejemplo16 aplicacion = new Ejemplo16();
    }
}