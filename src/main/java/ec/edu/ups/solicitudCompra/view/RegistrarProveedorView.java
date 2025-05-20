package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProveedorView extends JFrame {
    private JTextField txtId, txtNombre, txtTelefono, txtDireccion;
    private JButton btnRegistrar;
    private ProveedorController proveedorController;

    public RegistrarProveedorView(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Registrar Proveedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtId = new JTextField(15);
        txtNombre = new JTextField(15);
        txtTelefono = new JTextField(15);
        txtDireccion = new JTextField(15);
        btnRegistrar = new JButton("Registrar");

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new JLabel());
        panel.add(btnRegistrar);

        add(panel);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String direccion = txtDireccion.getText().trim();

                if (id.isEmpty() || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID y Nombre son obligatorios.");
                    return;
                }

                if (proveedorController.buscarPorId(id) != null) {
                    JOptionPane.showMessageDialog(null, "Ya existe un proveedor con ese ID.");
                    return;
                }

                Proveedor nuevoProveedor = new Proveedor(id, nombre, telefono, direccion);
                proveedorController.agregarProveedor(nuevoProveedor);

                JOptionPane.showMessageDialog(null, "¡Proveedor registrado exitosamente!");

                txtId.setText("");
                txtNombre.setText("");
                txtTelefono.setText("");
                txtDireccion.setText("");
            }
        });
    }
}
