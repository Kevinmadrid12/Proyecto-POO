import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Persona {

    private int idCliente;
    private static HashMap<Integer, Cliente> clientes = new HashMap<>();

    // Getter para el ID del cliente
    public int getIdCliente() {
        return idCliente;
    }

    // Constructores
    public Cliente(String nombre, String documento, String telefono, String correo, String direccion, String tipoPersona, String creadoPor) {
        super();
        this.idCliente = super.getIdCliente(); // Mantiene la coherencia con el ID generado en Persona
    }

    public Cliente(int idCliente, String nombre, String documento, String telefono, String correo, String direccion,
                   String creadoPor, Date fechaCreacion, Date fechaActualizacion, Date fechaInactivacion) {
        super(nombre, documento, telefono, correo, direccion, creadoPor, creadoPor, fechaCreacion, fechaActualizacion, fechaInactivacion);
        this.idCliente = idCliente;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaInactivacion = fechaInactivacion;
    }

    // Métodos CRUD para gestionar clientes
    public void crearCliente(Cliente cliente) {
        clientes.put(cliente.getIdCliente(), cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getIdCliente())) {
            clientes.replace(cliente.getIdCliente(), cliente);
            cliente.fechaActualizacion = new Date();
        }
    }

    public void eliminarCliente(int idCliente) {
        clientes.remove(idCliente);
    }

    public String consultarClientes() {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer, Cliente> entry : clientes.entrySet()) {
            datos.append("ID Cliente: ").append(entry.getKey()).append(", Datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}


enum EstadoCliente {
    ACTIVO, INACTIVO
}