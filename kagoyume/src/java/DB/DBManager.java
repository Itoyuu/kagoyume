/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Yuu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db","itou","s2011026");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}
