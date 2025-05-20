package ec.edu.ups.solicitudCompra.models;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends  Persona {
    private List<Producto> productos;

    public Proveedor(String id, String nombre, String apellido, String telefono, String direccion) {
        super(id, nombre, apellido, telefono, direccion);
        this.productos = new ArrayList<>();
    }

    public Proveedor(String id, String nombre, String telefono, String direccion) {
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
        return super.toString() + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }
}
