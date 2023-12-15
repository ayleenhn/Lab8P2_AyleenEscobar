
import javax.swing.JProgressBar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class HiloCarrera extends Thread{
    private JProgressBar progressBarCarro1;
    private JProgressBar progressBarCarro2;
    private Carro carro1;
    private Carro carro2;
    
    public HiloCarrera(JProgressBar progressBarCarro1, JProgressBar progressBarCarro2, Carro carro1, Carro carro2) {
        this.progressBarCarro1 = progressBarCarro1;
        this.progressBarCarro2 = progressBarCarro2;
        this.carro1 = carro1;
        this.carro2 = carro2;
    }

     @Override
    public void run() {
        double distanciaTotal = carro1.getCircuito().getLongitud();
        Random random = new Random();

        while (carro1.getTiempo()< distanciaTotal && carro2.getTiempo()< distanciaTotal) {
            int avanceCarro1 = Avance(carro1);
            int avanceCarro2 = Avance(carro2);

            carro1.setTiempo(carro1.getTiempo() + avanceCarro1);
            carro2.setTiempo(carro2.getTiempo() + avanceCarro2);

            int porcentajeCarro1 = (int) (((double) carro1.getTiempo() / distanciaTotal) * 100);
            int porcentajeCarro2 = (int) (((double) carro2.getTiempo() / distanciaTotal) * 100);

            progressBarCarro1.setValue(porcentajeCarro1);
            progressBarCarro2.setValue(porcentajeCarro2);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (carro1.getTiempo() >= distanciaTotal && carro2.getTiempo() >= distanciaTotal) {
            JOptionPane.showMessageDialog(null, "¡TENEMOS UN EMPATE!");
        } else if (carro1.getTiempo() >= distanciaTotal) {
            JOptionPane.showMessageDialog(null, "¡El Carro 1 gano!");
        } else {
            JOptionPane.showMessageDialog(null, "¡El Carro 2 gano!");
        }
    }

    private int Avance(Carro carro) {
        switch (carro.getCircuito().getTipo()) {
            case CIRCUITO:
                return AvanceCircuito(carro);
            case OFF_ROAD:
                return AvanceOffRoad(carro);
            case DRAG:
                return AvanceDrag(carro);
            default:
                return 0;
        }
    }

    private int AvanceCircuito(Carro carro) {
        int velocidadBase = carro.getVelocidadPunta();
        double avance = velocidadBase * 0.01;
        return (int) avance;
    }

    private int AvanceOffRoad(Carro carro) {
        int horsepower = carro.getHorsepower();
        double avance = horsepower * 0.005;
        return (int) avance;
    }

    private int AvanceDrag(Carro carro) {
        double tiempo = carro.getTiempo();
        double avance = tiempo * 0.01;
        return (int) avance;
    }
}
