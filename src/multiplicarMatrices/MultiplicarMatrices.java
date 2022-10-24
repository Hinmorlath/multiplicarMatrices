/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multiplicarMatrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Estudiante
 */
public class MultiplicarMatrices {

    /**
     * @param args the command line arguments
     */
    
    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;
    
    public static int[][] crearMatriz() throws IOException{
        int r, c;
        
        System.out.println("¿Cuántos renglones tiene la matriz?");
        entrada = bufer.readLine();
        r = Integer.parseInt(entrada);
        
        System.out.println("¿Cuántas columnas tiene la matriz?");
        entrada = bufer.readLine();
        c = Integer.parseInt(entrada);
        
        int[][] matriz = new int[r][c];
        for (int i = 0; i < matriz.length; i++) 
            for (int j = 0; j < matriz[i].length; j++){
                System.out.println("Ingrese valor [" + i + "][" + j + "]: ");
                entrada = bufer.readLine();
                matriz[i][j] = Integer.parseInt(entrada);
            }
        
        return matriz;
    }
    
    public static void imprimirMatriz(int[][] matriz){
        System.out.println("-------------------------------------------");
        for (int i = 0; i < matriz.length; i++){ 
            for(int j = 0; j < matriz[i].length; j++){
                System.out.printf("%4d",matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2){
        int[][] resultado = new int[matriz1.length][matriz2[0].length];
        
        for (int i = 0; i < resultado.length; i++) 
            for (int j = 0; j < resultado[0].length; j++) 
                for (int k = 0; k < matriz2.length; k++) 
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
        
        return resultado;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        int[][] matriz1;
        int[][] matriz2;
        int[][] resultado = new int[0][0];
        
        System.out.println("Ingresa las matrices que se desea multiplicar");
        
        matriz1 = crearMatriz();
        matriz2 = crearMatriz();
        imprimirMatriz(matriz1);
        imprimirMatriz(matriz2);
        
        System.out.println("Analizando si se pueden multiplicar...");
        if(matriz1[0].length == matriz2.length)
            resultado = multiplicarMatrices(matriz1, matriz2);
        else
            System.out.println("No se pueden multiplicar estas matrices");
        
        imprimirMatriz(resultado);
        
    }
    
}
