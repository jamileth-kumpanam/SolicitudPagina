package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipalView extends Frame {
    private ProveedorController proveedorController;
    private ProductoController productoController;
    private SolicitudController solicitudController;

    public MenuPrincipalView() {
        proveedorController = new ProveedorController();
        productoController = new ProductoController();
        solicitudController = new SolicitudController();

        setTitle("Sistema de Gestión de Compras");
        setSize(400, 500);
        setLayout(new GridLayout(11, 1));
        setBackground(Color.WHITE);

        // Botones del menú
        Button[] botones = new Button[11];
        String[] textos = {
                "1. Registrar Proveedor",
                "2. Registrar Producto",
                "3. Registrar Solicitud",
                "4. Listar Proveedores",
                "5. Listar Productos",
                "6. Listar Solicitudes",
                "7. Buscar Proveedor por ID",
                "8. Buscar Producto por Nombre",
                "9. Buscar Solicitud por Número",
                "10. Aprobar/Rechazar Solicitud",
                "11. Calcular Total de Solicitud"
        };

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new Button(textos[i]);
            add(botones[i]);
        }

        botones[0].addActionListener(e -> new MenuRegistroProveedor(proveedorController));
        botones[1].addActionListener(e -> new MenuRegistrarProducto(proveedorController, productoController));
        botones[2].addActionListener(e -> new MenuRegistrarSolicitudCompra(proveedorController, productoController, solicitudController));
        botones[3].addActionListener(e -> new MenuListarProveedores(proveedorController));
        botones[4].addActionListener(e -> new MenuListarProductos(productoController));
        botones[5].addActionListener(e -> new MenuListarSolicitudCompra(solicitudController));
        botones[6].addActionListener(e -> new MenuBuscarProveedorID(proveedorController));
        botones[7].addActionListener(e -> new MenuBuscarProductoNombre(productoController));
        botones[8].addActionListener(e -> new MenuBuscarSolicitudNumero(solicitudController, proveedorController, productoController));
        botones[9].addActionListener(e -> new MenuAprobarRechazarSolicitud(solicitudController));
        botones[10].addActionListener(e -> new MenuCalcularTotalSolicitud(solicitudController));

        // Cerrar ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
