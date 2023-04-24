package gui;

import java.io.File;
import static java.lang.System.exit;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Modal extends JFrame {
    
    private class FiltroTexto extends FileFilter {

        @Override
        public boolean accept(File f) {
            String nombre = f.getName();
            return nombre.substring(Math.max(nombre.length()-4, 0)).equals(".txt");
        }

        @Override
        public String getDescription() {
            return "Ficheros de tipo texto";
        }
        
    }
    
    
    private void mostrarMessageDialogs() {
        JOptionPane.showMessageDialog(this,                 //La ventana padre
                "¡¡Se ha producido un error desconocido!!", //El mensaje
                "Error",                                    //Título de la ventana
                JOptionPane.ERROR_MESSAGE);                 //El tipo de mensaje

        JOptionPane.showMessageDialog(this,                 
                "La operación se ha completado con éxito",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(this,                 
                "Operación finalizada. Revise las lista de warnings",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
        
        JOptionPane.showMessageDialog(this,                 
                "Este es un mensaje de información sin más",
                "Mensaje",
                JOptionPane.PLAIN_MESSAGE);
    }
    
    private void mostrarConfirmDialogs() {
        
        int opcionSeleccionada = JOptionPane.showConfirmDialog(this,
                "¿El dato XXXX es correcto?",
                "Solicitud de confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        
        switch (opcionSeleccionada) {
            case JOptionPane.YES_OPTION: break;   //Tratamiento del SI
            case JOptionPane.NO_OPTION: break;   //Tratamiento del NO
            case JOptionPane.CLOSED_OPTION: break;   //Tratamiento ventana cerrada
            default:                        //Esta opción nunca debería alcanzarse
        }

        int opcionSeleccionada2 = JOptionPane.showConfirmDialog(this,
                "¿Desea salir sin guardar?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

    }
    
    private void mostrarInputDialogs() {
        
        String nombre = JOptionPane.showInputDialog(this,
                "Introduce tu nombre completo: ",
                "Petición",
                JOptionPane.QUESTION_MESSAGE);
        

        String[] colores ={"rojo", "negro", "amarillo", "azul", "verde"};
        Object opcion = JOptionPane.showInputDialog(this,
                "Seleccione el color deseado: ",
                "Petición",
                JOptionPane.QUESTION_MESSAGE,
                null,       //Icono no hay
                colores,    //Opciones
                colores[0]  //Opción inicial
                );
    }    
    
    private void mostrarOptionDialogs() {
        
        String[] colores ={"rojo", "negro", "amarillo", "azul", "verde"};
        int opcion = JOptionPane.showOptionDialog(this,
                "Elige tu color preferido: ",
                "Pregunta de Colores",
                -1,         //opciones-->quedan fijadas por el array de opciones
                JOptionPane.QUESTION_MESSAGE,
                null,       //Icono no hay
                colores,    //Opciones
                colores[0]  //Opción inicial
                );        
        
        //**** Procesamiento de la opción ****
    }    

    private void mostrarFileChoosers() {

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new FiltroTexto());
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selector.setCurrentDirectory(new File(System.getProperty("user.dir")));
        
        if ( selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) {
            File f = selector.getSelectedFile();
            //*** Realizar el tratamiento del fichero seleccionado ***
        }
       
        selector.showSaveDialog(this);
        
    }    
    
    public static void main(String[] args) {
        Modal app = new Modal();
        
        app.mostrarMessageDialogs();
        app.mostrarConfirmDialogs();
        app.mostrarInputDialogs();
        app.mostrarOptionDialogs();
        app.mostrarFileChoosers();
        
        exit(0);
    }   
}
