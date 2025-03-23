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

        // Creamos el objeto gestor de subtareas
        Subtarea gestorSubtareas = new Subtarea();

        // Creamos y agregamos dos subtareas
        Subtarea sub1 = new Subtarea(1, "Subtarea 1", "Descripción de la subtarea 1");
        Subtarea sub2 = new Subtarea(2, "Subtarea 2", "Descripción de la subtarea 2");
        gestorSubtareas.crearSubtarea(sub1);
        gestorSubtareas.crearSubtarea(sub2);

        // Consultamos y mostramos las subtareas
        System.out.println("Subtareas iniciales:");
        System.out.println(gestorSubtareas.consultarSubtarea());

        // Actualizamos la subtarea 1
        Subtarea sub1Actualizada = new Subtarea(1, "Subtarea 1 Actualizada", "Nueva descripción");
        gestorSubtareas.actualizarSubtarea(sub1Actualizada);

        // Consultamos nuevamente para ver la actualización
        System.out.println("Subtareas tras actualizar la 1:");
        System.out.println(gestorSubtareas.consultarSubtarea());

        // Eliminamos la subtarea 2
        gestorSubtareas.eliminarSubtarea(new Subtarea(2, "", ""));

        // Consultamos para ver el estado final
        System.out.println("Subtareas tras eliminar la 2:");
        System.out.println(gestorSubtareas.consultarSubtarea());
    }
}
