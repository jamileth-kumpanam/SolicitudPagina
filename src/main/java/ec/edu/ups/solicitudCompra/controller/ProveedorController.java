package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {

    private List<Proveedor> listaProveedores;

    public ProveedorController() {
        listaProveedores = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        listaProveedores.add(proveedor);
    }

    public Proveedor buscarPorId(String id) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getId().equalsIgnoreCase(id)) {
                return proveedor;
            }
        }
        return null;
    }

    public List<Proveedor> listarProveedores() {
        return listaProveedores;
    }
}

