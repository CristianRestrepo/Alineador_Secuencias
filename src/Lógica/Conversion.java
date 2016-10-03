/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;

/**
 *
 * @author CristianCamilo
 */
public class Conversion {

    public static int matrizConversion[][] = new int[4][4];
    public static int d = -5;
            
    
    public Conversion() {             
      
        matrizConversion[0][0] = 10;
        matrizConversion[0][1] = -1;
        matrizConversion[0][2] = -3;
        matrizConversion[0][3] = -4;
       
        matrizConversion[1][0] = -1;
        matrizConversion[1][1] = 7;
        matrizConversion[1][2] = -5;
        matrizConversion[1][3] = -3;
       
        matrizConversion[2][0] = -3;
        matrizConversion[2][1] = -5;
        matrizConversion[2][2] = -9;
        matrizConversion[2][3] = 0;
       
        matrizConversion[3][0] = -4;
        matrizConversion[3][1] = -3;
        matrizConversion[3][2] = 0;
        matrizConversion[3][3] = 8;
    }

    public static int transcribir(String s) {
        int valor = 0;
        if (s.equals("A")) {
            valor = 1;
        } else if (s.equals("G")) {
            valor = 2;
        } else if (s.equals("C")) {
            valor = 3;
        } else if (s.equals("T")) {
            valor = 4;
        }
        return valor;
    }

    public static String transcribirInversa(int s) {
        String valor = "";
        if (s == 1) {
            valor = "A";
        } else if (s == 2) {
            valor = "G";
        } else if (s == 3) {
            valor = "C";
        } else if (s == 4) {
            valor = "T";
        }
        return valor;
    }

    public static int consultarValor(int f, int c) {
        return matrizConversion[f-1][c-1];
    }
    
    

}
