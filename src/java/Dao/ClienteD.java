package Dao;

import Model.ClienteM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteD extends DAO{
    
    public void agregarCli(ClienteM cm) throws Exception{   
        this.Conectar();
        try {
            String sql = "INSERT INTO CLIENTE (NOMCLI,APECLI,DNICLI,NUMASI,ORIGEN,DESTINO) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cm.getNOMCLI());
            ps.setString(2, cm.getAPECLI());
            ps.setString(3, cm.getDNICLI());
            ps.setString(4, cm.getNUMASI());
            ps.setString(5, cm.getORIGEN());
            ps.setString(6, cm.getDESTINO());
            ps.executeUpdate();
        } catch (SQLException e) {  //to_date(?,'DD/MM/YYYY')
            throw e;
        }
      }
    
    public void deleteCli(ClienteM cm) throws Exception{
        this.Conectar();
        try {
            String sql = "DELETE FROM CLIENTE WHERE CODCLI = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cm.getCODCLI());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<ClienteM> listar() throws Exception{
        List<ClienteM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM CLIENTE";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ClienteM cm;
            while(rs.next()){
                cm = new ClienteM();
                cm.setCODCLI(rs.getString("CODCLI"));
                cm.setNOMCLI(rs.getString("NOMCLI"));
                cm.setAPECLI(rs.getString("APECLI"));
                cm.setDNICLI(rs.getString("DNICLI"));
                cm.setNUMASI(rs.getString("NUMASI"));
                cm.setORIGEN(rs.getString("ORIGEN"));
                cm.setDESTINO(rs.getString("DESTINO"));
                lista.add(cm);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public void update(ClienteM cm) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE CLIENTE SET NOMCLI = ? , APECLI = ? , DNICLI = ? , NUMASI = ?,  ORIGEN = ? , DESTINO = ? WHERE CODCLI = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);            
            ps.setString(1, cm.getNOMCLI());
            ps.setString(2, cm.getAPECLI());
            ps.setString(3, cm.getDNICLI());
            ps.setString(4, cm.getNUMASI());
            ps.setString(5, cm.getORIGEN());           
            ps.setString(6, cm.getDESTINO());
            ps.setString(7, cm.getCODCLI());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
