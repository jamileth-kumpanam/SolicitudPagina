package ec.edu.ups.solicitudCompra.persona;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellido, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public boolean validar() {
        return id != null && !id.isEmpty() && nombre != null && !nombre.isEmpty();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + id + ")";
    }
}
