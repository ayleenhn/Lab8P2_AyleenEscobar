
import java.util.ArrayList;
import java.util.Date;


public class Usuario {
    //Nombre, correo, pais de residencia y fecha de nacimiento
    private String nombre, correo, pais,usuario, password;
    private int saldo;
    private Date date;
    private ArrayList<Carro> Carros;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String pais, String usuario, String password, int saldo, Date date) {
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
        this.usuario = usuario;
        this.password = password;
        this.saldo = saldo;
        this.date = date;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Carro> getCarros() {
        return Carros;
    }

    public void setCarros(ArrayList<Carro> Carros) {
        this.Carros = Carros;
    }
    
    @Override
    public String toString() {
        return usuario;
    }
     
}
