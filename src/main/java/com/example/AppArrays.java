package com.example;

import java.util.Arrays;

public class AppArrays {
    public static void main(String[] args) {
        int x[]={1,2,3} ;
        //int y[][]=new int[3][3];
        int z[][]={{1,2,3},{2,3,4,5}};   
         
        x[0]=1;
        System.out.println("x=" + x[0]);
        System.out.println("x=" + Arrays.toString(x));       
        System.out.println("z[0]=" + Arrays.toString(z[0]));     
        System.out.println("z[1]=" + Arrays.toString(z[1]));       
        z[0]=new int[]{1,2};
        System.out.println("z[0]=" + Arrays.toString(z[0])); 
        
        int vetor1[]=new int[5];
        for (int i = 0; i < vetor1.length; i++) {
            vetor1[i]=100*i;
        }
        System.out.println("vetor1=" + Arrays.toString(vetor1));  

        int matriz[][]=new int[5][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=100*(i+j);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%5d",matriz[i][j]);
            }
            System.out.println();
        }
  
 
    }
}
