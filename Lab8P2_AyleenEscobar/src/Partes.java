
import java.io.Serializable;

public class Partes implements Serializable{
    private String marca, clasificación;
    private double precio;
    private static final long serialVersionUID = 555L;
    
    public Partes() {
    }

    public Partes(String marca, String clasificación, double precio) {
        this.marca = marca;
        this.clasificación = clasificación;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getClasificación() {
        return clasificación;
    }

    public void setClasificación(String clasificación) {
        this.clasificación = clasificación;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
