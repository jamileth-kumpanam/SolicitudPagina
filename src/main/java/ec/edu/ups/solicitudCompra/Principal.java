package ec.edu.ups.solicitudCompra;

import ec.edu.ups.solicitudCompra.view.MenuPrincipal;

public class Principal {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MenuPrincipal ventana = new MenuPrincipal();
            ventana.setVisible(true);
        });
    }
}
