package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {
    private List<Proveedor> proveedores;

    public ProveedorController() {
        proveedores = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public Proveedor buscarPorId(String id) {
        for (Proveedor p : proveedores) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Proveedor> listarProveedores() {
        return proveedores;
    }
}

