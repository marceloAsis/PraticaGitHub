package Modelos;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    ///regionconstructores
    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Cliente(){}
    //endregion


    //region getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //endregion

    //region hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        return getTelefono() != null ? getTelefono().equals(cliente.getTelefono()) : cliente.getTelefono() == null;
    }
    @Override
    public int hashCode() {
        return getTelefono() != null ? getTelefono().hashCode() : 0;
    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return
                "Nombre: "+nombre+
                "Apellido: "+apellido+
                "Telefono: "+telefono+
                "Direccion: "+direccion;
    }
}
