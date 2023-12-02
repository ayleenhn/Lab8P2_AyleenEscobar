
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AdministrarPartes {
    private ArrayList<Partes> PartesLista = new ArrayList<>();
    private File archivo = null;

    public AdministrarPartes(String path) {
        archivo = new File(path);
    }

    public ArrayList<Partes> getPartesLista() {
        return PartesLista;
    }

    public void setPartesLista(ArrayList<Partes> PartesLista) {
        this.PartesLista = PartesLista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setParte(Partes p){
        PartesLista.add(p);
    }
    
    public void cargarArchivo() {
        try {            
            PartesLista = new ArrayList();
            Partes temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Partes) objeto.readObject()) != null) {
                        PartesLista.add(temp);
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
            for (Partes t : PartesLista) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
