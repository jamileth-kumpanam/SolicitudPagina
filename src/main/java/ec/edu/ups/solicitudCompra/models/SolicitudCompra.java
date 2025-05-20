package ec.edu.ups.solicitudCompra.models;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra implements Calculable, Estadoable {
    private String numero;
    private Proveedor proveedor;
    private List<DetalleCompra> detalles;
    private EstadoSolicitud estado;

    public SolicitudCompra(String numero, Proveedor proveedor) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.detalles = new ArrayList<>();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        detalles.add(new DetalleCompra(producto, cantidad));
    }

    public String getNumero() {
        return numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoSolicitud nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public void aprobar() {
        cambiarEstado(EstadoSolicitud.APROBADA);
    }

    @Override
    public void rechazar() {
        cambiarEstado(EstadoSolicitud.RECHAZADA);
    }

    @Override
    public void enviarRevision() {
        cambiarEstado(EstadoSolicitud.EN_REVISION);
    }

    @Override
    public double calcularCosto() {
        double total = 0;
        for (DetalleCompra detalle : detalles) {
            total += detalle.getProducto().getPrecio() * detalle.getCantidad();
        }
        return total;
    }

    @Override
    public String toString() {
        String nombreProveedor = (proveedor != null) ? proveedor.getNombre() : "Sin proveedor";
        return "Número: " + numero + ", Proveedor: " + nombreProveedor + ", Estado: " + estado + ", Total: " + calcularCosto();
    }
}
