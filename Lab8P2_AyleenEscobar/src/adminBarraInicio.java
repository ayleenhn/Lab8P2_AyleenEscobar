
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


public class adminBarraInicio extends Thread {
    private JProgressBar barra;
    private boolean usuarioEncontrado;
    private boolean seguir;

    public adminBarraInicio(JProgressBar barra, boolean usuarioEncontrado, boolean seguir) {
        this.barra = barra;
        this.usuarioEncontrado = usuarioEncontrado;
        this.seguir = seguir;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setUsuarioEncontrado(boolean usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }

    public boolean isSeguir() {
        return seguir;
    }

    public void setSeguir(boolean seguir) {
        this.seguir = seguir;
    }
    

    @Override
    public void run() {
        while (!usuarioEncontrado) {
            if (seguir) {
                SwingUtilities.invokeLater(() -> {
                    barra.setValue(barra.getValue() + 1);
                    if (barra.getValue() == 100) {
                        usuarioEncontrado = true;
                    }
                });
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }
}