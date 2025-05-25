package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProductoController;
import ec.edu.ups.solicitudCompra.models.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuBuscarProductoNombre extends Frame {

    private TextField txtNombre;
    private TextArea resultado;
    private Button btnBuscar;
    private ProductoController productoController;

    public MenuBuscarProductoNombre(ProductoController productoController) {
        this.productoController = productoController;

        setTitle("Buscar Producto por Nombre");
        setSize(450, 300);
        setLayout(null);
        setVisible(true);

        Label lblNombre = new Label("Nombre del Producto:");
        lblNombre.setBounds(30, 50, 140, 25);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(180, 50, 200, 25);
        add(txtNombre);

        btnBuscar = new Button("Buscar");
        btnBuscar.setBounds(180, 90, 100, 30);
        add(btnBuscar);

        resultado = new TextArea();
        resultado.setBounds(30, 140, 370, 120);
        resultado.setEditable(false);
        add(resultado);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
    }

    private void buscarProducto() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            mostrarMensaje("Ingrese el nombre del producto.");
            return;
        }

        List<Producto> productos = productoController.buscarPorNombre(nombre);
        if (productos.isEmpty()) {
            resultado.setText("No se encontraron productos con ese nombre.");
        } else {
            StringBuilder sb = new StringBuilder("Resultados:\n");
            for (Producto p : productos) {
                sb.append(p.toString()).append("\n");
            }
            resultado.setText(sb.toString());
        }
    }

    private void mostrarMensaje(String mensaje) {
        Dialog dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(250, 100);
        dialogo.add(new Label(mensaje));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialogo.dispose());
        dialogo.add(ok);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
}

