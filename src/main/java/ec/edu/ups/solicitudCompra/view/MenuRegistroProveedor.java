package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import java.awt.*;
import java.awt.event.*;

public class MenuRegistroProveedor extends Frame {
    private TextField txtId, txtNombre, txtTelefono, txtDireccion;
    private Button btnGuardar;
    private ProveedorController proveedorController;

    public MenuRegistroProveedor(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Registrar Proveedor");
        setSize(300, 300);
        setLayout(null);

        Label lblId = new Label("ID:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);

        txtId = new TextField();
        txtId.setBounds(120, 20, 150, 25);
        add(txtId);

        Label lblNombre = new Label("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(120, 60, 150, 25);
        add(txtNombre);

        Label lblTelefono = new Label("Teléfono:");
        lblTelefono.setBounds(20, 100, 100, 25);
        add(lblTelefono);

        txtTelefono = new TextField();
        txtTelefono.setBounds(120, 100, 150, 25);
        add(txtTelefono);

        Label lblDireccion = new Label("Dirección:");
        lblDireccion.setBounds(20, 140, 100, 25);
        add(lblDireccion);

        txtDireccion = new TextField();
        txtDireccion.setBounds(120, 140, 150, 25);
        add(txtDireccion);

        btnGuardar = new Button("Guardar");
        btnGuardar.setBounds(100, 200, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProveedor();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
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
            showMessage("Todos los campos son obligatorios");
            return;
        }

        Proveedor proveedor = new Proveedor(id, nombre, telefono, direccion);
        proveedorController.agregarProveedor(proveedor);
        showMessage("Proveedor registrado correctamente");
        limpiarCampos();
    }

    private void showMessage(String message) {
        Dialog dialog = new Dialog(this, "Mensaje", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(250, 100);
        dialog.add(new Label(message));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialog.setVisible(false));
        dialog.add(ok);
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
