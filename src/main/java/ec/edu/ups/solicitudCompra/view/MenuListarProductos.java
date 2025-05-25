package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProductoController;
import ec.edu.ups.solicitudCompra.models.Producto;

import java.awt.*;
import java.util.List;

public class MenuListarProductos extends Frame {

    private TextArea areaListado;
    private ProductoController productoController;

    public MenuListarProductos(ProductoController productoController) {
        this.productoController = productoController;

        setTitle("Lista de Productos");
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
        List<Producto> lista = productoController.listarProductos();
        StringBuilder sb = new StringBuilder();
        for (Producto producto : lista) {
            sb.append(producto.toString()).append("\n");
        }
        areaListado.setText(sb.toString());
    }
}
