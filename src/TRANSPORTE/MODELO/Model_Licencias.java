package TRANSPORTE.MODELO;

public class Model_Licencias {
    private int codigo;
    private String grado;
    private String detalles;

    public Model_Licencias() {
    }

    public Model_Licencias(String grado, String detalles) {
        this.grado = grado;
        this.detalles = detalles;
    }

    public Model_Licencias(int codigo, String grado, String detalles) {
        this.codigo = codigo;
        this.grado = grado;
        this.detalles = detalles;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
};