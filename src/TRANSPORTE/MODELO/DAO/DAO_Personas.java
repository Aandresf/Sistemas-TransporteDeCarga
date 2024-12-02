
package TRANSPORTE.MODELO.DAO;

import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.UTILS.Database;
import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class DAO_Personas {

    public int insertPersona(int identificacion, String nombre, String telefono, String correo, String tipo, int categoria, int estatus){
        int result;

        // COMPROBAMOS QUE NO ESTE ELIMINADO LOGICAMENTE
        if(new Database().ejecutar("SELECT * FROM PERSONAS WHERE DOCUMENTO = " + identificacion + " AND ESTATUS = 99;").isEmpty()){

            String sql = "INSERT INTO PERSONAS (DOCUMENTO, NOMBRE, TELEFONO, CORREO, TIPO, CATEGORIA, ESTATUS) VALUES (" 
            + identificacion + ",'" + nombre + "','" + telefono + "','" + correo + "','" + tipo + "'," + categoria + "," + estatus + ");";
    
            result = new Database().actualizar(sql);
            
        }else{ // SI ESTA ELIMINADO LOGICAMENTE LO ACTUALIZAMOS
            result = updatePersona(identificacion, nombre, telefono, correo, tipo, categoria, estatus);
        }
        return result;
    };

    public int updatePersona(int identificacion, String nombre, String telefono, String correo, String tipo, int categoria, int estatus){
        String sql = "UPDATE PERSONAS SET "
        +"DOCUMENTO = '"+ identificacion
        +"', NOMBRE = '"+ nombre
        +"', TELEFONO = '"+ telefono 
        +"', CORREO = '"+ correo
        +"', TIPO = '"+ tipo
        +"', CATEGORIA = "+ categoria 
        +", ESTATUS = "+ estatus 
        +" WHERE DOCUMENTO = "+ identificacion +";";

        return new Database().actualizar(sql);
    };

    public Model_Personas getTransportista(int id){
        String sql = "SELECT * FROM PERSONAS WHERE DOCUMENTO = "+ id +" AND CATEGORIA = 2 AND ESTATUS != 99;";

        List<Map> registros = new Database().ejecutar(sql);
        Model_Personas transportista = null;

        for (Map registro : registros) {
            transportista = new Model_Personas(
            (int)registro.get("documento"),
            (String)registro.get("nombre"),
            (String)registro.get("telefono"),
            (String)registro.get("correo"),
            (String)registro.get("tipo"),
            (int)registro.get("categoria"),
            (registro.get("estatus").equals(1)) ? "DISPONIBLE" : "NO DISPONIBLE");
        }

        return transportista;
    }

    public List getAllTransportistas(){
        String sql = "SELECT * FROM PERSONAS WHERE CATEGORIA = 2 AND ESTATUS != 99;";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Personas> transportistas = new ArrayList();

        for (Map registro : registros) {
  
            Model_Personas transportista = new Model_Personas(
            (int)registro.get("documento"),
            (String)registro.get("nombre"),
            (String)registro.get("telefono"),
            (String)registro.get("correo"),
            (String)registro.get("tipo"),
            (int)registro.get("categoria"),
            (registro.get("estatus").equals(1)) ? "DISPONIBLE" : "NO DISPONIBLE");

            transportistas.add(transportista);
        }

        return transportistas;
    }

    public int deletePersona(int id){
        
        // EL ESTATUS 99 ES PARA LOS TRANSPORTISTAS ELIMINADO LOGICAMENTE
        String sql = "UPDATE PERSONAS SET ESTATUS = 99 WHERE DOCUMENTO = "+ id +";";
        return new Database().actualizar(sql);
    }
}
