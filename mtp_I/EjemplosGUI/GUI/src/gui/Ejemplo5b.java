package gui;

import javax.swing.*;
class Ejemplo5b extends JFrame {

    public Ejemplo5b() {
        super("Ejemplo 5b con menú extendido");
        //Configurar menú
        JMenuBar barra = new JMenuBar();
        JMenu menu1 = new JMenu("Menú 1");
        menu1.add(new JMenuItem("Una opción de texto"));
        menu1.add(new JSeparator());
        ButtonGroup grupo = new ButtonGroup();
        JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("Opción 1");
        JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("Opción 2");
        grupo.add(r1);
        grupo.add(r2);
        menu1.add(r1);
        menu1.add(r2);
        menu1.add(new JSeparator());
        menu1.add(new JCheckBoxMenuItem("Selección 1", true));
        menu1.add(new JCheckBoxMenuItem("Selección 2"));
        JMenu menu11 = new JMenu("Submenú");
        menu11.add(new JMenuItem("Opc 1"));
        menu11.add(new JMenuItem("Opc 2"));
        menu1.add(menu11);
        barra.add(menu1);
        barra.add(new JMenu("Menú 2"));
        setJMenuBar(barra);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo5b aplicacion = new Ejemplo5b();
    }
} 
