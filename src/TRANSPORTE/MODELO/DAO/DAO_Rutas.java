/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO.DAO;

import TRANSPORTE.MODELO.Model_PuntoControl;
import TRANSPORTE.MODELO.Model_RutaControl;
import TRANSPORTE.MODELO.Model_Rutas;
import TRANSPORTE.MODELO.UTILS.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnal
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DAO_Rutas {

    public int updateRuta(int id, String descripcion, int kilometros){
        String sql = "UPDATE RUTAS SET "
        +"DESCRIPCION = '"+ descripcion 
        +"', KILOMETROS = "+ kilometros 
        +" WHERE ID = "+ id +";";

        return new Database().actualizar(sql);
    };

    public int updateControl(int id, String descripcion, String coordX, String coordY){
        String sql = "UPDATE PUNTOS_CONTROL SET"
        +" COORDENADAS_X = '"+ coordX
        +"', COORDENADAS_Y = '"+ coordY
        +"'DESCRIPCION = '"+ descripcion 
        +"' WHERE ID = "+ id +";";

        return new Database().actualizar(sql);
    };

    public int insertRuta(int km, String descripcion){
        String sql = "INSERT INTO RUTAS (DESCRIPCION, KILOMETROS) VALUES ('"
        + descripcion + "'," + km + ");";
        
        Database conexion = new Database();
    
        if( conexion.actualizar(sql) > 0 ){
            List<Map> obj = conexion.ejecutar("SELECT currval(pg_get_serial_sequence('RUTAS', 'id'));");
            int i = Integer.parseInt(obj.getFirst().get("currval").toString());
            
            return i;
        } else return 0;
    };

    public int insertControl(String descripcion, String coordX, String coordY){
        
        String sql = "INSERT INTO PUNTOS_CONTROL (COORDENADAS_X, COORDENADAS_Y, DESCRIPCION) VALUES ('"
            + coordX + "','" + coordY + "','" + descripcion + "');";
    
            Database conexion = new Database();
    
            if( conexion.actualizar(sql) > 0 ){
                List<Map> obj = conexion.ejecutar("SELECT currval(pg_get_serial_sequence('PUNTOS_CONTROL', 'id'));");
                int i = Integer.parseInt(obj.getFirst().get("currval").toString());
                
                return i;
            } else return 0;
    };

    public void insertRutaControl(int control, int ruta){
        
        String sql = "INSERT INTO RUTA_CONTROL (PUNTO_CONTROL, RUTA) VALUES ("
            + control + "," + ruta + ");";
    
        new Database().actualizar(sql);
    };

    public void deleteRutaControl(int control, int ruta){
        
        String sql = "DELETE FROM RUTA_CONTROL WHERE RUTA = "
            + ruta + " AND PUNTO_CONTROL = " + control + ");";
    
        new Database().actualizar(sql);
    };

    public Model_PuntoControl getControl(int id){
        String sql = "SELECT * FROM PUNTOS_CONTROL WHERE ID = "+ id +";";
    
        List<Map> registros = new Database().ejecutar(sql);
        Model_PuntoControl obj = null;

        for (Map registro : registros) {
            obj = new Model_PuntoControl(
            (int)registro.get("id"),
            (String)registro.get("descripcion"),
            (String)registro.get("coordenadas_x"),
            (String)registro.get("coordenadas_y"));
        }

        return obj;
    }

    public Model_Rutas getRuta(int id){
        String sql = "SELECT * FROM RUTAS WHERE ID = "+ id +";";
    
        List<Map> registros = new Database().ejecutar(sql);
        Model_Rutas obj = null;

        for (Map registro : registros) {
            obj = new Model_Rutas(
            (int)registro.get("id"),
            (String)registro.get("descripcion"),
            (int)registro.get("kilometros"));
        }

        return obj;
    }

    public List getAllRutas(){
        String sql = "SELECT * FROM RUTAS;";
    
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Rutas> listObjs = new ArrayList();

        for (Map registro : registros) {
            Model_Rutas obj = new Model_Rutas(
                (int)registro.get("id"),
                (String)registro.get("descripcion"),
                (int)registro.get("kilometros"));

            listObjs.add(obj);
        }

        return listObjs;
    }

    public List getRutaAllControl(int id){
        String sql = "SELECT * FROM RUTA_CONTROL WHERE RUTA = "+ id +";";
    
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_RutaControl> listObjs = new ArrayList();

        for (Map registro : registros) {
            Model_RutaControl obj = new Model_RutaControl(
                (int)registro.get("punto_control"),
                (int)registro.get("ruta")
                );

            listObjs.add(obj);
        }

        return listObjs;
    }
    
}