package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProveedorView extends Frame {

    private TextField txtId, txtNombre, txtTelefono, txtDireccion;
    private Button btnGuardar;
    private ProveedorController proveedorController;

    public RegistrarProveedorView(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Registrar Proveedor");
        setSize(350, 300);
        setLayout(null);
        setVisible(true);

        Label lblId = new Label("ID:");
        lblId.setBounds(30, 50, 80, 25);
        add(lblId);

        txtId = new TextField();
        txtId.setBounds(120, 50, 180, 25);
        add(txtId);

        Label lblNombre = new Label("Nombre:");
        lblNombre.setBounds(30, 90, 80, 25);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(120, 90, 180, 25);
        add(txtNombre);

        Label lblTelefono = new Label("Teléfono:");
        lblTelefono.setBounds(30, 130, 80, 25);
        add(lblTelefono);

        txtTelefono = new TextField();
        txtTelefono.setBounds(120, 130, 180, 25);
        add(txtTelefono);

        Label lblDireccion = new Label("Dirección:");
        lblDireccion.setBounds(30, 170, 80, 25);
        add(lblDireccion);

        txtDireccion = new TextField();
        txtDireccion.setBounds(120, 170, 180, 25);
        add(txtDireccion);

        btnGuardar = new Button("Registrar");
        btnGuardar.setBounds(120, 210, 100, 30);
        add(btnGuardar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProveedor();
            }
        });
    }

    private void guardarProveedor() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        if (proveedorController.buscarPorId(id) != null) {
            mostrarMensaje("Ya existe un proveedor con ese ID.");
            return;
        }

        Proveedor proveedor = new Proveedor(id, nombre, telefono, direccion);
        proveedorController.agregarProveedor(proveedor);
        mostrarMensaje("¡Proveedor registrado exitosamente!");

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
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}

