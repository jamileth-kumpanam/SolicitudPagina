package ec.edu.ups.solicitudCompra.models;

public class Departamento {
    private String codigo;
    private String nombre;
    private double presupuesto;
    private Empleado responsable;

    public Departamento(String codigo, String nombre, double presupuesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - Presupuesto: $" + presupuesto;
    }
}
