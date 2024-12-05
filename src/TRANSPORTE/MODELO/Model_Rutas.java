/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO;

/**
 *
 * @author arnal
 */
public class Model_Rutas {

    private int id;
    private String descripcion;
    private int kilometros;

    public Model_Rutas() { }
    
    public Model_Rutas(String descripcion, int kilometros) {
        this.descripcion = descripcion;
        this.kilometros = kilometros;
    }

    public Model_Rutas(int id, String descripcion, int kilometros) {
        this.id = id;
        this.descripcion = descripcion;
        this.kilometros = kilometros;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getKilometros() { return kilometros; }

    public void setKilometros(int kilometros) { this.kilometros = kilometros; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
