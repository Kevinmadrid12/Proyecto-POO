import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class Persona {
    private static int contadorClientes = 0;
    private final int idCliente;
    protected String nombre, documento, telefono, correo, direccion, creadoPor;
    protected EstadoCliente estado;
    protected Date fechaCreacion, fechaActualizacion, fechaInactivacion;
    private HashMap<Integer, Persona> personas = new HashMap<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructores
    public Persona() {
        this.idCliente = ++contadorClientes;
    }

    public Persona(String nombre, String documento, String telefono, String correo, String direccion, String creadoPor, String por, Date fechaCreacion, Date fechaActualizacion, Date fechaInactivacion) {
        this.idCliente = ++contadorClientes;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.creadoPor = creadoPor;
        this.estado = EstadoCliente.ACTIVO;
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }

    // Métodos de gestión en el HashMap
    public void crearPersona(Persona persona) {
        personas.put(persona.idCliente, persona);
    }

    public void actualizarPersona(Persona persona) {
        personas.replace(persona.idCliente, persona);
        persona.fechaActualizacion = new Date();
    }

    public void eliminarPersona(int id) {
        personas.remove(id);
    }

    public String consultarPersonas() {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer, Persona> entry : personas.entrySet()) {
            datos.append("ID: ").append(entry.getKey()).append(", Datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    // Setters
    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
        this.fechaActualizacion = new Date();
        if (estado == EstadoCliente.INACTIVO) {
            this.fechaInactivacion = new Date();
        }
    }

    @Override
    public String toString() {
        return String.format(
                "\n========= Cliente =========\n" +
                        "🆔 ID Cliente: %d\n" +
                        "👤 Nombre: %s\n" +
                        "📄 Documento: %s\n" +
                        "📞 Teléfono: %s\n" +
                        "📧 Correo: %s\n" +
                        "🏠 Dirección: %s\n" +
                        "🔵 Estado: %s\n" +
                        "👤 Creado por: %s\n" +
                        "📅 Fecha Creación: %s\n" +
                        "🕒 Última Actualización: %s\n" +
                        "🚫 Fecha Inactivación: %s\n" +
                        "===========================\n",
                idCliente, nombre, documento, telefono, correo,
                direccion, estado, creadoPor,
                formatter.format(fechaCreacion.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime()),
                formatter.format(fechaActualizacion.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime()),
                fechaInactivacion != null ? formatter.format(fechaInactivacion.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime()) : "N/A"
        );
    }
}

// Enum de EstadoCliente

