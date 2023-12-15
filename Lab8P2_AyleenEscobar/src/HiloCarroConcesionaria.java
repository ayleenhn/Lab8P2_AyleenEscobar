
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

public class HiloCarroConcesionaria extends Thread{
    private ArrayList<Carro> carros;
    private DefaultTableModel modelo;
    private String paisSeleccionado;

    public HiloCarroConcesionaria(ArrayList<Carro> carros, DefaultTableModel modelo, String paisSeleccionado) {
        this.carros = carros;
        this.modelo = modelo;
        this.paisSeleccionado = paisSeleccionado;
    }

    @Override
    public void run() {
        for (Carro car : carros) {
            if (car.getPais().equals(paisSeleccionado)) {
                SwingUtilities.invokeLater(() -> {
                    Object[] newrow = {
                        car.getMarca(),
                        car.getModelo(),
                        car.getYear(),
                        car.getPrecio()
                    };
                    modelo.addRow(newrow);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
