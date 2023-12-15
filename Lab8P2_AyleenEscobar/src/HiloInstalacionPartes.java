import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HiloInstalacionPartes extends Thread{
    private ArrayList<Partes> Partes;
    private JTable jTableResultado;

    public HiloInstalacionPartes(ArrayList<Partes> Partes, JTable jTableResultado) {
        this.Partes = Partes;
        this.jTableResultado = jTableResultado;
    }

    @Override
    public void run() {
        DefaultTableModel modelo = (DefaultTableModel) jTableResultado.getModel();

        for (Partes parteVisual : Partes) {
            simularInstalacion(parteVisual, modelo);
        }
        mostrarTablaEnJDialog(modelo);
    }

    private void simularInstalacion(Partes parte, DefaultTableModel modelo) {
        int duracion = (int) (Math.random() * 8000) + 7000; // Entre 8 y 15 segundos

        try {
            Thread.sleep(duracion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double precioTotal = parte.getPrecio() /*+ parte.getModificador()*/;

        Object[] fila = {parte.getMarca(), parte.getPrecio(), duracion / 1000, precioTotal};
        modelo.addRow(fila);
    }

    private void mostrarTablaEnJDialog(DefaultTableModel modelo) {
        JTable jTable = new JTable(modelo);
        JOptionPane.showMessageDialog(null, jTable, "Resultado de instalación", JOptionPane.INFORMATION_MESSAGE);
    }
}
