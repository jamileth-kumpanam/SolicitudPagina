package ec.edu.ups.solicitudCompra.controller;

import ec.edu.ups.solicitudCompra.models.SolicitudCompra;
import java.util.ArrayList;
import java.util.List;

public class SolicitudController {

    private List<SolicitudCompra> listaSolicitudes;

    public SolicitudController() {
        listaSolicitudes = new ArrayList<>();
    }

    public void agregarSolicitud(SolicitudCompra solicitud) {
        listaSolicitudes.add(solicitud);
    }

    public SolicitudCompra buscarPorNumero(String numero) {
        for (SolicitudCompra solicitud : listaSolicitudes) {
            if (solicitud.getNumero().equalsIgnoreCase(numero)) {
                return solicitud;
            }
        }
        return null;
    }

    public List<SolicitudCompra> listarSolicitudes() {
        return listaSolicitudes;
    }

    public void actualizarEstado(SolicitudCompra solicitudActualizada) {
        for (int i = 0; i < listaSolicitudes.size(); i++) {
            if (listaSolicitudes.get(i).getNumero().equalsIgnoreCase(solicitudActualizada.getNumero())) {
                listaSolicitudes.set(i, solicitudActualizada);
                break;
            }
        }
    }
}


