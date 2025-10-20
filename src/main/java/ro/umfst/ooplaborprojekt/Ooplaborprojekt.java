/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


 
package ro.umfst.ooplaborprojekt;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Laptop
 */
public class Ooplaborprojekt {

    public static void main(String[] args) {
        
        try{
                
            ObjectMapper mapper = new ObjectMapper();
                InputStream inputStream = Ooplaborprojekt.class.getClassLoader().getResourceAsStream("/GameRequirements.json"); 
                
                    try{ 
                        
                        GameList gameList = mapper.readValue(inputStream,GameList.class);                        
                        System.out.println(gameList.getGames());
                     
                    }catch(Exception jsonReadError){
                        System.out.println("Json file cant be read!");
                    }
                 
        }catch(Exception jsonNotFound){           
            System.out.println("Json file is not found!");
        }
                       
      
              
       
    }
}
