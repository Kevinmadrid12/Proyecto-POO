public class Subtareas {
    private int idSubtarea;
    private String tituloSubtarea;
    private String descripcionSubtarea;
    private Asignacion asignacion; // Relación con Asignacion (ya implementada en otro lado)

    public Subtareas(int idSubtarea, String tituloSubtarea, String descripcionSubtarea) {
        this.idSubtarea = idSubtarea;
        this.tituloSubtarea = tituloSubtarea;
        this.descripcionSubtarea = descripcionSubtarea;
        this.asignacion = null; // Inicialmente sin asignación
    }

    // Getters y Setters
    public int getIdSubtarea() {
        return idSubtarea;
    }

    public void setIdSubtarea(int idSubtarea) {
        this.idSubtarea = idSubtarea;
    }

    public String getTituloSubtarea() {
        return tituloSubtarea;
    }

    public void setTituloSubtarea(String tituloSubtarea) {
        this.tituloSubtarea = tituloSubtarea;
    }

    public String getDescripcionSubtarea() {
        return descripcionSubtarea;
    }

    public void setDescripcionSubtarea(String descripcionSubtarea) {
        this.descripcionSubtarea = descripcionSubtarea;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    // Método para asignar una subtarea a una asignación existente
    public void asignarSubtarea(Asignacion asignacion) {
        if (this.asignacion == null) { // Solo asignar si aún no tiene
            this.asignacion = asignacion;
        }
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "idSubtarea=" + idSubtarea +
                ", tituloSubtarea='" + tituloSubtarea + '\'' +
                ", descripcionSubtarea='" + descripcionSubtarea + '\'' +
                ", asignacion=" + (asignacion != null ? "Asignada" : "No asignada") +
                '}';
    }
}
