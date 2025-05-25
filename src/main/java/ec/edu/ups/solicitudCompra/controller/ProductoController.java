package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoController {

    private List<Producto> listaProductos;

    public ProductoController() {
        listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto buscarPorId(String id) {
        for (Producto producto : listaProductos) {
            if (producto.getId().equalsIgnoreCase(id)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return listaProductos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Producto> listarProductos() {
        return listaProductos;
    }
}

