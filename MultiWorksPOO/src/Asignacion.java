import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Asignacion {
    private int idAsignacion, idCotizacion, idEmpleado, cantidadHoras;
    private String tituloActividad;
    private double costoBase, incrementoExtra, total;
    private LocalDate fechaHoraInicio, fechaHoraFin;
    private HashMap<Integer, Asignacion> asignaciones = new HashMap<>();

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    //Constructor
    public Asignacion () {}
    public Asignacion(int idAsignacion, int cantidadHoras, String tituloActividad, double costoBase, double incrementoExtra, double total, LocalDate fechaHoraInicio, LocalDate fechaHoraFin) {
        this.idAsignacion = idAsignacion;
        this.cantidadHoras = cantidadHoras;
        this.tituloActividad = tituloActividad;
        this.costoBase = costoBase;
        this.incrementoExtra = incrementoExtra;
        this.total = total;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    public void crearAsignacion (Asignacion asignacion) {
        asignaciones.put(asignacion.getIdAsignacion(), asignacion);
    }

    public void actualizarAsignacion (Asignacion asignacion) {
        asignaciones.replace(asignacion.getIdAsignacion(), asignacion);
    }

    public void eliminarAsignacion (Asignacion asignacion) {
        asignaciones.remove(asignacion.getIdAsignacion());
    }

    public String consultarAsignacion () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Asignacion> entry : asignaciones.entrySet()) {
            datos.append("ID asignación: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}
