
import java.io.*;
import java.util.*;


//tempo es para que lea cualquier tipo de objeto, en este caso
// Carro, Usuario, etc
public class AdministrarDatos <Tempo>{
    private ArrayList<Tempo> ArchList = new ArrayList();
    private File archivo = null;
    
    public AdministrarDatos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Tempo> getArchList() {
        return ArchList;
    }

    public void setArchList(ArrayList<Tempo> ArchList) {
        this.ArchList = ArchList;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void cargarArchivo() {
        try (FileInputStream entrada = new FileInputStream(archivo);
             ObjectInputStream objeto = new ObjectInputStream(entrada)) {

            ArchList.clear(); // Limpiar el ArrayList

            try {
                while (true) {
                    Tempo temp = (Tempo) objeto.readObject();
                    ArchList.add(temp);
                }
            } catch (EOFException e) {
                // Se alcanzó el final del archivo
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Tempo t : ArchList) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally { // siempre se ejecuta el finally, se pone por elegancia e opcional
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
