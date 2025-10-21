/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;

/**
 *
 * @author Laptop
 */
public class UsersPc {
    
    private int performanceScore;
    private String os;
    private String processor;
    private String graphics;
    private String memory;
    private String storage;
    
        public UsersPc(int performanceScore,String os,String processor,String graphics,String memory,String storage){
        this.performanceScore = performanceScore;
        this.os = os;
        this.processor = processor;
        this.graphics = graphics;
        this.memory = memory;
        this.storage = storage;
        }
    
    public void setPerformanceScore(int performanceScore){
        this.performanceScore = performanceScore;
    }    
     
    public void setOs(String os){
        this.os = os;
    } 
    
    public void setProcessor(String processor){
        this.processor = processor;
    } 
    
    public void setGraphics(String graphics){
        this.graphics = graphics;
    }
    
    public void setMemory(String memory){
        this.memory = memory;
    } 
    
    public void setStorage(String storage){
        this.storage = storage;
    } 
    
    public int getPerformanceScore(){
        return performanceScore;
    }
    
    public String getOs(){
        return os;
    }
    
    public String getProcessor(){
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
