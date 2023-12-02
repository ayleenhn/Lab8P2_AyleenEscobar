
import java.io.*;
import java.util.*;

public class AdministrarCarro{
    private ArrayList<Carro> ListaCarro = new ArrayList<>();
    private File archivo = null;

    public AdministrarCarro(String path) {
        archivo = new File(path);
    }

    public ArrayList<Carro> getListaCarro() {
        return ListaCarro;
    }

    public void setListaCarro(ArrayList<Carro> ListaCarro) {
        this.ListaCarro = ListaCarro;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setCarro(Carro c){
        ListaCarro.add(c);
    }
    
    public void cargarArchivo() {
        try {            
            ListaCarro = new ArrayList();
            Carro temp;
            if (archivo.exists()) {
                FileInputStream entrada= new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Carro) objeto.readObject()) != null) {
                        ListaCarro.add(temp);
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
            for (Carro t : ListaCarro) {
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
