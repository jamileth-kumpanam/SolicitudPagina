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
    private Button btnBuscar;
    private Label lblTotal;
    private ProveedorController proveedorController;
    private ProductoController productoController;
    private SolicitudController solicitudController;

    public MenuBuscarSolicitudNumero(SolicitudController solicitudController,
                                     ProveedorController proveedorController,
                                     ProductoController productoController) {
        this.solicitudController = solicitudController;
        this.proveedorController = proveedorController;
        this.productoController = productoController;

        setTitle("Buscar Solicitud por Número");
        setSize(450, 400);
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
        txtCantidad.setEditable(false); // solo lectura
        add(txtCantidad);

        Label lblProducto = new Label("Producto:");
        lblProducto.setBounds(30, 170, 120, 25);
        add(lblProducto);

        choiceProductos = new Choice();
        choiceProductos.setBounds(160, 170, 230, 25);
        add(choiceProductos);

        Label lblTotalTexto = new Label("Total:");
        lblTotalTexto.setBounds(30, 210, 120, 25);
        add(lblTotalTexto);

        lblTotal = new Label("$0.00");
        lblTotal.setBounds(160, 210, 230, 25);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTotal);

        btnBuscar = new Button("Buscar Solicitud");
        btnBuscar.setBounds(140, 260, 160, 35);
        add(btnBuscar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        cargarProveedores();
        cargarProductos();

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarSolicitudPorNumero();
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

    private void buscarSolicitudPorNumero() {
        String numero = txtNumeroSolicitud.getText().trim();

        if (numero.isEmpty()) {
            mostrarMensaje("Ingrese un número de solicitud.");
            return;
        }

        SolicitudCompra solicitud = solicitudController.buscarPorNumero(numero);

        if (solicitud == null) {
            mostrarMensaje("Solicitud no encontrada.");
            return;
        }

        txtCantidad.setText(String.valueOf(solicitud.getCantidad()));

        for (int i = 0; i < choiceProveedores.getItemCount(); i++) {
            if (choiceProveedores.getItem(i).startsWith(solicitud.getProveedor().getId())) {
                choiceProveedores.select(i);
                break;
            }
        }

        for (int i = 0; i < choiceProductos.getItemCount(); i++) {
            if (choiceProductos.getItem(i).startsWith(solicitud.getProducto().getId())) {
                choiceProductos.select(i);
                break;
            }
        }

        double total = solicitud.getProducto().getPrecio() * solicitud.getCantidad();
        lblTotal.setText("$" + String.format("%.2f", total));

        mostrarMensaje("Solicitud encontrada y cargada.");
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
}
