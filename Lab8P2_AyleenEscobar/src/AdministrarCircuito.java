
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdministrarCircuito {
    private ArrayList<Circuito> listaCircuitos = new ArrayList<>();
    private File archivo = null;

    public AdministrarCircuito(String path) {
        archivo = new File(path);
    }

    public ArrayList<Circuito> getListaCircuitos() {
        return listaCircuitos;
    }

    public void setListaCircuitos(ArrayList<Circuito> listaCircuitos) {
        this.listaCircuitos = listaCircuitos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setCircuito(Circuito c) {
        listaCircuitos.add(c);
    }

    public void cargarArchivo() {
        try {
            listaCircuitos = new ArrayList<>();
            Circuito temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Circuito) objeto.readObject()) != null) {
                        listaCircuitos.add(temp);
                    }
                } catch (EOFException e) {
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Circuito t : listaCircuitos) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
