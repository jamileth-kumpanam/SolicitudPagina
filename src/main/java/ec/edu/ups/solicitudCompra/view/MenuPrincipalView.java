package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalView extends Frame {

    private Button btnRegistrarProveedor, btnRegistrarProducto, btnRegistrarSolicitud;
    private Button btnListarProveedores, btnListarProductos, btnListarSolicitudes;
    private Button btnBuscarProveedor, btnBuscarProducto, btnBuscarSolicitud;
    private Button btnCambiarEstado, btnCalcularTotal;

    private ProveedorController proveedorController;
    private ProductoController productoController;
    private SolicitudController solicitudController;

    public MenuPrincipalView() {
        proveedorController = new ProveedorController();
        productoController = new ProductoController();
        solicitudController = new SolicitudController();

        setTitle("Sistema de Gestión de Compras");
        setSize(400, 500);
        setLayout(new GridLayout(11, 1, 5, 5));
        setLocationRelativeTo(null);
        setVisible(true);

        btnRegistrarProveedor = new Button("1. Registrar Proveedor");
        btnRegistrarProducto = new Button("2. Registrar Producto");
        btnRegistrarSolicitud = new Button("3. Registrar Solicitud de Compra");
        btnListarProveedores = new Button("4. Listar Proveedores");
        btnListarProductos = new Button("5. Listar Productos");
        btnListarSolicitudes = new Button("6. Listar Solicitudes de Compra");
        btnBuscarProveedor = new Button("7. Buscar Proveedor por ID");
        btnBuscarProducto = new Button("8. Buscar Producto por Nombre");
        btnBuscarSolicitud = new Button("9. Buscar Solicitud por Número");
        btnCambiarEstado = new Button("10. Aprobar / Rechazar Solicitud");
        btnCalcularTotal = new Button("11. Calcular Total de una Solicitud");

        add(btnRegistrarProveedor);
        add(btnRegistrarProducto);
        add(btnRegistrarSolicitud);
        add(btnListarProveedores);
        add(btnListarProductos);
        add(btnListarSolicitudes);
        add(btnBuscarProveedor);
        add(btnBuscarProducto);
        add(btnBuscarSolicitud);
        add(btnCambiarEstado);
        add(btnCalcularTotal);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.exit(0);
            }
        });

        btnRegistrarProveedor.addActionListener(e -> new MenuRegistroProveedor(proveedorController));
        btnRegistrarProducto.addActionListener(e -> new MenuRegistrarProducto(proveedorController, productoController));
        btnRegistrarSolicitud.addActionListener(e -> new MenuRegistrarSolicitudCompra(proveedorController, productoController, solicitudController));
        btnListarProveedores.addActionListener(e -> new MenuListarProveedores(proveedorController));
        btnListarProductos.addActionListener(e -> new MenuListarProductos(productoController));
        btnListarSolicitudes.addActionListener(e -> new MenuListarSolicitudCompra(solicitudController));
        btnBuscarProveedor.addActionListener(e -> new MenuBuscarProveedorID(proveedorController));
        btnBuscarProducto.addActionListener(e -> new MenuBuscarProductoNombre(productoController));
        btnBuscarSolicitud.addActionListener(e -> new MenuBuscarSolicitudNumero(proveedorController, productoController, solicitudController));
        btnCambiarEstado.addActionListener(e -> new MenuAprobarRechazarSolicitud(solicitudController));
        btnCalcularTotal.addActionListener(e -> new MenuCalcularTotalSolicitud(solicitudController));
    }
}

