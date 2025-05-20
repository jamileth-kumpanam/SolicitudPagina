package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalView extends JFrame {
    private JButton btnRegistrarProveedor;
    private ProveedorController proveedorController;

    public MenuPrincipalView(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;

        setTitle("Menú Principal");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnRegistrarProveedor = new JButton("Registrar Proveedor");

        setLayout(new FlowLayout());
        add(btnRegistrarProveedor);

        btnRegistrarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarProveedorView registrarProveedorView = new RegistrarProveedorView(proveedorController);
                registrarProveedorView.setVisible(true);
            }
        });
    }
}
