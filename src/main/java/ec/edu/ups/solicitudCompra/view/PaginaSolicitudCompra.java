package ec.edu.ups.solicitudCompra.view;

import javax.swing.*;
import java.awt.*;

public class PaginaSolicitudCompra extends JFrame {

    public PaginaSolicitudCompra() {
        setTitle("Sistema de Solicitud de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Solicitud de Compras", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridLayout(3, 2, 10, 10));

        panelCentral.add(new JLabel("ID Empleado:"));
        panelCentral.add(new JTextField());

        panelCentral.add(new JLabel("Proveedor:"));
        panelCentral.add(new JTextField());

        panelCentral.add(new JLabel("Producto:"));
        panelCentral.add(new JTextField());

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(new JButton("Guardar"));
        panelBotones.add(new JButton("Cancelar"));

        add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PaginaSolicitudCompra().setVisible(true);
        });
    }
}
