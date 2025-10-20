/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;
/**
 *
 * @author Laptop
 */
public class Game {
    
    private String name;
    private Requirement requirements;
    
    public Game(){}
    
public void setName(String name){
    this.name = name;
} 

public void setRequirements(Requirement requirements){
    this.requirements = requirements;
} 

public String getName(){
    return name;  
}

public Requirement getRequirements(){
    return requirements;
}

}
