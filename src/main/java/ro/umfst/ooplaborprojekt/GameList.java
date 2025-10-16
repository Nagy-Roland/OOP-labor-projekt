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
    
   private List<GameSpecs> games = new ArrayList<>();
   
   public List<GameSpecs> getGames(){
       return games;
   }
   
   public void setGames(List<GameSpecs> games){
       this.games = games;
   }
}
