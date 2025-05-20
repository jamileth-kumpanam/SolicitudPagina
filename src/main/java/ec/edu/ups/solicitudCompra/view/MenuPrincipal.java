package ec.edu.ups.solicitudCompra.view;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelCentral;

    public MenuPrincipal() {
        setTitle("Sistema de Compras");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel(new GridLayout(11, 1));
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

        panelCentral = new JPanel();
        cardLayout = new CardLayout();
        panelCentral.setLayout(cardLayout);

        for (int i = 0; i < opciones.length; i++) {
            String opcion = opciones[i];
            JButton boton = new JButton(opcion);
            int indice = i + 1;
            panelMenu.add(boton);

            JPanel panelOpcion = new JPanel();
            panelOpcion.add(new JLabel("Pantalla para: " + opcion));
            panelCentral.add(panelOpcion, "opcion" + indice);

            boton.addActionListener(e -> cardLayout.show(panelCentral, "opcion" + indice));
        }

        add(panelMenu, BorderLayout.WEST);
        add(panelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}


