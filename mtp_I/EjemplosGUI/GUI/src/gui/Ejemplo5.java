package gui;

import javax.swing.*;
class Ejemplo5 extends JFrame {
    private JMenuBar menubar;
    private JMenu fileMenu, editMenu;
    private JMenuItem openItem, saveItem, quitItem;

    public Ejemplo5() {
        super("Ejemplo 5 con menú");
        //Configurar menú
        menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        fileMenu = new JMenu("Archivo");
        menubar.add(fileMenu);
        openItem = new JMenuItem("Abrir");
        fileMenu.add(openItem);
        saveItem = new JMenuItem("Guardar...");
        fileMenu.add(saveItem);
        quitItem = new JMenuItem("Cerrar");
        fileMenu.add(quitItem);
        
        editMenu = new JMenu("Editar");
        menubar.add(editMenu);
        
        setSize(350, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Ejemplo5 aplicacion = new Ejemplo5();
    }
} 
