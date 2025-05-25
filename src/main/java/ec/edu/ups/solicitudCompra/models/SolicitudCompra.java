package ec.edu.ups.solicitudCompra.models;

public class SolicitudCompra {

    private String numero;
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad;
    private String estado;

    public SolicitudCompra(String numero, Proveedor proveedor, Producto producto, int cantidad) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "SolicitudCompra{" +
                "numero='" + numero + '\'' +
                ", proveedor=" + (proveedor != null ? proveedor.getNombre() : "null") +
                ", producto=" + (producto != null ? producto.getNombre() : "null") +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SolicitudCompra that = (SolicitudCompra) obj;
        return numero != null && numero.equalsIgnoreCase(that.numero);
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.toLowerCase().hashCode() : 0;
    }
}
