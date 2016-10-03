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
public class Llenado {

    private static int matriz[][];
    private int fila;
    private int columna;

    public Llenado() {
    }

    public Llenado(int f, int c) {
        matriz = new int[f][c];
        fila = f - 2;
        columna = c - 2;
    }

    public int[][] llenarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = Conversion.d * j;
                }
            } else {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (j == 0) {
                        matriz[i][j] = Conversion.d * i;
                    } else {
                        matriz[i][j] = seleccionarMejorOpcion(i, j);
                    }
                }
            }
        }
        return matriz;
    }

    public void recorrerMatrizInversa() {
        int f = objetos.matrizResultante.length - 1;
        int c = objetos.matrizResultante[0].length - 1;
        while (f >= 0 || c >= 0) {
            if (f > 0 && c > 0) {
                int[] posiciones = seleccionarMejorOpcionInversa(f, c);
                f = posiciones[0];
                c = posiciones[1];
            } else {
                if (fila < 0 && columna < 0) {
                    break;
                } else if (fila == 0 || columna == 0) {
                    alinear(4);
                }
            }
        }
    }

    public int seleccionarMejorOpcion(int f, int c) {
        int op1, op2, op3;
        int resultado;
        op1 = matriz[f - 1][c - 1] + Conversion.consultarValor(objetos.secuencia2.get(f - 1), objetos.secuencia1.get(c - 1));
        op2 = matriz[f][c - 1] + Conversion.d;
        op3 = matriz[f - 1][c] + Conversion.d;

        resultado = Math.max(Math.max(op1, op2), op3);
        return resultado;
    }

    public int[] seleccionarMejorOpcionInversa(int f, int c) {
        int op1, op2, op3;
        int resultado = objetos.matrizResultante[f][c];
        int posicion[] = new int[2];

        op1 = matriz[f - 1][c - 1] + Conversion.consultarValor(objetos.secuencia2.get(f - 1), objetos.secuencia1.get(c - 1));
        op2 = matriz[f][c - 1] + Conversion.d;
        op3 = matriz[f - 1][c] + Conversion.d;

        if (resultado == op1) {
            posicion[0] = f - 1;
            posicion[1] = c - 1;
            alinear(1);
        } else if (resultado == op2) {
            posicion[0] = f;
            posicion[1] = c - 1;
            alinear(2);
        } else if (resultado == op3) {
            posicion[0] = f - 1;
            posicion[1] = c;
            alinear(3);
        }
        return posicion;
    }

    public void alinear(int opcion) {
        switch (opcion) {
            case 1:
                objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(columna)));
                objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(fila)));
                fila--;
                columna--;

                break;
            case 2:
                objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(columna)));
                objetos.secuenciaAlineada2.add("-");
                columna--;

                break;
            case 3:
                objetos.secuenciaAlineada1.add("-");
                objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(fila)));
                fila--;

                break;
            case 4:
                if (fila < 0 && columna >= 0) {
                    objetos.secuenciaAlineada2.add("-");
                    objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(columna)));
                    columna--;
                } else if (columna < 0 && fila >= 0) {
                    objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(fila)));
                    objetos.secuenciaAlineada1.add("-");
                    fila--;
                }
                break;
        }
    }
}
