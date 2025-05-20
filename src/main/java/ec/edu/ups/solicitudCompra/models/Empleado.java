package ec.edu.ups.solicitudCompra.models;

public class Empleado extends Persona {
    private Departamento departamento;
    private String cargo;

    public Empleado(String id, String nombre, String apellido, String telefono, String direccion,
                    Departamento departamento, String cargo) {
        super(id, nombre, apellido, telefono, direccion);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + cargo + " en " + (departamento != null ? departamento.getNombre() : "Sin departamento");
    }
}
