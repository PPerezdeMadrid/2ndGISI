package databaseconn;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class TablaDeDatos
{
    /** La tabla */
    private JTable tabla;
    /** La ventana */
    private JFrame ventana;
    /** El scroll para la tabla */
    private JScrollPane scroll;

    /**
     * Crea la ventana con todos sus componentes dentro y la visualiza
     *
     */
    public void creaYMuestraVentana()
    {
        ventana = new JFrame("Contenido base de datos");
        if (tabla == null)
            tabla = new JTable();
        scroll = new JScrollPane(tabla);
        ventana.getContentPane().add(scroll);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    /**
     * Mete el modelo que recibe en la tabla.
     * @param modelo
     */
    public void tomaDatos(DefaultTableModel modelo)
    {
        if (tabla == null)
            tabla = new JTable();
        tabla.setModel(modelo);
    }
}
