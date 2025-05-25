package ec.edu.ups.solicitudCompra.models;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona {
    private final List<Producto> productos;

    // Constructor completo
    public Proveedor(String id, String nombre, String apellido, String telefono, String direccion) {
        super(id, nombre, apellido, telefono, direccion);
        this.productos = new ArrayList<>();
    }

    // Constructor sin apellido (opcional para flexibilidad)
    public Proveedor(String id, String nombre, String telefono, String direccion) {
        super(id, nombre, "", telefono, direccion);
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "ID='" + getId() + '\'' +
                ", Nombre='" + getNombre() + " " + getApellido() + '\'' +
                ", Teléfono='" + getTelefono() + '\'' +
                ", Dirección='" + getDireccion() + '\'' +
                ", Productos=" + productos.size() +
                '}';
    }
}

