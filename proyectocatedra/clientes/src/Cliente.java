class Cliente extends Persona {

    public Cliente(String nombre, String documento, String telefono, String correo, String direccion,
                   String tipoPersona, String creadoPor) {
        super(nombre, documento, telefono, correo, direccion, tipoPersona, creadoPor);
    }
}

enum EstadoCliente {
    ACTIVO, INACTIVO
}