package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProductoController;
import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Producto;
import ec.edu.ups.solicitudCompra.models.Proveedor;
import ec.edu.ups.solicitudCompra.models.UnidadMedida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuRegistrarProducto extends Frame {

    private TextField txtId, txtNombre, txtPrecio, txtUnidad;
    private Choice choiceProveedores;
    private Button btnRegistrar;
    private ProveedorController proveedorController;
    private ProductoController productoController;

    public MenuRegistrarProducto(ProveedorController proveedorController, ProductoController productoController) {
        this.proveedorController = proveedorController;
        this.productoController = productoController;

        setTitle("Registrar Producto");
        setSize(400, 350);
        setLayout(null);
        setVisible(true);

        Label lblId = new Label("ID:");
        lblId.setBounds(30, 50, 100, 25);
        add(lblId);

        txtId = new TextField();
        txtId.setBounds(140, 50, 200, 25);
        add(txtId);

        Label lblNombre = new Label("Nombre:");
        lblNombre.setBounds(30, 90, 100, 25);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(140, 90, 200, 25);
        add(txtNombre);

        Label lblPrecio = new Label("Precio:");
        lblPrecio.setBounds(30, 130, 100, 25);
        add(lblPrecio);

        txtPrecio = new TextField();
        txtPrecio.setBounds(140, 130, 200, 25);
        add(txtPrecio);

        Label lblUnidad = new Label("Unidad:");
        lblUnidad.setBounds(30, 170, 100, 25);
        add(lblUnidad);

        txtUnidad = new TextField();
        txtUnidad.setBounds(140, 170, 200, 25);
        add(txtUnidad);

        Label lblProveedor = new Label("Proveedor:");
        lblProveedor.setBounds(30, 210, 100, 25);
        add(lblProveedor);

        choiceProveedores = new Choice();
        choiceProveedores.setBounds(140, 210, 200, 25);
        add(choiceProveedores);

        cargarProveedores();

        btnRegistrar = new Button("Registrar");
        btnRegistrar.setBounds(140, 250, 100, 30);
        add(btnRegistrar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
    }

    private void cargarProveedores() {
        List<Proveedor> lista = proveedorController.listarProveedores();
        for (Proveedor proveedor : lista) {
            choiceProveedores.add(proveedor.getId() + " - " + proveedor.getNombre());
        }
    }

    private void registrarProducto() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String unidadStr = txtUnidad.getText().trim();
        String proveedorStr = choiceProveedores.getSelectedItem();

        if (id.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || unidadStr.isEmpty() || proveedorStr == null) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            mostrarMensaje("Precio inválido.");
            return;
        }

        UnidadMedida unidad;
        try {
            unidad = UnidadMedida.valueOf(unidadStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            mostrarMensaje("Unidad inválida. Ejemplos: LITRO, KILO, METRO, UNIDAD");
            return;
        }

        String proveedorId = proveedorStr.split(" - ")[0];
        Proveedor proveedor = proveedorController.buscarPorId(proveedorId);
        if (proveedor == null) {
            mostrarMensaje("Proveedor no encontrado.");
            return;
        }

        Producto producto = new Producto(id, nombre, precio, unidad, proveedor);
        productoController.agregarProducto(producto);

        mostrarMensaje("¡Producto registrado exitosamente!");
        limpiarCampos();
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

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtUnidad.setText("");
    }
}


