/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;

import java.util.ArrayList;

/**
 *
 * @author CristianCamilo
 */
public class objetos {

    public static ArrayList<Integer> secuencia1 = new ArrayList<>();
    public static ArrayList<Integer> secuencia2 = new ArrayList<>();

    public static ArrayList<String> secuenciaAlineada1 = new ArrayList<>();
    public static ArrayList<String> secuenciaAlineada2 = new ArrayList<>();

    public static int matrizResultante[][];

    public objetos() {
    }

    public static void reiniciar() {
        secuencia1 = new ArrayList<>();
        secuencia2 = new ArrayList<>();
        secuenciaAlineada1 = new ArrayList<>();
        secuenciaAlineada2 = new ArrayList<>();
    }

    public static int consultarValor(int f, int c) {
        return matrizResultante[f][c];
    }
}
