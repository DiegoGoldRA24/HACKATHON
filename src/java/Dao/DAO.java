package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    
    private Connection cn;
    
    public void Conectar() throws Exception{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@testing.vallegrande.edu.pe:1521:XE","REGCIV","vallegrande2018");            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }        
    
    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }
    
//     public static void main(String[] args) throws Exception {
//        DAO dao = new DAO();
//        dao.Conectar();
//        if (dao.getCn() != null) {
//            System.out.println("conectado");
//        } else {
//            System.out.println("error");
//        }
//    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    
    
}
