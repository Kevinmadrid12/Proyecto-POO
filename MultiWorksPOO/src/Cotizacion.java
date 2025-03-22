import java.util.ArrayList;
import java.util.List;

public class Cotizacion extends Datos {
    private String id;
    private Cliente cliente;
    private List<Asignacion> asignaciones;
    private String estado; // En proceso o Finalizada
    private double costosAdicionales;

    // Constructor
    public Cotizacion(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.asignaciones = new ArrayList<>();
        this.estado = "En proceso";
        this.costosAdicionales = 0;
    }

    // Para agregar una actividad
    public void agregarAsignacion(Asignacion asig) {
        asignaciones.add(asig);
    }

    // Para agregar costos adicionales
    public void agregarCostosAdicionales(double costos) {
        this.costosAdicionales += costos;
    }

    // Para finalizar la cotización
    public void finalizarCotizacion() {
        this.estado = "Finalizada";
    }

    // Para calcular el costo total de las actividades
    public double calcularCostoActividades() {
        double costoTotal = 0;
        for (Asignacion asig : asignaciones) {
            costoTotal += asig.getCostoTotal();
        }
        return costoTotal;
    }

    // Para calcular el costo total de la cotización (actividades + costos adicionales)
    public double calcularCostoTotal() {
        return calcularCostoActividades() + costosAdicionales;
    }

    // Para mostrar el resumen de la cotización
    @Override
    public String toString() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Cotización #").append(id).append("\n");
        resumen.append("Cliente: ").append(cliente).append("\n");
        resumen.append("Estado: ").append(estado).append("\n");
        resumen.append("Actividades:\n");
        for (Asignacion asig : asignaciones) {
            resumen.append(asig).append("\n");
        }
        resumen.append("Costo de Actividades: $").append(calcularCostoActividades()).append("\n");
        resumen.append("Costos Adicionales: $").append(costosAdicionales).append("\n");
        resumen.append("Costo Total: $").append(calcularCostoTotal()).append("\n");
        return resumen.toString();
    }
}