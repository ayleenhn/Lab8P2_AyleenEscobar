
import java.awt.Color;
import java.util.ArrayList;


public class Carro {
    private String marca, modelo;
    private Color color;
    private double precio;
    private ArrayList<String> mejorasVisuales;
    private String pais;
    private int year;
    private boolean Reconstruido;

    public Carro() {
    }

    public Carro(String marca, String modelo, Color color, double precio, ArrayList<String> mejorasVisuales, String pais, int year, boolean Reconstruido) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.mejorasVisuales = mejorasVisuales;
        this.pais = pais;
        this.year = year;
        this.Reconstruido = Reconstruido;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getMejorasVisuales() {
        return mejorasVisuales;
    }

    public void setMejorasVisuales(ArrayList<String> mejorasVisuales) {
        this.mejorasVisuales = mejorasVisuales;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isReconstruido() {
        return Reconstruido;
    }

    public void setReconstruido(boolean Reconstruido) {
        this.Reconstruido = Reconstruido;
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio=" + precio + ", mejorasVisuales=" + mejorasVisuales + ", pais=" + pais + ", year=" + year + ", Reconstruido=" + Reconstruido + '}';
    }
    
    
}
