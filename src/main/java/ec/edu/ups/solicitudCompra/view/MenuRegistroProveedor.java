package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;
import java.awt.*;
import java.awt.event.*;

public class MenuRegistroProveedor extends Frame {
    private TextField txtId, txtNombre, txtTelefono, txtDireccion;
    private Button btnGuardar;
    private ProveedorController controller;

    public MenuRegistroProveedor(ProveedorController controller) {
        this.controller = controller;
        setTitle("Registrar Proveedor");
        setSize(350, 300);
        setLayout(null);

        txtId = new TextField();
        txtNombre = new TextField();
        txtTelefono = new TextField();
        txtDireccion = new TextField();

        txtId.setBounds(120, 40, 200, 25);
        txtNombre.setBounds(120, 80, 200, 25);
        txtTelefono.setBounds(120, 120, 200, 25);
        txtDireccion.setBounds(120, 160, 200, 25);

        add(new Label("ID:")).setBounds(20, 40, 100, 25);
        add(new Label("Nombre:")).setBounds(20, 80, 100, 25);
        add(new Label("Teléfono:")).setBounds(20, 120, 100, 25);
        add(new Label("Dirección:")).setBounds(20, 160, 100, 25);

        btnGuardar = new Button("Guardar");
        btnGuardar.setBounds(120, 210, 100, 30);
        btnGuardar.addActionListener(e -> guardarProveedor());

        add(txtId);
        add(txtNombre);
        add(txtTelefono);
        add(txtDireccion);
        add(btnGuardar);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void guardarProveedor() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        Proveedor proveedor = new Proveedor(id, nombre, telefono, direccion);
        controller.agregarProveedor(proveedor);
        mostrarMensaje("Proveedor registrado exitosamente.");
        limpiarCampos();
    }

    private void mostrarMensaje(String mensaje) {
        Dialog dialog = new Dialog(this, "Mensaje", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(mensaje));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialog.dispose());
        dialog.add(ok);
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
}
