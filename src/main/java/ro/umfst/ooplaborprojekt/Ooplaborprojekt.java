/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


 
package ro.umfst.ooplaborprojekt;
import javax.swing.*;
import java.awt.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Laptop
 */
public class Ooplaborprojekt extends JFrame {

    public static void main(String[] args) {
        
        Ooplaborprojekt app = new Ooplaborprojekt();
            app.jsonRead();
            app.jframeInitialization();
        
        
           
    }
    
    public void jframeInitialization(){
        
        JFrame frame = new JFrame("System requirement check");
        JPanel panel = new JPanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel("Select a game:");
            JComboBox<String> gameList = new JComboBox<>(new String[]{"R6 Siege", "For Honor", "Naraka Bladepoint" , "League of Legends" , "Titanfall 2" , 
                "Team Fortress 2" , "Elden Ring" ,"Sekiro: Shadows Die Twice" , "Wolfenstein II: The New Colossus"});
        
        JLabel osLabel = new JLabel("Enter your Operating System:");
            JTextField osField = new JTextField(20);
            
        JLabel cpuLabel = new JLabel("Enter your CPU:");
            JTextField cpuField = new JTextField(20);  
            
        JLabel gpuLabel = new JLabel("Enter your GPU:");
            JTextField gpuField = new JTextField(20);   
            
        JLabel memoryLabel = new JLabel("Enter your RAM(GB):");
            JTextField memoryField = new JTextField(20);   
            
        JLabel storageLabel = new JLabel("Enter the amount of your free storage space:");
            JTextField storageField = new JTextField(20);   
                JButton submitButton = new JButton("Submit");
 
        panel.add(osLabel);
        panel.add(osField);
        panel.add(cpuLabel);
        panel.add(cpuField);
        panel.add(gpuLabel);
        panel.add(gpuField);
        panel.add(memoryLabel);
        panel.add(memoryField);
        panel.add(storageLabel);
        panel.add(storageField);
        panel.add(submitButton);
        
        frame.add(panel, BorderLayout.NORTH);       
        frame.setVisible(true); 
    }
    
    public void jsonRead(){
        try{
                
            ObjectMapper mapper = new ObjectMapper();
                InputStream inputStream = Ooplaborprojekt.class.getClassLoader().getResourceAsStream("GameRequirements.json");
                
            }catch(Exception jsonNotFound){   
                
                System.out.println("Json file is not found!");
                    jsonNotFound.printStackTrace();
            }  
    }
}
