package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.SolicitudController;
import ec.edu.ups.solicitudCompra.models.SolicitudCompra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCalcularTotalSolicitud extends Frame {

    private TextField txtNumero;
    private Label lblResultado;
    private Button btnCalcular;
    private SolicitudController solicitudController;

    public MenuCalcularTotalSolicitud(SolicitudController solicitudController) {
        this.solicitudController = solicitudController;

        setTitle("Calcular Total de Solicitud");
        setSize(400, 250);
        setLayout(null);
        setVisible(true);

        Label lblNumero = new Label("N° Solicitud:");
        lblNumero.setBounds(30, 50, 100, 25);
        add(lblNumero);

        txtNumero = new TextField();
        txtNumero.setBounds(140, 50, 200, 25);
        add(txtNumero);

        btnCalcular = new Button("Calcular Total");
        btnCalcular.setBounds(140, 90, 100, 30);
        add(btnCalcular);

        lblResultado = new Label("Total: $");
        lblResultado.setBounds(30, 140, 300, 25);
        add(lblResultado);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        String numero = txtNumero.getText().trim();
        if (numero.isEmpty()) {
            mostrarMensaje("Ingrese el número de solicitud.");
            return;
        }

        SolicitudCompra solicitud = solicitudController.buscarPorNumero(numero);
        if (solicitud == null) {
            mostrarMensaje("Solicitud no encontrada.");
        } else {
            double total = solicitud.getProducto().getPrecio() * solicitud.getCantidad();
            lblResultado.setText("Total: $" + String.format("%.2f", total));
        }
    }

    private void mostrarMensaje(String mensaje) {
        Dialog dialogo = new Dialog(this, "Mensaje", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(250, 100);
        dialogo.add(new Label(mensaje));
        Button ok = new Button("OK");
        ok.addActionListener(e -> dialogo.dispose());
        dialogo.add(ok);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
}

