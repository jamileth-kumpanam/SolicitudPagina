package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.ProveedorController;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal2 extends Frame {
    private CardLayout cardLayout;
    private Panel panelCentral;
    private ProveedorController proveedorController;

    public MenuPrincipal2() {
        setTitle("Sistema de Compras");
        setSize(700, 500);
        setLayout(new BorderLayout());

        proveedorController = new ProveedorController();

        Panel panelMenu = new Panel(new GridLayout(11, 1));
        String[] opciones = {
                "1. Registrar proveedor",
                "2. Registrar producto",
                "3. Registrar solicitud de compra",
                "4. Listar proveedores",
                "5. Listar productos",
                "6. Listar solicitudes de compra",
                "7. Buscar proveedor por ID",
                "8. Buscar producto por nombre",
                "9. Buscar solicitud por número",
                "10. Aprobar/Rechazar solicitud",
                "11. Calcular total de solicitud"
        };

        panelCentral = new Panel();
        cardLayout = new CardLayout();
        panelCentral.setLayout(cardLayout);

        for (int i = 0; i < opciones.length; i++) {
            String opcion = opciones[i];
            Button boton = new Button(opcion);
            int indice = i + 1;
            panelMenu.add(boton);

            Panel panelOpcion = new Panel();
            panelOpcion.add(new Label("Pantalla para: " + opcion));
            panelCentral.add("opcion" + indice, panelOpcion);

            final int index = indice;
            boton.addActionListener(e -> {
                switch (index) {
                    case 1:
                        MenuRegistroProveedor registro = new MenuRegistroProveedor(proveedorController);
                        registro.setVisible(true);
                        break;
                    default:
                        cardLayout.show(panelCentral, "opcion" + index);
                        break;
                }
            });
        }

        add(panelMenu, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        centerFrame();
        setVisible(true);
    }

    private void centerFrame() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frame = getSize();
        setLocation((screen.width - frame.width) / 2, (screen.height - frame.height) / 2);
    }

    public static void main(String[] args) {
        new MenuPrincipal2();
    }
}

