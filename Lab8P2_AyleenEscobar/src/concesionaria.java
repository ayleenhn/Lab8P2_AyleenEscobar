
import java.io.Serializable;
import java.util.ArrayList;


public class concesionaria implements Serializable{
    private String nombre, locación;
    private ArrayList<Carro> listacarros;
    private static final long serialVersionUID = 444L;

    public concesionaria() {
    }

    public concesionaria(String nombre, String locación, ArrayList<Carro> listacarros) {
        this.nombre = nombre;
        this.locación = locación;
        this.listacarros = listacarros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocación() {
        return locación;
    }

    public void setLocación(String locación) {
        this.locación = locación;
    }

    public ArrayList<Carro> getListacarros() {
        return listacarros;
    }

    public void setListacarros(ArrayList<Carro> listacarros) {
        this.listacarros = listacarros;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
