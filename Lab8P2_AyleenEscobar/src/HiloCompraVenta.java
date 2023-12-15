import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class HiloCompraVenta extends Thread{
    private JProgressBar progressBar;
    private int duracion;

    public HiloCompraVenta(JProgressBar progressBar, int duracion) {
        this.progressBar = progressBar;
        this.duracion = duracion;
    }

    @Override
    public void run() {
        progressBar.setMaximum(duracion);

        for (int i = 0; i <= duracion; i += 100) {
            final int progreso = i;
            SwingUtilities.invokeLater(() -> {
                progressBar.setValue(progreso);
            });

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //se hace la compra venrta
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(0);
        });
    }
}
