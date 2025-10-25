/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.ooplaborprojekt;

/**
 *
 * @author Laptop
 */
public final class Util {
   
    private Util(){}
    
    public static double overallPerformanceScore(int osScore,int cpuScore,int gpuScore,int memoryScore,int storageScore){
       return gpuScore * 0.5 + cpuScore * 0.2 + memoryScore * 0.15 +  storageScore * 0.05;
    }
}
