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
    
    private Connection connUsers; 
    private Connection connComps;
            
    public Connection connect(String url) {
        
        try {                  
                return DriverManager.getConnection(url);
        
        } catch (Exception connectionFailed) {
            connectionFailed.printStackTrace();
                return null; 
        }
        
    }
     
    public void createUserTable(){
        
        String sql = "CREATE TABLE IF NOT EXISTS USERSPC"
             + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,"
             + "Perfscore INTEGER,"
             + "Os TEXT NOT NULL,"             
             + "Processor TEXT NOT NULL,"
             + "Graphics TEXT NOT NULL,"
             + "Memory TEXT NOT NULL,"
             + "Storage TEXT NOT NULL)";
        
        try(Statement stmt = connUsers.createStatement()){
            
            stmt.execute(sql);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void ceatePcComponentTable(String componentName){
        
        String sql = "CREATE TABLE IF NOT EXISTS"+ componentName 
            + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "Perfscore INTEGER)";
        
        try(Statement stmt = connComps.createStatement()){
            
            stmt.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void insertData(UsersPc pc){
        
        String sql = " INSERT INTO USERSPC(Perfscore,Os,Processor,Graphics,Memory,Storage)VALUES(?,?,?,?,?,?)";
        
        try(PreparedStatement pstmt = connUsers.prepareStatement(sql)){
            
        pstmt.setInt(1,pc.getPerformanceScore());
        pstmt.setString(2, pc.getOs());
        pstmt.setString(3, pc.getProcessor());
        pstmt.setString(4, pc.getGraphics());
        pstmt.setString(5, pc.getMemory());
        pstmt.setString(6, pc.getStorage());
        pstmt.executeUpdate();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    public void getData(UsersPc pc){
        
        String sql = " SELECT * FROM ";
        
        try(Statement stmt = connUsers.createStatement()){
            
            stmt.execute(sql);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void close(){
        try{
            if(conn!=null)conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }           
    }
}
