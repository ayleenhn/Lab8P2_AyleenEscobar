
import javax.swing.JProgressBar;


public class adminBarraInicio extends Thread {
    private JProgressBar barra;
    private boolean usuarioEncontrado;
    private boolean contraCorrecta;

    public adminBarraInicio(JProgressBar barra, boolean usuarioEncontrado, boolean contraCorrecta) {
        this.barra = barra;
        this.usuarioEncontrado = usuarioEncontrado;
        this.contraCorrecta = contraCorrecta;
    }

    @Override
    public void run() {
        while (!usuarioEncontrado) {
            if (contraCorrecta) {
                barra.setValue(barra.getValue() + 1);
                if (barra.getValue() == 100) {
                    usuarioEncontrado = true;
                }
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}