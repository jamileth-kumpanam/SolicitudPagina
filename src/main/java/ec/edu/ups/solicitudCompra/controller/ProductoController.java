package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoController {
    private List<Producto> productos;

    public ProductoController() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }
}

