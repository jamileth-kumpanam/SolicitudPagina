package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.models.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBuscarProveedorID extends Frame {

    private TextField txtId;
    private TextArea resultado;
    private Button btnBuscar;
    private ProveedorController proveedorController;

    public MenuBuscarProveedorID(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Buscar Proveedor por ID");
        setSize(400, 250);
        setLayout(null);
        setVisible(true);

        Label lblId = new Label("ID del Proveedor:");
        lblId.setBounds(30, 50, 120, 25);
        add(lblId);

        txtId = new TextField();
        txtId.setBounds(160, 50, 180, 25);
        add(txtId);

        btnBuscar = new Button("Buscar");
        btnBuscar.setBounds(160, 90, 100, 30);
        add(btnBuscar);

        resultado = new TextArea();
        resultado.setBounds(30, 140, 310, 80);
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
                buscarProveedor();
            }
        });
    }

    private void buscarProveedor() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            mostrarMensaje("Ingrese un ID de proveedor.");
            return;
        }

        Proveedor proveedor = proveedorController.buscarPorId(id);
        if (proveedor == null) {
            resultado.setText("Proveedor no encontrado con ID: " + id);
        } else {
            resultado.setText(proveedor.toString());
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