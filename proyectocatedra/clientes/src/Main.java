import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Excepción personalizada para validar nombres
class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 01;
        do {
            System.out.println("\n========= Menú =========");
            System.out.println("1️⃣ Agregar Cliente");
            System.out.println("2️⃣ Listar Clientes");
            System.out.println("3️⃣ Inactivar Cliente");
            System.out.println("4️⃣ Salir");
            System.out.println("4️⃣ Eliminar Cliente");
            System.out.println("5️⃣ Salir");
            System.out.print("👉 Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarCliente();
                    case 2 -> listarClientes();
                    case 3 -> inactivarCliente();
                    case 4 -> eliminarCliente(); // Llamamos al nuevo método
                    case 5 -> System.out.println("🚪 Saliendo del sistema...");
                    default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número.");
            }

        } while (opcion != 5);
    }

    private static void eliminarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("\n📌 No hay clientes registrados.");
            return;
        }

        System.out.print("\n🗑 Ingrese el ID del cliente a eliminar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            // Buscar cliente por ID
            Cliente clienteAEliminar = null;
            for (Cliente cliente : clientes) {
                if (cliente.getIdCliente() == id) {
                    clienteAEliminar = cliente;
                    break;
                }
            }

            if (clienteAEliminar != null) {
                clientes.remove(clienteAEliminar);
                System.out.println("✅ Cliente eliminado exitosamente.");
            } else {
                System.out.println("❌ Cliente no encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Entrada inválida. Debe ingresar un número.");
        }
    }

    private static void agregarCliente() {
        System.out.println("\n📌 Agregar Nuevo Cliente");

        String nombre;
        while (true) {
            try {
                nombre = leerEntrada("👤 Nombre: ");
                validarNombre(nombre); // Lanza una excepción si es inválido
                break;
            } catch (NombreInvalidoException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        String documento;
        while (true) {
            documento = leerEntrada("📄 Documento: ");
            String finalDocumento = documento;
            if (clientes.stream().noneMatch(c -> c.getDocumento().equals(finalDocumento))) {
                break;
            }
            System.out.println("❌ Documento ya registrado. Intente con otro.");
        }

        String telefono;
        while (true) {
            telefono = leerEntrada("📞 Teléfono: ");
            if (telefono.matches("\\d+")) {
                break;
            }
            System.out.println("❌ Teléfono inválido. Solo números.");
        }

        String correo;
        while (true) {
            correo = leerEntrada("📧 Correo: ");
            if (correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                break;
            }
            System.out.println("❌ Correo inválido. Intente de nuevo.");
        }

        String direccion = leerEntrada("🏠 Dirección: ");
        String tipoPersona = leerEntrada("🏛 Tipo de Persona (Natural/Jurídica): ");
        String creadoPor = leerEntrada("👤 Creado por: ");

        Cliente nuevoCliente = new Cliente(nombre, documento, telefono, correo, direccion, tipoPersona, creadoPor);
        clientes.add(nuevoCliente);
        System.out.println("✅ Cliente agregado exitosamente.");
    }

    private static void validarNombre(String nombre) throws NombreInvalidoException {
        if (!nombre.matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+( [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$")) {
            throw new NombreInvalidoException("El nombre solo debe contener letras y empezar con mayúscula.");
        }
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
                    cliente.setEstado(EstadoCliente.valueOf("Inactivo"));
                    System.out.println("✅ Cliente inactivado exitosamente.");
                    return;
                }
            }
            System.out.println("❌ Cliente no encontrado.");
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
