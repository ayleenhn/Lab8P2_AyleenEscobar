
public class Circuito {
   private double longitud;
    private int Cantidad_Curvas;
    private String tipo;
    private String locacion;

    public Circuito() {
    }

    public Circuito(double longitud, int Cantidad_Curvas, String tipo, String locacion) {
        this.longitud = longitud;
        this.Cantidad_Curvas = Cantidad_Curvas;
        this.tipo = tipo;
        this.locacion = locacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantidad_Curvas() {
        return Cantidad_Curvas;
    }

    public void setCantidad_Curvas(int Cantidad_Curvas) {
        this.Cantidad_Curvas = Cantidad_Curvas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    @Override
    public String toString() {
        return "Circuito{" +
                "longitud=" + longitud +
                ", Cantidad_Curvas=" + Cantidad_Curvas +
                ", tipo='" + tipo + '\'' +
                ", locacion='" + locacion + '\'' +
                '}';
    } 
}
