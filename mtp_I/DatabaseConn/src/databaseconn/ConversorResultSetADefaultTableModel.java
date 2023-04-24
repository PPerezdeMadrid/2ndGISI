package databaseconn;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 * Convierte un ResultSet en un DefaultTableModel
 */
public class ConversorResultSetADefaultTableModel
{
    /**
     * Rellena el DefaultTableModel con los datos del ResultSet.
     * Vacía el DefaultTableModel completamente y le mete los datos que hay
     * en el ResultSet.
     * @param rs El resultado de lac onsula a base de datos.
     * @param modelo El DefaultTableModel que queremos rellenar
     */
    public static void rellena(ResultSet rs, DefaultTableModel modelo)
    {
        configuraColumnas(rs, modelo);
        vaciaFilasModelo(modelo);
        anhadeFilasDeDatos(rs, modelo);
    }

    /**
     * A�ade al DefaultTableModel las filas correspondientes al ResultSet.
     * @param rs El resultado de la consulta a base de datos
     * @param modelo El DefaultTableModel que queremos rellenar.
     */
    private static void anhadeFilasDeDatos(ResultSet rs, DefaultTableModel modelo)
    {
        try
        {
            // Para cada registro de resultado en la consulta 
            while (rs.next())
            {
                // Se crea y rellena la fila para el modelo de la tabla.
                Object[] datosFila = new Object[modelo.getColumnCount()];
                for (int i = 0; i < modelo.getColumnCount(); i++)
                    datosFila[i] = rs.getObject(i + 1);
                modelo.addRow(datosFila);
            }
            rs.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Borra todas las filas del modelo.
     * @param modelo El modelo para la tabla.
     */
    private static void vaciaFilasModelo(final DefaultTableModel modelo)
    {
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
    }

    /**
     * Pone en el modelo para la tabla tantas columnas como tiene el resultado
     * de la consulta a base de datos.
     * @param rs Resultado de consulta a base de datos.
     * @param modelo Modelo de la tabla.
     */
    public static void configuraColumnas(final ResultSet rs, final DefaultTableModel modelo)
    {
        try
        {
            // Se obtiene los metadatos de la consulta. Con ellos
            // podemos obtener el n�mero de columnas y el nombre
            // de las mismas.
            ResultSetMetaData metaDatos = rs.getMetaData();

            // Se obtiene el numero de columnas.
            int numeroColumnas = metaDatos.getColumnCount();

            // Se obtienen las etiquetas para cada columna
            Object[] etiquetas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++)
            {
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }

            // Se meten las etiquetas en el modelo. El numero
            // de columnas se ajusta autom�ticamente.
            modelo.setColumnIdentifiers(etiquetas);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
