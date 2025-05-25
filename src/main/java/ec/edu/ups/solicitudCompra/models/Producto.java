package ec.edu.ups.solicitudCompra.models;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private UnidadMedida unidad;
    private Proveedor proveedor;

    public Producto(String id, String nombre, double precio, UnidadMedida unidad, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.unidad = unidad;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Unidad: " + unidad;
    }
}
