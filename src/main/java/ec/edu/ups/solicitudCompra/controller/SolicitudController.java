package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.SolicitudCompra;
import java.util.ArrayList;
import java.util.List;

public class SolicitudController {
    private List<SolicitudCompra> solicitudes;

    public SolicitudController() {
        solicitudes = new ArrayList<>();
    }

    public void agregarSolicitud(SolicitudCompra solicitud) {
        solicitudes.add(solicitud);
    }

    public SolicitudCompra buscarPorNumero(String numero) {
        for (SolicitudCompra s : solicitudes) {
            if (s.getNumero().equals(numero)) return s;
        }
        return null;
    }

    public List<SolicitudCompra> listarSolicitudes() {
        return new ArrayList<>(solicitudes);
    }

    public void actualizarEstado(SolicitudCompra solicitud) {
        for (SolicitudCompra s : solicitudes) {
            if (s.getNumero().equals(solicitud.getNumero())) {
                s.setEstado(solicitud.getEstado());
                break;
            }
        }
    }
}

