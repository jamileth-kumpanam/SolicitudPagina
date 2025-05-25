package ec.edu.ups.solicitudCompra.models;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Persona(String id, String nombre, String apellido, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }
}

