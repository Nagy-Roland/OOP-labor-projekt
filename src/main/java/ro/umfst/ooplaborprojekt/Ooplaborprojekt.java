/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


 
package ro.umfst.ooplaborprojekt;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
/**
 *
 * @author Laptop
 */
public class Ooplaborprojekt {

    public static void main(String[] args) {
        
       ObjectMapper mapper = new ObjectMapper();
       InputStream inputStream = Ooplaborprojekt.class.getClassLoader().getResourceAsStream("GameRequirements.json");
       
        
    }
}
