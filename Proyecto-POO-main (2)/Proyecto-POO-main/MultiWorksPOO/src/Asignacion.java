import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Asignacion {
    private int idAsignacion;
    private int cantidadHoras;
    private String tituloActividad;
    private double costoBase;
    private double incrementoExtra;
    private double total;
    private LocalDate fechaHoraInicio;
    private LocalDate fechaHoraFin;

    // 🔴 SOLUCIÓN: Declaramos el HashMap para almacenar asignaciones
    private static HashMap<Integer, Asignacion> asignaciones = new HashMap<>();

    // Constructor
    public Asignacion(int idAsignacion, int cantidadHoras, String tituloActividad, double costoBase,
                      double incrementoExtra, double total, LocalDate fechaHoraInicio, LocalDate fechaHoraFin) {
        this.idAsignacion = idAsignacion;
        this.cantidadHoras = cantidadHoras;
        this.tituloActividad = tituloActividad;
        this.costoBase = costoBase;
        this.incrementoExtra = incrementoExtra;
        this.total = total;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    // ✅ Método para agregar asignaciones al HashMap
    public void crearAsignacion(Asignacion asignacion) {
        asignaciones.put(asignacion.idAsignacion, asignacion);
        System.out.println("Asignación creada:\n" + asignacion);
    }

    // ✅ Método para consultar todas las asignaciones
    public String consultarAsignacion() {
        StringBuilder resultado = new StringBuilder("\n=== Todas las Asignaciones Registradas ===\n");
        for (Map.Entry<Integer, Asignacion> entry : asignaciones.entrySet()) {
            resultado.append(entry.getValue().toString()).append("\n");
        }
        return resultado.toString();
    }

    // ✅ Método toString mejorado para visualización
    @Override
    public String toString() {
        return String.format(
                "\n🆔 ID Asignación: %d\n" +
                        "🔹 Título: %s\n" +
                        "⏳ Horas: %d\n" +
                        "💰 Costo Base: $%.2f\n" +
                        "📈 Incremento Extra: $%.2f\n" +
                        "💵 Total: $%.2f\n" +
                        "📅 Inicio: %s\n" +
                        "📆 Fin: %s\n" +
                        "------------------------------",
                idAsignacion, tituloActividad, cantidadHoras, costoBase, incrementoExtra, total,
                fechaHoraInicio, fechaHoraFin
        );
    }
}