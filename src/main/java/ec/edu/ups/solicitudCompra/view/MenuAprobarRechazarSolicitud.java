package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.SolicitudController;
import ec.edu.ups.solicitudCompra.models.SolicitudCompra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAprobarRechazarSolicitud extends Frame {

    private TextField txtNumero;
    private TextArea areaResultado;
    private Button btnBuscar, btnAprobar, btnRechazar;
    private SolicitudCompra solicitud;
    private SolicitudController solicitudController;

    public MenuAprobarRechazarSolicitud(SolicitudController solicitudController) {
        this.solicitudController = solicitudController;

        setTitle("Aprobar / Rechazar Solicitud");
        setSize(450, 350);
        setLayout(null);
        setVisible(true);

        Label lblNumero = new Label("N° Solicitud:");
        lblNumero.setBounds(30, 50, 100, 25);
        add(lblNumero);

        txtNumero = new TextField();
        txtNumero.setBounds(140, 50, 200, 25);
        add(txtNumero);

        btnBuscar = new Button("Buscar");
        btnBuscar.setBounds(350, 50, 60, 25);
        add(btnBuscar);

        areaResultado = new TextArea();
        areaResultado.setBounds(30, 90, 380, 120);
        areaResultado.setEditable(false);
        add(areaResultado);

        btnAprobar = new Button("Aprobar");
        btnAprobar.setBounds(100, 230, 100, 30);
        btnAprobar.setEnabled(false);
        add(btnAprobar);

        btnRechazar = new Button("Rechazar");
        btnRechazar.setBounds(220, 230, 100, 30);
        btnRechazar.setEnabled(false);
        add(btnRechazar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = txtNumero.getText().trim();
                solicitud = solicitudController.buscarPorNumero(numero);
                if (solicitud == null) {
                    areaResultado.setText("Solicitud no encontrada.");
                    btnAprobar.setEnabled(false);
                    btnRechazar.setEnabled(false);
                } else {
                    areaResultado.setText(solicitud.toString());
                    btnAprobar.setEnabled(true);
                    btnRechazar.setEnabled(true);
                }
            }
        });

        btnAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solicitud != null) {
                    solicitud.setEstado("Aprobada");
                    solicitudController.actualizarEstado(solicitud);
                    areaResultado.setText("Solicitud aprobada.\n" + solicitud.toString());
                }
            }
        });

        btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (solicitud != null) {
                    solicitud.setEstado("Rechazada");
                    solicitudController.actualizarEstado(solicitud);
                    areaResultado.setText("Solicitud rechazada.\n" + solicitud.toString());
                }
            }
        });
    }
}
