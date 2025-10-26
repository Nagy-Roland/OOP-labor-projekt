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

import java.io.File;                 
import java.io.FileNotFoundException; 
import java.util.Scanner;   
/**
 *
 * @author Laptop
 */
public class Ooplaborprojekt extends JFrame {
    
    DatabaseHelper db;
    JFrame frameResults;
    JFrame framePrimary;
    JFrame frameIdResults;
    
    public static void main(String[] args) {
      
        Ooplaborprojekt app = new Ooplaborprojekt();
        
            app.jsonRead();           
            app.primaryJframeInitialization();
            app.resultsJframeInitialization();  
            app.idBasedResultsJframeInitialization(); 
            app.dataBasePcComponentsInitialization();
    }
    
    public void dataBasePcComponentsInitialization(){
        
        db = new DatabaseHelper();
          db.connectComps("jdbc:sqlite:PcComponentsPerfScore.db");          
          db.ceatePcComponentTable("CPU");
          db.ceatePcComponentTable("GPU");
          db.ceatePcComponentTable("RAM");
          db.ceatePcComponentTable("STORAGE");
          db.fileReadAndWrite("PcComponents.txt");
    }
    
    public void primaryJframeInitialization(){
        
        framePrimary = new JFrame("System requirement check");
        JPanel panel = new JPanel();
       
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        framePrimary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrimary.setSize(1000, 800);
        framePrimary.setResizable(false);
       
        Dimension size = new Dimension(150, 25);
        
        JLabel label = new JLabel("Select a game:");
            JComboBox<String> gameList = new JComboBox<>(new String[]{"R6 Siege", "For Honor", "Naraka Bladepoint" , "League of Legends" , "Titanfall 2" , 
                "Team Fortress 2" , "Elden Ring" ,"Sekiro: Shadows Die Twice" , "Wolfenstein II: The New Colossus"});
                    gameList.setMaximumSize(size);
                        gameList.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel osLabel = new JLabel("Enter your Operating System:");
            osLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
        JLabel osExampleLabel = new JLabel("Example: Windows 10,Windows 7");
            osLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
             
            JTextField osField = new JTextField(20);
                osField.setMaximumSize(size);
                    osField.setAlignmentX(Component.LEFT_ALIGNMENT); 
                    
        JLabel cpuLabel = new JLabel("Enter your CPU:");
            cpuLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel cpuExampleLabel = new JLabel("Example: Ryzen 7 5800X,Intel i5-12600K");
            cpuExampleLabel.setAlignmentX(LEFT_ALIGNMENT);
             
            JTextField cpuField = new JTextField(20);  
                cpuField.setMaximumSize(size);
                    cpuField.setAlignmentX(Component.LEFT_ALIGNMENT);
                    
        JLabel gpuLabel = new JLabel("Enter your GPU:");
            gpuLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
         JLabel gpuExampleLabel = new JLabel("Example: GTX 1050 Ti,RTX 3060");
            gpuExampleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JTextField gpuField = new JTextField(20);   
                gpuField.setMaximumSize(size);
                    gpuField.setAlignmentX(Component.LEFT_ALIGNMENT);  
                    
        JLabel memoryLabel = new JLabel("Enter your RAM:");
            memoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                                 
            JLabel memoryExampleLabel = new JLabel("Example:Corsair 16GB");
                memoryExampleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                
            JTextField memoryField = new JTextField(20);   
                memoryField.setMaximumSize(size);
                    memoryField.setAlignmentX(Component.LEFT_ALIGNMENT);
                    
        JLabel storageLabel = new JLabel("Enter your Disk Storage:");
            storageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                
        JLabel storageExampleLabel = new JLabel("Example:Samsung 970 EVO 1TB");
            storageExampleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            JTextField storageField = new JTextField(20);   
                storageField.setMaximumSize(size);
                    storageField.setAlignmentX(Component.LEFT_ALIGNMENT);
                    
        JButton submitButton = new JButton("Submit");
        JLabel buttonLabel = new JLabel("Already submitted?");
        JButton openIdBasedSearchButton = new JButton ("Search by ID");
             
            
        panel.add(label);  
        panel.add(gameList);
        
        panel.add(Box.createVerticalStrut(50)); 
        
        panel.add(osLabel);
        panel.add(osExampleLabel);
        panel.add(osField);
        
        panel.add(Box.createVerticalStrut(25));
        
        panel.add(cpuLabel);
        panel.add(cpuExampleLabel);
        panel.add(cpuField);
        
        panel.add(Box.createVerticalStrut(25));
        
        panel.add(gpuLabel);
        panel.add(gpuExampleLabel);
        panel.add(gpuField);
        
        panel.add(Box.createVerticalStrut(25));
        
        panel.add(memoryLabel);
        panel.add(memoryExampleLabel);
        panel.add(memoryField);
        
        panel.add(Box.createVerticalStrut(25));
        
        panel.add(storageLabel);
        panel.add(storageExampleLabel);
        panel.add(storageField);
        
        panel.add(Box.createVerticalStrut(25));
        
        panel.add(submitButton);
        panel.add(Box.createVerticalStrut(25));
        panel.add(buttonLabel);
        panel.add(openIdBasedSearchButton);
        
        framePrimary.add(panel);       
        framePrimary.setVisible(true); 
        
        submitButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    setInputUsersPc(osField,cpuField,gpuField,memoryField,storageField);
                        db.connectUsers("jdbc:sqlite:UsersPcSetup");
                        db.createUserTable();
                        db.closeUsers();
                        showResults();
                }
        }); 
        
        openIdBasedSearchButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    frameIdResults.setVisible(true);
                }
        });
    }
     
    public void resultsJframeInitialization(){
        
        frameResults = new JFrame("Results");
        JPanel panel2 = new JPanel();
        
        frameResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameResults.setSize(1000, 800);
        frameResults.setResizable(false);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        frameResults.add(panel2);          
    }
     
    public void idBasedResultsJframeInitialization(){
        
        frameIdResults = new JFrame("Id based results");
        JPanel panel3 = new JPanel();
        
        frameIdResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameIdResults.setSize(1000, 800);   
        frameIdResults.setResizable(false);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        JLabel idLabel = new JLabel("Enter your ID:");
            JTextField idField = new JTextField(20);
            
        JButton searchButton = new JButton("Search");     
         
        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        
        panel3.add(idLabel);
        panel3.add(idField);
        panel3.add(searchButton);
        panel3.add(resultsArea);
        
        frameIdResults.add(panel3,BorderLayout.NORTH);
      
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
