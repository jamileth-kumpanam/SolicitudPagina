package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRegistroProveedor extends Frame {
    private TextField txtId, txtNombre, txtTelefono, txtDireccion;
    private Button btnGuardar;
    private ProveedorController proveedorController;

    public MenuRegistroProveedor(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Registrar Proveedor");
        setSize(350, 300);
        setLayout(null);

        Label lblId = new Label("ID:");
        lblId.setBounds(20, 40, 100, 25);
        add(lblId);

        txtId = new TextField();
        txtId.setBounds(120, 40, 200, 25);
        add(txtId);

        Label lblNombre = new Label("Nombre:");
        lblNombre.setBounds(20, 80, 100, 25);
        add(lblNombre);

        txtNombre = new TextField();
        txtNombre.setBounds(120, 80, 200, 25);
        add(txtNombre);

        Label lblTelefono = new Label("Teléfono:");
        lblTelefono.setBounds(20, 120, 100, 25);
        add(lblTelefono);

        txtTelefono = new TextField();
        txtTelefono.setBounds(120, 120, 200, 25);
        add(txtTelefono);

        Label lblDireccion = new Label("Dirección:");
        lblDireccion.setBounds(20, 160, 100, 25);
        add(lblDireccion);

        txtDireccion = new TextField();
        txtDireccion.setBounds(120, 160, 200, 25);
        add(txtDireccion);

        btnGuardar = new Button("Guardar");
        btnGuardar.setBounds(120, 210, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProveedor();
            }
        });

        setVisible(true);
    }

    private void guardarProveedor() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            showDialog("Todos los campos son obligatorios.");
            return;
        }

        Proveedor proveedor = new Proveedor(id, nombre, telefono, direccion);
        proveedorController.agregarProveedor(proveedor);
        showDialog("Proveedor registrado correctamente.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

    private void showDialog(String mensaje) {
        Dialog dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(250, 100);
        dialogo.add(new Label(mensaje));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialogo.setVisible(false));
        dialogo.add(ok);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
}
