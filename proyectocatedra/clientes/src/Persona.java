import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Persona {
    private static int contadorClientes = 0;
    private final int idCliente;
    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;
    private String tipoPersona;
    private EstadoCliente estado;
    private String creadoPor;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaInactivacion;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Persona(String nombre, String documento, String telefono, String correo, String direccion,
                   String tipoPersona, String creadoPor) {
        this.idCliente = ++contadorClientes;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.tipoPersona = tipoPersona;
        this.estado = EstadoCliente.ACTIVO;
        this.creadoPor = creadoPor;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    // Getters
    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getTipoPersona() { return tipoPersona; }
    public EstadoCliente getEstado() { return estado; }
    public String getCreadoPor() { return creadoPor; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public LocalDateTime getFechaInactivacion() { return fechaInactivacion; }

    // Setters
    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
        this.fechaActualizacion = LocalDateTime.now();
        if (estado == EstadoCliente.INACTIVO) {
            this.fechaInactivacion = LocalDateTime.now();
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
                        "🏛 Tipo Persona: %s\n" +
                        "🔵 Estado: %s\n" +
                        "👤 Creado por: %s\n" +
                        "📅 Fecha Creación: %s\n" +
                        "🕒 Última Actualización: %s\n" +
                        "🚫 Fecha Inactivación: %s\n" +
                        "===========================\n",
                idCliente, nombre, documento, telefono, correo,
                direccion, tipoPersona, estado, creadoPor,
                fechaCreacion.format(formatter), fechaActualizacion.format(formatter),
                fechaInactivacion != null ? fechaInactivacion.format(formatter) : "N/A"
        );
    }
}

// Cliente solo mantiene el ID
