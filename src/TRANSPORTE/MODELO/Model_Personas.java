package TRANSPORTE.MODELO;

public class Model_Personas {

    private int documento;
    private String nombre;
    private String telefono;
    private String correo;
    private String estado;
    private String tipo;
    private int categoria;

    public Model_Personas(int documento, String nombre, String telefono, String correo, String tipo, int categoria, String estado) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.tipo = tipo;
        this.categoria = categoria;
    } 
    
    public Model_Personas() {
    }
    
    public Model_Personas(int identificacion, String nombre, String telefono, String correo,
    String estado) {
        this.documento = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}