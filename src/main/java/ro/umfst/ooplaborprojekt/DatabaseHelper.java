/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Laptop
 */
public class DatabaseHelper {
    
    private Connection conn; 
    
    public Connection connect() {
        
        try {
        
            String url = "jdbc:sqlite:UsersPcSetup.db";
                return DriverManager.getConnection(url);
        
        } catch (Exception connectionFailed) {
            connectionFailed.printStackTrace();
                return null; 
        }
    }
     
    public void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS USERSPC"
             + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,"
             + "Perfscore INTEGER,"
             + "Os TEXT NOT NULL,"             
             + "Processor TEXT NOT NULL,"
             + "Graphics TEXT NOT NULL,"
             + "Memory TEXT NOT NULL,"
             + "Storage TEXT NOT NULL)";
        try(Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void insertData(UsersPc pc){
        String sql = " INSERT INTO USERSPC(Perfscore,Os,Processor,Graphics,Memory,Storage)VALUES(?,?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
