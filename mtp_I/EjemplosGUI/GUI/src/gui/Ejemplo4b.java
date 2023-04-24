package gui;

import javax.swing.*;
class Ejemplo4b extends JFrame {
    private JButton miboton;

    public Ejemplo4b() {
        super("Ejemplo 4b - Botones de varios tipos"); 
        //Configurar componentes
        Box caja = Box.createHorizontalBox();
        caja.add(new JButton("Un botón normal"));
        caja.add(new JToggleButton("Un botón seleccionable"));
        caja.add(new JToggleButton("Otro botón seleccionable", true));
        caja.add(new JCheckBox("Cine"));
        caja.add(new JCheckBox("Teatro", true));
        caja.add(new JCheckBox("Música"));
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton r1 = new JRadioButton("Hombre");
        JRadioButton r2 = new JRadioButton("Mujer");
        JRadioButton r3 = new JRadioButton("Indefinido", true);
        grupo.add(r1);
        grupo.add(r2);
        grupo.add(r3);
        caja.add(r1);
        caja.add(r2);
        caja.add(r3);
        add(caja);
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo4b aplicacion = new Ejemplo4b();
    }
} 
