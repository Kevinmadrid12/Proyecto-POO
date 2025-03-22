import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Persona {
    private int idCliente;
    private HashMap<Integer, Cliente> clientes;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }

    public Cliente(int idCliente, String nombre, String documento, String telefono, String correo, String direccion, String estado, String creadoPor, Date fechaCreacion, Date fechaActualizacion, Date fechaInactivacion) {
        super(nombre, documento, telefono, correo, direccion, estado, creadoPor, fechaCreacion, fechaActualizacion, fechaInactivacion);
        this.idCliente = idCliente;
    }

    public void crearPersona (Cliente cliente) {
        clientes.put(cliente.getIdCliente(), cliente);
    }

    public void actualizarPersona (Cliente cliente) {
        clientes.replace(cliente.getIdCliente(), cliente);
    }

    public void eliminarPersona (Cliente cliente) {
        clientes.remove(cliente.getIdCliente());
    }

    public String consultarPersona () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Cliente> entry : clientes.entrySet()) {
            datos.append("ID cliente: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}
