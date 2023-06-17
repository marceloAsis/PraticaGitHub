package Modelos;

import java.io.Serializable;

public class Remis implements Serializable {

    private String marca;
    private String modelo;
    private String tipoCombustible;
    private String patente;
    private int tarifaXCuadra;

    //region constructores
     public Remis(){}
    public Remis(String marca, String modelo, String tipoCombustible, String patente, int tarifaXCuadra) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
        this.tarifaXCuadra = tarifaXCuadra;
    }
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

    public int getTarifaXCuadra() {
        return tarifaXCuadra;
    }

    public void setTarifaXCuadra(int tarifaXCuadra) {
        this.tarifaXCuadra = tarifaXCuadra;
    }

    //endregion

    //region hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Remis remis)) return false;

        return getPatente() != null ? getPatente().equals(remis.getPatente()) : remis.getPatente() == null;
    }

    @Override
    public int hashCode() {
        return getPatente() != null ? getPatente().hashCode() : 0;
    }
    //endregion

    //toString

    @Override
    public String toString() {
        return "Remis{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", patente='" + patente + '\'' +
                ", tarifaXCuadra=" + tarifaXCuadra +
                '}';
    }
}
