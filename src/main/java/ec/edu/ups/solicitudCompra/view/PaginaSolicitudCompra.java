package ec.edu.ups.solicitudCompra.view;

import java.awt.*;

public class PaginaSolicitudCompra extends Frame {

    public PaginaSolicitudCompra() {
        setTitle("Sistema de Solicitud de Compras");
        setSize(600, 400);
        setLayout(new BorderLayout());

        Label titulo = new Label("Solicitud de Compras", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        Panel panelCentral = new Panel(new GridLayout(3, 2, 10, 10));

        panelCentral.add(new Label("ID Empleado:"));
        panelCentral.add(new TextField());

        panelCentral.add(new Label("Proveedor:"));
        panelCentral.add(new TextField());

        panelCentral.add(new Label("Producto:"));
        panelCentral.add(new TextField());

        add(panelCentral, BorderLayout.CENTER);

        Panel panelBotones = new Panel(new FlowLayout());
        panelBotones.add(new Button("Guardar"));
        panelBotones.add(new Button("Cancelar"));

        add(panelBotones, BorderLayout.SOUTH);

        centrarVentanaEnPantalla();

        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
            }
        });
    }

    private void centrarVentanaEnPantalla() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    public static void main(String[] args) {
        new PaginaSolicitudCompra();
    }
}

