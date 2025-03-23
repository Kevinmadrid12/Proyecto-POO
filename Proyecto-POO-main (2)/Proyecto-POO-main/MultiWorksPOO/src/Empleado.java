import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Empleado extends Persona {
    private int idEmpleado;
    private String tipoContratacion;
    private HashMap<Integer,Empleado> empleados = new HashMap<>();

    public int getIdEmpleado() {
        return idEmpleado;
    }

    //Constructores
    public Empleado () {}
    public Empleado(int idEmpleado, String nombre, String documento, String telefono, String correo, String direccion, String estado, String creadoPor, Date fechaCreacion, Date fechaActualizacion, Date fechaInactivacion, String tipoContratacion) {
        super(nombre, documento, telefono, correo, direccion, estado, creadoPor, fechaCreacion, fechaActualizacion, fechaInactivacion);

        this.idEmpleado = idEmpleado;
        this.tipoContratacion = tipoContratacion;
    }

    public void crearPersona (Empleado empleado) {
        empleados.put(empleado.getIdEmpleado(), empleado);
    }

    public void actualizarPersona (Empleado empleado) {
        empleados.replace(empleado.getIdEmpleado(), empleado);
    }

    public void eliminarPersona (Empleado empleado) {
        empleados.remove(empleado.getIdEmpleado());
    }

    public String consultarPersona () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Empleado> entry : empleados.entrySet()) {
            datos.append("ID empleado: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}
