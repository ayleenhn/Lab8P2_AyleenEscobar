
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;


public class Carro implements Serializable{
    private String marca, modelo;
    private Color color;
    private double precio;
    private ArrayList<Partes> mejorasVisuales;
    private String pais;
    private int year;
    private boolean Reconstruido;
    private int horsepower;
    private int velocidadPunta;
    private double tiempo;
    private Circuito circuito;
    
    private static final long SerialVersionUID=888L;

    public Carro() {
    }

    public Carro(String marca, String modelo, Color color, double precio, ArrayList<Partes> mejorasVisuales, 
                    String pais, int year, boolean Reconstruido, int horsepower, int velocidadPunta, double tiempo, Circuito circuito) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.mejorasVisuales = mejorasVisuales;
        this.pais = pais;
        this.year = year;
        this.Reconstruido = Reconstruido;
        this.horsepower = horsepower;
        this.velocidadPunta = velocidadPunta;
        this.tiempo = tiempo;
        this.circuito = circuito;
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

    public ArrayList<Partes> getMejorasVisuales() {
        return mejorasVisuales;
    }

    public void setMejorasVisuales(ArrayList<Partes> mejorasVisuales) {
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getVelocidadPunta() {
        return velocidadPunta;
    }

    public void setVelocidadPunta(int velocidadPunta) {
        this.velocidadPunta = velocidadPunta;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }
    
    @Override
    public String toString() {
        return marca;
    }
     
}
