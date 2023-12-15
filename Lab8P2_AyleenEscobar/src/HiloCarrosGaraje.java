
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

public class HiloCarrosGaraje extends Thread {
    private ArrayList<Carro> carros;
    private DefaultTableModel modelo;

    public HiloCarrosGaraje(ArrayList<Carro> carros, DefaultTableModel modelo) {
        this.carros = carros;
        this.modelo = modelo;
    }

    @Override
    public void run() {
        for (Carro car : carros) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            SwingUtilities.invokeLater(() -> {
                Object[] newrow = {
                        car.getMarca(),
                        car.getModelo(),
                        car.getYear(),
                        car.getPrecio()
                };
                modelo.addRow(newrow);
            });
        }
    }
}
