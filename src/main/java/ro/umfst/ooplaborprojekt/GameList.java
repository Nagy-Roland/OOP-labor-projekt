/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laptop
 */
public class GameList {
    
   private List<Game> games = new ArrayList<>();
   
   public GameList(){} 
   
    public void setGames(List<Game> games){
       this.games = games;
   }
   
   public List<Game> getGames(){
       return games;
   }
    
}
