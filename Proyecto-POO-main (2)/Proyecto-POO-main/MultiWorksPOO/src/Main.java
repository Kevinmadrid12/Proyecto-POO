import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        int opcion;

        do {
            System.out.println("\n========= Menú =========");
            System.out.println("1️⃣ Agregar Cliente");
            System.out.println("2️⃣ Lista Clientes");
            System.out.println("3️⃣ Inactivar Cliente");
            System.out.println("4️⃣ Eliminar Cliente");
            System.out.println("5️⃣ Administrar Asignaciones y Cotizaciones");
            System.out.println("6️⃣ Salir");
            System.out.print("👉 Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarCliente();
                    case 2 -> listarClientes();
                    case 3 -> inactivarCliente();
                    case 4 -> eliminarCliente();
                    case 5 -> gestionarAsignacionesYCotizaciones();
                    case 6 -> System.out.println("🚪 Saliendo del sistema...");
                    default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
                opcion = 0;
            }
        } while (opcion != 6);
    }

    private static void gestionarAsignacionesYCotizaciones() {
        LocalDate fecha = LocalDate.now();

        Asignacion asig1 = new Asignacion(1, 40, "Instalación de Redes", 400.0, 10.0, 440.0, fecha, fecha.minusDays(1));
        asig1.crearAsignacion(asig1);

        Asignacion asig2 = new Asignacion(2, 20, "Configuración de Routers", 200.0, 5.0, 210.0, fecha.minusWeeks(1), fecha.minusYears(1));
        asig2.crearAsignacion(asig2);

        System.out.println("=== Todas las Asignaciones Registradas ===");
        System.out.println(asig1.consultarAsignacion());

        Cotizacion cot1 = new Cotizacion(1, 100, "En proceso", "Por Proyecto", 1500.0, 2000.0, 3500.0, fecha.minusDays(4), fecha.minusWeeks(2));
        cot1.crearCotizacion(cot1);

        System.out.println("=== Resumen de la Cotización ===");
        System.out.println(cot1);

        Cotizacion cot2 = new Cotizacion(2, 80, "Finalizada", "Recurrente", 1000.0, 1500.0, 2500.0, fecha, fecha.minusDays(2));
        cot2.actualizarCotizacion(cot2);

        System.out.println("=== Todas las Cotizaciones Registradas ===");
        System.out.println(cot2.consultarCotizacion());
    }

    private static void agregarCliente() {
        System.out.println("\n📌 Agregar Nuevo Cliente");
        String nombre = leerEntrada("👤 Nombre: ");
        String documento = leerEntrada("📄 Documento: ");
        String telefono = leerEntrada("📞 Teléfono: ");
        String correo = leerEntrada("📧 Correo: ");
        String direccion = leerEntrada("🏠 Dirección: ");
        String tipoPersona = leerEntrada("🏛 Tipo de Persona (Natural/Jurídica): ");
        String creadoPor = leerEntrada("👤 Creado por: ");

        Cliente nuevoCliente = new Cliente(nombre, documento, telefono, correo, direccion, tipoPersona, creadoPor);
        clientes.add(nuevoCliente);
        System.out.println("✅ Cliente agregado exitosamente.");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("\n📌 No hay clientes registrados.");
        } else {
            System.out.println("\n📌 Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void inactivarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("\n📌 No hay clientes registrados.");
            return;
        }

        System.out.print("\n🔎 Ingrese el ID del cliente a inactivar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            for (Cliente cliente : clientes) {
                if (cliente.getIdCliente() == id) {
                    cliente.setEstado(EstadoCliente.INACTIVO);
                    System.out.println("✅ Cliente inactivado exitosamente.");
                    return;
                }
            }
            System.out.println("❌ Cliente no encontrado.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida. Debe ingresar un número.");
        }
    }

    private static void eliminarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("\n📌 No hay clientes registrados.");
            return;
        }

        System.out.print("\n🗑 Ingrese el ID del cliente a eliminar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            clientes.removeIf(cliente -> cliente.getIdCliente() == id);
            System.out.println("✅ Cliente eliminado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida. Debe ingresar un número.");
        }
    }

    private static String leerEntrada(String mensaje) {
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("❌ Este campo no puede estar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }
}
