package Dao;

import Model.ViajeM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViajeD extends DAO{
    
    public void agregarVia(ViajeM vm) throws Exception{   
        this.Conectar();
        try {
            String sql = "INSERT INTO VIAJES (CODCLI,FECVIA,FECPOST,COSTO) VALUES (?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vm.getCODCLI());
            ps.setString(2, vm.getFECVIA());
            ps.setString(3, vm.getFECPOST());
            ps.setString(4, vm.getCOSTO());
            ps.executeUpdate();
        } catch (SQLException e) { 
            throw e;
        }
      }
    
    public void deleteVia(ViajeM vm) throws Exception{
        this.Conectar();
        try {
            String sql = "DELETE FROM VIAJES WHERE CODVIA = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vm.getCODVIA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<ViajeM> listar() throws Exception{
        List<ViajeM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VIAJES";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            ViajeM vm;
            while(rs.next()){
                vm = new ViajeM();
                vm.setCODCLI(rs.getString("CODVIA"));
                vm.setCODCLI(rs.getString("CODCLI"));
                vm.setFECVIA(rs.getString("FECVIA"));
                vm.setFECPOST(rs.getString("FECPOST"));
                vm.setCOSTO(rs.getString("COSTO"));
                lista.add(vm);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public void update(ViajeM vm) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE VIAJES SET CODCLI = ? , FECVIA = ? , FECPOST = ? , COSTO = ? WHERE CODVIA = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);            
            ps.setString(1, vm.getCODCLI());
            ps.setString(2, vm.getFECVIA());
            ps.setString(3, vm.getFECPOST());
            ps.setString(4, vm.getCOSTO());
            ps.setString(5, vm.getCODVIA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
