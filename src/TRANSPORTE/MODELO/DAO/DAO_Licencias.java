
package TRANSPORTE.MODELO.DAO;

import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.TABLES_VIEWS.Model_View_DetallesLicencias;
import TRANSPORTE.MODELO.UTILS.Database;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class DAO_Licencias {

    public boolean verifyLicencia(int idTransportista, int idLicencia){
        String sql = "SELECT * FROM TRANSPORTISTAS_LICENCIAS WHERE TRANSPORTISTA = "
            + idTransportista + " AND LICENCIA = " + idLicencia + " ;";
        return !new Database().ejecutar(sql).isEmpty();
    }

    public int insertLicencia(int idTransportista, int idLicencia, String codigo, String vencimiento, int estatus){
        int result;

        // COMPROBAMOS QUE NO HAYA UNA LICENCIA REGISTRADA
        if(!verifyLicencia(idTransportista, idLicencia)){

            String sql = "INSERT INTO TRANSPORTISTAS_LICENCIAS (TRANSPORTISTA, LICENCIA, CODIGO, VENCIMIENTO, ESTATUS) VALUES ("
                + idTransportista + "," + idLicencia + ",'" + codigo + "','" + vencimiento + "'," + estatus + ");";
    
            result = new Database().actualizar(sql);
            
        }else{ // SI NO ACTUALIZAMOS
            result = updateLicencia(idTransportista, idLicencia, codigo, vencimiento,  estatus);
        }
        return result;
    };

    public int updateLicencia(int idTransportista, int idLicencia, String codigo, String vencimiento, int estatus){
        String sql = "UPDATE TRANSPORTISTAS_LICENCIAS SET "
        +"CODIGO = '"+ codigo 
        +"', VENCIMIENTO = '"+ vencimiento 
        +"', ESTATUS = "+ estatus 
        +" WHERE TRANSPORTISTA = " + idTransportista + " AND LICENCIA = " + idLicencia + " ;";

        return new Database().actualizar(sql);
    };

    public Model_Transportista_Licencias getLicencia(int id){
        String sql = "SELECT * FROM TRANSPORTISTAS_LICENCIAS WHERE ID = "+ id +" AND ESTATUS != 99;";

        List<Map> registros = new Database().ejecutar(sql);
        Model_Transportista_Licencias licencia = null;

        for (Map registro : registros) {
            licencia = new Model_Transportista_Licencias(
            (int)registro.get("id"),
            (int)registro.get("transportista"),
            (int)registro.get("licencia"),
            (String)registro.get("codigo"),
            (Date)registro.get("vencimiento"),
            (registro.get("estatus").equals(1)) ? "VIGENTE" : "VENCIDA");
        }

        return licencia;
    }

    public List getAllLicencias(){
        String sql = "SELECT * FROM LICENCIAS;";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Licencias> licencias = new ArrayList();

        for (Map registro : registros) {
  
            Model_Licencias licencia = new Model_Licencias(
                (int)registro.get("codigo"),
                (String)registro.get("grado"),
                (String)registro.get("detalles")
                );

                licencias.add(licencia);
        }

        return licencias;
    }

    public List getAllViewLicenciasTransportista(int transportista){
        String sql = "SELECT * FROM \"DETALLES LICENCIAS\" WHERE \"CEDULA\" = " + transportista + ";";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_View_DetallesLicencias> licencias = new ArrayList();

        for (Map registro : registros) {
  
            Model_View_DetallesLicencias licencia = new Model_View_DetallesLicencias(
                (int)registro.get("ID LICENCIA"),
                (int)registro.get("CEDULA"),
                (String)registro.get("TRANSPORTISTA"),
                (String)registro.get("CODIGO"),
                (String)registro.get("TIPO"),
                (String)registro.get("DESCRIPCION"),
                (Date)registro.get("FECHA DE VENCIMIENTO"),
                (int)registro.get("ESTADO")
                );

                licencias.add(licencia);
        }

        return licencias;
    }

    public List getAllLicenciasTransportista(int transportista){
        String sql = "SELECT * FROM TRANSPORTISTAS_LICENCIAS WHERE TRANSPORTISTA = " + transportista + " AND ESTATUS != 99;";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Transportista_Licencias> licencias = new ArrayList();

        for (Map registro : registros) {
  
            Model_Transportista_Licencias licencia = new Model_Transportista_Licencias(
                (int)registro.get("id"),
                (int)registro.get("transportista"),
                (int)registro.get("licencia"),
                (String)registro.get("codigo"),
                (Date)registro.get("vencimiento"),
                (registro.get("estatus").equals(1)) ? "VIGENTE" : "VENCIDA");

                licencias.add(licencia);
        }

        return licencias;
    }

    public int deleteLicencias(int idTransportista, int idLicencia){

        if(!verifyLicencia(idTransportista, idLicencia)){
            return 0;
        }else{
            // EL ESTATUS 99 ES PARA LOS ELIMINADO LOGICAMENTE
            String sql = "UPDATE TRANSPORTISTAS_LICENCIAS SET ESTATUS = 99 WHERE TRANSPORTISTA = "
            + idTransportista + " AND LICENCIA = " + idLicencia + " ;";
            return new Database().actualizar(sql);
        }
    }
}
