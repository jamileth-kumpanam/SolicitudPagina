package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.controller.ProductoController;
import ec.edu.ups.solicitudCompra.controller.SolicitudController;
import ec.edu.ups.solicitudCompra.models.Proveedor;
import ec.edu.ups.solicitudCompra.models.Producto;
import ec.edu.ups.solicitudCompra.models.SolicitudCompra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuBuscarSolicitudNumero extends Frame {

    private TextField txtNumeroSolicitud, txtCantidad;
    private Choice choiceProveedores, choiceProductos;
    private Button btnRegistrar;
    private ProveedorController proveedorController;
    private ProductoController productoController;
    private SolicitudController solicitudController; // <-- agregar referencia

    public MenuBuscarSolicitudNumero(SolicitudController solicitudController) { // <-- recibe SolicitudController
        this.proveedorController = proveedorController;
        this.productoController = productoController;
        this.solicitudController = solicitudController;

        setTitle("Registrar Solicitud de Compra");
        setSize(450, 350);
        setLayout(null);
        setVisible(true);

        Label lblNumero = new Label("N° Solicitud:");
        lblNumero.setBounds(30, 50, 120, 25);
        add(lblNumero);

        txtNumeroSolicitud = new TextField();
        txtNumeroSolicitud.setBounds(160, 50, 230, 25);
        add(txtNumeroSolicitud);

        Label lblProveedor = new Label("Proveedor:");
        lblProveedor.setBounds(30, 90, 120, 25);
        add(lblProveedor);

        choiceProveedores = new Choice();
        choiceProveedores.setBounds(160, 90, 230, 25);
        add(choiceProveedores);

        Label lblCantidad = new Label("Cantidad:");
        lblCantidad.setBounds(30, 130, 120, 25);
        add(lblCantidad);

        txtCantidad = new TextField();
        txtCantidad.setBounds(160, 130, 230, 25);
        add(txtCantidad);

        Label lblProducto = new Label("Producto:");
        lblProducto.setBounds(30, 170, 120, 25);
        add(lblProducto);

        choiceProductos = new Choice();
        choiceProductos.setBounds(160, 170, 230, 25);
        add(choiceProductos);

        btnRegistrar = new Button("Registrar Solicitud");
        btnRegistrar.setBounds(140, 220, 160, 35);
        add(btnRegistrar);

        // cerrar con la X
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        cargarProveedores();
        cargarProductos();

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarSolicitud();
            }
        });
    }

    private void cargarProveedores() {
        List<Proveedor> proveedores = proveedorController.listarProveedores();
        for (Proveedor proveedor : proveedores) {
            choiceProveedores.add(proveedor.getId() + " - " + proveedor.getNombre());
        }
    }

    private void cargarProductos() {
        List<Producto> productos = productoController.listarProductos();
        for (Producto producto : productos) {
            choiceProductos.add(producto.getId() + " - " + producto.getNombre());
        }
    }

    private void registrarSolicitud() {
        String numero = txtNumeroSolicitud.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();
        String proveedorStr = choiceProveedores.getSelectedItem();
        String productoStr = choiceProductos.getSelectedItem();

        if (numero.isEmpty() || cantidadStr.isEmpty() || proveedorStr == null || productoStr == null) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            mostrarMensaje("Cantidad inválida.");
            return;
        }

        String proveedorId = proveedorStr.split(" - ")[0];
        String productoId = productoStr.split(" - ")[0];

        Proveedor proveedor = proveedorController.buscarPorId(proveedorId);
        Producto producto = productoController.buscarPorId(productoId);

        if (proveedor == null || producto == null) {
            mostrarMensaje("Proveedor o producto no encontrados.");
            return;
        }

        SolicitudCompra solicitud = new SolicitudCompra(numero, proveedor, producto, cantidad);
        solicitudController.agregarSolicitud(solicitud);  // <-- CORRECCIÓN importante

        mostrarMensaje("¡Solicitud registrada exitosamente!");
        limpiarCampos();
    }

    private void mostrarMensaje(String mensaje) {
        Dialog dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(280, 100);
        dialogo.add(new Label(mensaje));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialogo.dispose());
        dialogo.add(ok);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void limpiarCampos() {
        txtNumeroSolicitud.setText("");
        txtCantidad.setText("");
    }
}

