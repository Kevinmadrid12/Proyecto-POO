import java.util.HashMap;
import java.util.Date;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();

        // Crear una asignación
        Asignacion asig = new Asignacion(
                1, // idAsignacion
                40, // cantidadHoras
                "Instalación de Redes", // tituloActividad
                400.0, // costoBase
                10.0, // incrementoExtra
                440.0, // total (costoBase + incrementoExtra)
                fecha, // fechaHoraInicio
                fecha.minusDays(1) // fechaHoraFin
        );

        // Agregar la asignación al HashMap
        asig.crearAsignacion(asig);

        // Crear otra asignación
        asig = new Asignacion(
                2, // idAsignacion
                20, // cantidadHoras
                "Configuración de Routers", // tituloActividad
                200.0, // costoBase
                5.0, // incrementoExtra
                210.0, // total (costoBase + incrementoExtra)
                fecha.minusWeeks(1), // fechaHoraInicio
                fecha.minusYears(1) // fechaHoraFin
        );

        // Agregar la segunda asignación al HashMap
        asig.crearAsignacion(asig);

        // Mostrar todas las asignaciones registradas
        System.out.println("=== Todas las Asignaciones Registradas ===");
        System.out.println(asig.consultarAsignacion());

        // Crear una cotización
        Cotizacion cot = new Cotizacion(
                1, // idCotizacion
                100, // cantidadHorasProyecto
                "En proceso", // estado
                "Por Proyecto", // modalidad
                1500.0, // costosAdicionales
                2000.0, // costoAsignaciones
                3500.0, // total
                fecha.minusDays(4), // fechaInicio
                fecha.minusWeeks(2) // fechaFin
        );

        // Agregar la cotización al HashMap
        cot.crearCotizacion(cot);

        // Mostrar el resumen de la cotización
        System.out.println("=== Resumen de la Cotización ===");
        System.out.println(cot);

        // Crear otra cotización
        cot = new Cotizacion(
                2, // idCotizacion
                80, // cantidadHorasProyecto
                "Finalizada", // estado
                "Recurrente", // modalidad
                1000.0, // costosAdicionales
                1500.0, // costoAsignaciones
                2500.0, // total
                fecha, // fechaInicio
                fecha.minusDays(2) // fechaFin
        );

        // Actualizar cotización
        cot.actualizarCotizacion(cot);

        // Mostrar todas las cotizaciones registradas
        System.out.println("=== Todas las Cotizaciones Registradas ===");
        System.out.println(cot.consultarCotizacion());
    }
}
