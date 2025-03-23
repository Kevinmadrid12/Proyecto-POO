import java.time.LocalDate;
import java.util.*;

public class Cotizacion extends Datos {
    private int idCotizacion, idCliente, cantidadHorasProyecto;
    private String estado, modalidad;
    private double costosAdicionales, costoAsignaciones, total;
    private LocalDate fechaInicio, fechaFin;
    private HashMap<Integer,Cotizacion> cotizaciones = new HashMap<>();

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Constructor
    public Cotizacion() {}
    public Cotizacion(int idCotizacion, int cantidadHorasProyecto, String estado, String modalidad, double costosAdicionales, double costoAsignaciones, double total, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idCotizacion = idCotizacion;
        this.cantidadHorasProyecto = cantidadHorasProyecto;
        this.estado = estado;
        this.modalidad = modalidad;
        this.costosAdicionales = costosAdicionales;
        this.costoAsignaciones = costoAsignaciones;
        this.total = total;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void crearCotizacion (Cotizacion cotizacion) {
        cotizaciones.put(cotizacion.getIdCotizacion(), cotizacion);
    }

    public void actualizarCotizacion (Cotizacion cotizacion) {
        cotizaciones.replace(cotizacion.getIdCotizacion(), cotizacion);
    }

    public void eliminarCotizacion (Cotizacion cotizacion) {
        cotizaciones.remove(cotizacion.getIdCotizacion());
    }

    public String consultarCotizacion () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Cotizacion> entry : cotizaciones.entrySet()) {
            datos.append("ID cotización: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
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
        /*for (Asignacion asig : asignaciones) {
            costoTotal += asig.getCostoTotal();
        }*/
        return costoTotal;
    }

    // Para calcular el costo total de la cotización (actividades + costos adicionales)
    public double calcularCostoTotal() {
        return calcularCostoActividades() + costosAdicionales;
    }
}