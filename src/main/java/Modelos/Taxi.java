package Modelos;

import java.io.Serializable;

public class Taxi implements Serializable{

    private String marca;
    private String modelo;
    private String tipoCombustible;
    private String patente;
    private int  bajadaBandera;
    private int precioXKM;

    //region Constructores

    public Taxi(String marca, String modelo, String tipoCombustible, String patente, int bajadaBandera, int precioXKM) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
        this.bajadaBandera = bajadaBandera;
        this.precioXKM = precioXKM;
    }
     public Taxi(){}
    //endregion

    //region getters and setters

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

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getBajadaBandera() {
        return bajadaBandera;
    }

    public void setBajadaBandera(int bajadaBandera) {
        this.bajadaBandera = bajadaBandera;
    }

    public int getPrecioXKM() {
        return precioXKM;
    }

    public void setPrecioXKM(int precioXKM) {
        this.precioXKM = precioXKM;
    }
    //endregion

    //region equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taxi taxi)) return false;

        return getPatente() != null ? getPatente().equals(taxi.getPatente()) : taxi.getPatente() == null;
    }

    @Override
    public int hashCode() {
        return getPatente() != null ? getPatente().hashCode() : 0;
    }

    //endregion

    //toString


    @Override
    public String toString() {
        return "Taxi{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", patente='" + patente + '\'' +
                ", bajadaBandera=" + bajadaBandera +
                ", precioXKM=" + precioXKM +
                '}';
    }
}
