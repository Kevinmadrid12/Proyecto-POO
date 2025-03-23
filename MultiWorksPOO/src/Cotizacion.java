import java.time.LocalDate;

public class Cotizacion {
    private int idCotizacion;
    private int cantidadHorasProyecto;
    private String estado;
    private String modalidad;
    private double costosAdicionales;
    private double costoAsignaciones;
    private double total;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor
    public Cotizacion(int idCotizacion, int cantidadHorasProyecto, String estado, String modalidad,
                      double costosAdicionales, double costoAsignaciones, double total,
                      LocalDate fechaInicio, LocalDate fechaFin) {
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

    // Método para registrar cotizaciones (simulación de almacenamiento en un HashMap)
    public void crearCotizacion(Cotizacion cotizacion) {
        System.out.println("Cotización creada: " + cotizacion);
    }

    public void actualizarCotizacion(Cotizacion cotizacion) {
        System.out.println("Cotización actualizada: " + cotizacion);
    }

    public String consultarCotizacion() {
        return "Detalles de la cotización con ID: " + idCotizacion;
    }

    @Override
    public String toString() {
        return String.format(
                "\n🆔 ID Cotización: %d\n" +
                        "📌 Estado: %s\n" +
                        "⏳ Horas Proyecto: %d\n" +
                        "🛠️ Modalidad: %s\n" +
                        "💵 Costo Adicional: $%.2f\n" +
                        "💰 Costo Asignaciones: $%.2f\n" +
                        "💲 Total: $%.2f\n" +
                        "📅 Inicio: %s\n" +
                        "📆 Fin: %s\n" +
                        "------------------------------\n",
                idCotizacion, estado, cantidadHorasProyecto, modalidad, costosAdicionales,
                costoAsignaciones, total, fechaInicio, fechaFin
        );
    }
}


