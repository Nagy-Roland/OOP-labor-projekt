/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;
/**
 *
 * @author Laptop
 */
public class Requirement {
    
    private GameSpec minimum;
    private GameSpec recommended;
    private GameSpec maximum;
    public Requirement(){}
    
public void setMinimum(GameSpec minimum){
    this.minimum = minimum;
}

public void setRecommended(GameSpec recommended){
    this.recommended = recommended;
}

public void setMaximum(GameSpec maximum){
    this.maximum = maximum;
}

public GameSpec getMinimum(){
    return minimum; 
}

public GameSpec getRecommended(){
    return recommended; 
}

public GameSpec getMaximum(){
    return maximum; 
}
}