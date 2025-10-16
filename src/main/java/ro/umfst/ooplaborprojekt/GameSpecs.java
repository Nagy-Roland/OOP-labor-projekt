/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;

/**
 *
 * @author Laptop
 */
public class GameSpecs {
    
    private String os;
    private String processor;
    private String graphics;
    private String memory;
    private String storage;

        public GameSpecs(String os,String processor,String graphics,String memory,String storage){
        this.os = os;
        this.processor = processor;
        this.graphics = graphics;
        this.memory = memory;
        this.storage = storage;
        
    }
    public void setOs(){
        this.os = os;     
    }   
    
    public void setProcessor(){
        this.processor = processor;
    }  
    
    public void setGraphics(){
        this.graphics = graphics;
    }
    
    public void setMemory(){
        this.memory = memory;
    }
      
    public void setStorage(){
        this.storage = storage;
    }
    
    public String getOs(){
        return os;
    }
    
    public String getprocessor(){
        return processor;
    }
    
    public String getGraphics(){
        return graphics;        
    }
    
    public String getMemory(){
        return memory;
    }   
        
    public String getStorage(){
        return storage;
    }
}
