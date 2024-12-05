/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO;

/**
 *
 * @author arnal
 */
public class Model_PuntoControl {
    private int id;
    private String descripcion;
    private String coordX;
    private String coordY;

    public Model_PuntoControl() { }

    public Model_PuntoControl(String descripcion, String coordX, String coordY) {
        this.descripcion = descripcion;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Model_PuntoControl(int id, String descripcion, String coordX, String coordY) {
        this.id = id;
        this.descripcion = descripcion;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCoordX() { return coordX;  }

    public void setCoordX(String coordX) { this.coordX = coordX; }

    public String getCoordY() { return coordY; }

    public void setCoordY(String coordY) { this.coordY = coordY; }
}
