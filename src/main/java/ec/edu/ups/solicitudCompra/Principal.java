package ec.edu.ups.solicitudCompra;


import ec.edu.ups.solicitudCompra.controller.ProveedorController;
import ec.edu.ups.solicitudCompra.view.MenuPrincipalView;

public class Principal {
    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();
        MenuPrincipalView menu = new MenuPrincipalView(proveedorController);
        menu.setVisible(true);
    }
}
