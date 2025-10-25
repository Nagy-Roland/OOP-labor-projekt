/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


 
package ro.umfst.ooplaborprojekt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Laptop
 */
public class Ooplaborprojekt extends JFrame {
    
    JFrame frameResults;
    JFrame framePrimary;
    
    public static void main(String[] args) {
        
        Ooplaborprojekt app = new Ooplaborprojekt();
            app.jsonRead();
            app.primaryJframeInitialization();
            app.resultsJframeInitialization();  
           
    }
    
    public Connection connect() {
        
        try {
        
            String url = "jdbc:sqlite:UsersPcSetup.db";
                return DriverManager.getConnection(url);
        
        } catch (Exception connectionFailed) {
            connectionFailed.printStackTrace();
                return null;
    }
    }
    public void primaryJframeInitialization(){
        
        framePrimary = new JFrame("System requirement check");
        JPanel panel = new JPanel();
       
        framePrimary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrimary.setSize(1000, 800);
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
         
        panel.add(label);  
        panel.add(gameList);
        panel.add(Box.createVerticalStrut(100)); 
        panel.add(osLabel);
        panel.add(osField);
        panel.add(Box.createVerticalStrut(50));
        panel.add(cpuLabel);
        panel.add(cpuField);
        panel.add(Box.createVerticalStrut(50));
        panel.add(gpuLabel);
        panel.add(gpuField);
        panel.add(Box.createVerticalStrut(50));
        panel.add(memoryLabel);
        panel.add(memoryField);
        panel.add(Box.createVerticalStrut(50));
        panel.add(storageLabel);
        panel.add(storageField);
        panel.add(Box.createVerticalStrut(50));
        panel.add(submitButton);
        
        framePrimary.add(panel, BorderLayout.NORTH);       
        framePrimary.setVisible(true); 
        
        submitButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                      setInputUsersPc(osField,cpuField,gpuField,memoryField,storageField);
                      showResults();
                }
        }); 
    }
     
    public void resultsJframeInitialization(){
        
        frameResults = new JFrame("Results");
        JPanel panel2 = new JPanel();
        
        frameResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameResults.setSize(1000, 800);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        frameResults.add(panel2);          
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
    
    public void setInputUsersPc(JTextField osField,JTextField cpuField,JTextField gpuField,JTextField memoryField,JTextField storageField){
       
        UsersPc userspc = new UsersPc();
        userspc.setOs(osField.getText());
        userspc.setProcessor(cpuField.getText());
        userspc.setGraphics(gpuField.getText());
        userspc.setMemory(memoryField.getText());
        userspc.setStorage(storageField.getText());
            
    }
    
    public void showResults(){
        frameResults.setVisible(true);
    }
            
            
}
