import java.util.HashMap;
import java.util.Map;

public class Subtarea extends Datos {
    private int idSubtarea, idAsignacion;
    private String tituloSubtarea, descripcionSubtarea;
    private Asignacion asignacion;
    private HashMap<Integer,Subtarea> subtareas = new HashMap<>();

    public int getIdSubtarea() {
        return idSubtarea;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    //Constructores
    public Subtarea() {}
    public Subtarea(int idSubtarea, String tituloSubtarea, String descripcionSubtarea) {
        this.idSubtarea = idSubtarea;
        this.tituloSubtarea = tituloSubtarea;
        this.descripcionSubtarea = descripcionSubtarea;
        this.asignacion = null; 
    }

    public void crearSubtarea(Subtarea subtarea) {
        subtareas.put(subtarea.getIdSubtarea(), subtarea);
    }

    public void actualizarSubtarea(Subtarea subtarea) {
        subtareas.replace(subtarea.getIdSubtarea(), subtarea);
    }

    public void eliminarSubtarea(Subtarea subtarea) {
        subtareas.remove(subtarea.getIdSubtarea());
    }

    public String consultarSubtarea () {
        StringBuilder datos = new StringBuilder();
        for (Map.Entry<Integer,Subtarea> entry : subtareas.entrySet()) {
            datos.append("ID subtarea: ").append(entry.getKey()).append(", datos: ").append(entry.getValue()).append("\n");
        }
        return datos.toString();
    }
}
