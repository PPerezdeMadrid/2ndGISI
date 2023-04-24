package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejemplo13 extends JFrame {
    private JButton botonCopiar;
    private JTextField campoValor, resultado;
       
    public Ejemplo13(){
        super("Ejemplo Copiar Valor");
        setLayout(new FlowLayout());
        add(new JLabel("Valor: "));
        campoValor = new JTextField(5);
        add(campoValor);
        botonCopiar = new JButton("Copiar");
        add(botonCopiar);
        botonCopiar.addActionListener(new OyenteBoton());
        add(new JLabel("        Copia: "));
        resultado = new JTextField(6);
        add(resultado);
        
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String valor = campoValor.getText();
            resultado.setText(valor);
        }
    }
    
    public static void main(String[] args) {
         Ejemplo13 aplicacion = new Ejemplo13();
    }
}