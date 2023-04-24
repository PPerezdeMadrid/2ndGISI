/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package Paloma;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

class PalomaNormal extends JFrame {
    
    private Container panel1;
    private  JButton botonZombie;

    public PalomaNormal(){
        super("Ejemplo de un botón");
        setLayout(new FlowLayout());
        //PANEL: 
        botonZombie = new JButton("ZOMBIE");
        botonZombie.setToolTipText("Información sobre los Zombies");
        JButton botonEnferm = new JButton("Enfermedades");
        botonEnferm.setToolTipText("Información sobre las enfermedades");
        panel1 = getContentPane();
        panel1.add(botonZombie);
        panel1.add(botonEnferm);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton archivos = new JButton("Introduzca DNI");
        panel1.add(archivos);
        archivos.addActionListener(new OyenteBoton());
         
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        setJMenuBar(barra);
       
        JMenuItem zombie = new JMenuItem("Zombie");
        JMenuItem enferm = new JMenuItem("Enfermedad");
            menu.add(zombie);
            menu.add(enferm);
        menu.add(new JSeparator());
        JMenuItem home = new JMenuItem("Inicio");
            menu.add(home);
        barra.add(menu);
        
        String dni = JOptionPane.showInputDialog(this,
                "Introduzca su DNI", 
                "Petición",
                JOptionPane.QUESTION_MESSAGE);
        
    
            
        
    }
    
    private class OyenteBoton implements ActionListener {
     @Override
      public void actionPerformed(ActionEvent e) {
           VentanaDni ventana = new VentanaDni();
           if("".equals(ventana.dni)){
              Toolkit.getDefaultToolkit().beep();
              //new VentanaDni(); 
           }
           //Preguntar como evitar q se cierre a no ser q escribas!
         
            }    
        } 
    
    private class VentanaDni extends JFrame{

        private String dni;
        public VentanaDni(){
         dni = JOptionPane.showInputDialog(this,
                "Introduzca su DNI", 
                "Petición",
                JOptionPane.QUESTION_MESSAGE);
        }
       
    }
        
     /** private class OyenteBoton implements ActionListener {
     @Override
      public void actionPerformed(ActionEvent e) {
            JFileChooser select = new JFileChooser();
               //select.setFileFilter(new FiltroTexto());
               select.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
               select.setCurrentDirectory(new File(System.getProperty("user.dir")));
               if(select.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                } else {
                   File f = select.getSelectedFile();
         }
            }    
        } **/

    public static void main(String[] args) {
        JFrame frame = new PalomaNormal();

        frame.setVisible(true);
    }
} 

