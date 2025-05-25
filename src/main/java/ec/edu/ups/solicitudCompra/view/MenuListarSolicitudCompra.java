package ec.edu.ups.solicitudCompra.view;

import ec.edu.ups.solicitudCompra.controller.SolicitudController;
import ec.edu.ups.solicitudCompra.models.SolicitudCompra;

import java.awt.*;
import java.util.List;

public class MenuListarSolicitudCompra extends Frame {

    private TextArea areaListado;
    private SolicitudController solicitudController;

    public MenuListarSolicitudCompra(SolicitudController solicitudController) {
        this.solicitudController = solicitudController;

        setTitle("Lista de Solicitudes de Compra");
        setSize(500, 300);
        setLayout(null);
        setVisible(true);

        areaListado = new TextArea();
        areaListado.setBounds(30, 50, 440, 200);
        areaListado.setEditable(false);
        add(areaListado);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
            }
        });

        cargarListado();
    }

    private void cargarListado() {
        List<SolicitudCompra> lista = solicitudController.listarSolicitudes();
        StringBuilder sb = new StringBuilder();
        for (SolicitudCompra solicitud : lista) {
            sb.append(solicitud.toString()).append("\n");
        }
        areaListado.setText(sb.toString());
    }
}
