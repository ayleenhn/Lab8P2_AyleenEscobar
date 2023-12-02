
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AdministrarConcesionaria {
    private ArrayList<concesionaria> ConcesionariaLista = new ArrayList<>();
    private File archivo = null;

    public AdministrarConcesionaria(String path) {
        archivo = new File(path);
    }

    public ArrayList<concesionaria> getConcesionariaLista() {
        return ConcesionariaLista;
    }

    public void setConcesionariaLista(ArrayList<concesionaria> ConcesionariaLista) {
        this.ConcesionariaLista = ConcesionariaLista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setConcesionaria(concesionaria c){
        ConcesionariaLista.add(c);
    }
    
    public void cargarArchivo() {
        try {            
            ConcesionariaLista = new ArrayList();
            concesionaria temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (concesionaria) objeto.readObject()) != null) {
                        ConcesionariaLista.add(temp);
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
            for (concesionaria t : ConcesionariaLista) {
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

