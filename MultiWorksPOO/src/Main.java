import java.util.HashMap;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        // Crear un HashMap para almacenar las asignaciones
        HashMap<Integer, Asignacion> asignacionesMap = new HashMap<>();

        // Crear una asignación
        Asignacion asignacion1 = new Asignacion(
                1, // idAsignacion
                40, // cantidadHoras
                "Instalación de Redes", // tituloActividad
                400.0, // costoBase
                10.0, // incrementoExtra
                440.0, // total (costoBase + incrementoExtra)
                new Date(), // fechaHoraInicio
                new Date(), // fechaHoraFin
                asignacionesMap // HashMap de asignaciones
        );

        // Agregar la asignación al HashMap
        asignacion1.crearAsignacion(asignacion1);

        // Crear otra asignación
        Asignacion asignacion2 = new Asignacion(
                2, // idAsignacion
                20, // cantidadHoras
                "Configuración de Routers", // tituloActividad
                200.0, // costoBase
                5.0, // incrementoExtra
                210.0, // total (costoBase + incrementoExtra)
                new Date(), // fechaHoraInicio
                new Date(), // fechaHoraFin
                asignacionesMap // HashMap de asignaciones
        );

        // Agregar la segunda asignación al HashMap
        asignacion2.crearAsignacion(asignacion2);

        // Mostrar todas las asignaciones registradas
        System.out.println("=== Todas las Asignaciones Registradas ===");
        System.out.println(asignacion1.consultarAsignacion());

        // Crear un HashMap para almacenar las cotizaciones
        HashMap<Integer, Cotizacion> cotizacionesMap = new HashMap<>();

        // Crear una cotización
        Cotizacion cotizacion1 = new Cotizacion(
                1, // idCotizacion
                100, // cantidadHorasProyecto
                "En proceso", // estado
                "Por Proyecto", // modalidad
                1500.0, // costosAdicionales
                2000.0, // costoAsignaciones
                3500.0, // total
                new Date(), // fechaInicio
                new Date(), // fechaFin
                cotizacionesMap // HashMap de cotizaciones
        );

        // Agregar la cotización al HashMap
        cotizacion1.crearCotizacion(cotizacion1);

        // Mostrar el resumen de la cotización
        System.out.println("=== Resumen de la Cotización ===");
        System.out.println(cotizacion1);

        // Crear otra cotización
        Cotizacion cotizacion2 = new Cotizacion(
                2, // idCotizacion
                80, // cantidadHorasProyecto
                "Finalizada", // estado
                "Recurrente", // modalidad
                1000.0, // costosAdicionales
                1500.0, // costoAsignaciones
                2500.0, // total
                new Date(), // fechaInicio
                new Date(), // fechaFin
                cotizacionesMap // HashMap de cotizaciones
        );

        // Agregar la segunda cotización al HashMap
        cotizacion2.crearCotizacion(cotizacion2);

        // Mostrar todas las cotizaciones registradas
        System.out.println("=== Todas las Cotizaciones Registradas ===");
        for (Cotizacion cotizacion : cotizacionesMap.values()) {
            System.out.println(cotizacion);
        }
    }
}
