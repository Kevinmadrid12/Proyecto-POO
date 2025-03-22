import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Persona extends Datos {
    protected String nombre, documento, telefono, correo, direccion, estado, creadoPor;
    protected Date fechaCreacion, fechaActualizacion, fechaInactivacion;
    private HashMap<Integer,Persona> personas = new HashMap<>();

    public Persona() {}

    public Persona(String nombre, String documento, String telefono, String correo, String direccion, String estado, String creadoPor, Date fechaCreacion, Date fechaActualizacion, Date fechaInactivacion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.fechaInactivacion = fechaInactivacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
        this.documento = documento;
        this.direccion = direccion;
        this.creadoPor = creadoPor;
        this.correo = correo;
    }

    public void crearPersona (Persona persona, int id) {
        personas.put(id, persona);
    }

    public void actualizarPersona (Persona persona, int id) {
        personas.replace(id, persona);
    }

    public void eliminarPersona (Persona persona, int id) {
        personas.remove(id);
    }

    public String consultarPersona () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Persona> entry : personas.entrySet()) {
            datos.append("ID: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}
