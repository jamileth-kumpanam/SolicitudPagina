package ec.edu.ups.solicitudCompra.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelCentral;

    public MenuPrincipal() {
        setTitle("Sistema de Compras");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de botones del menú a la izquierda
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

        // Panel que cambiará con CardLayout
        panelCentral = new JPanel();
        cardLayout = new CardLayout();
        panelCentral.setLayout(cardLayout);

        // Crear todos los paneles para las acciones
        for (int i = 0; i < opciones.length; i++) {
            String opcion = opciones[i];
            JButton boton = new JButton(opcion);
            int indice = i + 1;
            panelMenu.add(boton);

            // Crear panel de acción
            JPanel panelOpcion = new JPanel();
            panelOpcion.add(new JLabel("Pantalla para: " + opcion));
            panelCentral.add(panelOpcion, "opcion" + indice);

            // Acción del botón para cambiar de vista
            boton.addActionListener(e -> cardLayout.show(panelCentral, "opcion" + indice));
        }

        add(panelMenu, BorderLayout.WEST);      // Menú a la izquierda
        add(panelCentral, BorderLayout.CENTER); // Panel de contenido principal
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}

