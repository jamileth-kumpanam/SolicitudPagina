package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import java.awt.*;
import java.util.List;

public class MenuListarProveedores extends Frame {

    private TextArea areaListado;
    private ProveedorController proveedorController;

    public MenuListarProveedores(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Lista de Proveedores");
        setSize(500, 300);
        setLayout(null);
        setVisible(true);

        areaListado = new TextArea();
        areaListado.setBounds(30, 50, 440, 200);
        areaListado.setEditable(false);
        add(areaListado);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        cargarListado();
    }

    private void cargarListado() {
        List<Proveedor> lista = proveedorController.listarProveedores();
        StringBuilder sb = new StringBuilder();
        for (Proveedor proveedor : lista) {
            sb.append(proveedor.toString()).append("\n");
        }
        areaListado.setText(sb.toString());
    }
}
