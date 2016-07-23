/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academic;

/**
 *
 * @author ALING
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Academic {
private static Connection getconn;
public static Connection koneksiDB() throws SQLException {
    if(getconn==null){
        try {
            String url = "jdbc:mysql://localhost/login";
            String user = "root";
            String pass = "ABC";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            getconn = (Connection) DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"gagal koneksi");
   
        }
    }
    return getconn;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    static Connection getconn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
