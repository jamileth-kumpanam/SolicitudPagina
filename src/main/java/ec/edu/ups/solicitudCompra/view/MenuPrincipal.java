package ec.edu.ups.solicitudCompra.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    private JButton btnRegistrarProveedor;
    private JButton btnRegistrarProducto;
    private JButton btnRegistrarSolicitud;
    private JButton btnListarProveedores;
    private JButton btnListarProductos;
    private JButton btnListarSolicitudes;
    private JButton btnBuscarProveedor;
    private JButton btnBuscarProducto;
    private JButton btnBuscarSolicitud;
    private JButton btnCambiarEstado;
    private JButton btnCalcularTotal;

    public MenuPrincipal() {
        setTitle("Sistema de Gestión de Compras");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel(new GridLayout(11, 1, 5, 5));

        btnRegistrarProveedor = new JButton("1. Registrar proveedor");
        btnRegistrarProducto = new JButton("2. Registrar producto");
        btnRegistrarSolicitud = new JButton("3. Registrar solicitud de compra");
        btnListarProveedores = new JButton("4. Listar proveedores");
        btnListarProductos = new JButton("5. Listar productos");
        btnListarSolicitudes = new JButton("6. Listar solicitudes de compra");
        btnBuscarProveedor = new JButton("7. Buscar proveedor por ID");
        btnBuscarProducto = new JButton("8. Buscar producto por nombre");
        btnBuscarSolicitud = new JButton("9. Buscar solicitud por número");
        btnCambiarEstado = new JButton("10. Aprobar / Rechazar solicitud");
        btnCalcularTotal = new JButton("11. Calcular total de una solicitud");

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



