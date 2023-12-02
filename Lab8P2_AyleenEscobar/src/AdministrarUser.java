
import java.io.*;
import java.util.*;

public class AdministrarUser{
    private ArrayList<Usuario> UsuarioLista = new ArrayList<>();
    private File archivo = null;

    public AdministrarUser(String path) {
        archivo = new File(path);
    }

    public ArrayList<Usuario> getUsuarioLista() {
        return UsuarioLista;
    }

    public void setUsuarioLista(ArrayList<Usuario> UsuarioLista) {
        this.UsuarioLista = UsuarioLista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setUsuario(Usuario u){
        UsuarioLista.add(u);
    }
    
    public void cargarArchivo() {
        try {            
            UsuarioLista = new ArrayList();
            Usuario temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Usuario) objeto.readObject()) != null) {
                        UsuarioLista.add(temp);
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
            for (Usuario t : UsuarioLista) {
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
