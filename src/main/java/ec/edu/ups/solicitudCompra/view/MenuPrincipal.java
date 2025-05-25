package ec.edu.ups.solicitudCompra.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipal extends Frame {

    private Button btnRegistrarProveedor;
    private Button btnRegistrarProducto;
    private Button btnRegistrarSolicitud;
    private Button btnListarProveedores;
    private Button btnListarProductos;
    private Button btnListarSolicitudes;
    private Button btnBuscarProveedor;
    private Button btnBuscarProducto;
    private Button btnBuscarSolicitud;
    private Button btnCambiarEstado;
    private Button btnCalcularTotal;

    public MenuPrincipal() {
        setTitle("Sistema de Gestión de Compras");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.PINK);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.exit(0);
            }
        });
        Panel panel = new Panel(new GridLayout(11, 1, 5, 5));

        btnRegistrarProveedor = new Button("1. Registrar proveedor");
        btnRegistrarProducto = new Button("2. Registrar producto");
        btnRegistrarSolicitud = new Button("3. Registrar solicitud de compra");
        btnListarProveedores = new Button("4. Listar proveedores");
        btnListarProductos = new Button("5. Listar productos");
        btnListarSolicitudes = new Button("6. Listar solicitudes de compra");
        btnBuscarProveedor = new Button("7. Buscar proveedor por ID");
        btnBuscarProducto = new Button("8. Buscar producto por nombre");
        btnBuscarSolicitud = new Button("9. Buscar solicitud por número");
        btnCambiarEstado = new Button("10. Aprobar / Rechazar solicitud");
        btnCalcularTotal = new Button("11. Calcular total de una solicitud");



        panel.add(btnRegistrarProveedor);
        panel.add(btnRegistrarProducto);
        panel.add(btnRegistrarSolicitud);
        panel.add(btnListarProveedores);
        panel.add(btnListarProductos);
        panel.add(btnListarSolicitudes);
        panel.add(btnBuscarProveedor);
        panel.add(btnBuscarProducto);
        panel.add(btnBuscarSolicitud);
        panel.add(btnCambiarEstado);
        panel.add(btnCalcularTotal);

        add(panel);
    }

    public void addBtnRegistrarProveedorListener(ActionListener listener) {
        btnRegistrarProveedor.addActionListener(listener);
    }

}



