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

    private int i;
    private int j;

    public Llenado() {
    }

    public void llenarMatriz() {
        for (int j = 0; j < objetos.matrizResultante[0].length; j++) {
            objetos.matrizResultante[0][j] = Conversion.d * j;
        }

        for (int i = 0; i < objetos.matrizResultante.length; i++) {
            objetos.matrizResultante[i][0] = Conversion.d * i;
        }

        for (int i = 1; i < objetos.matrizResultante.length; i++) {
            for (int j = 1; j < objetos.matrizResultante[i].length; j++) {
                objetos.matrizResultante[i][j] = seleccionarMejorOpcion(i, j);
            }
        }
    }

    public void recorrerMatrizInversa() {
        i = objetos.matrizResultante.length - 1;
        j = objetos.matrizResultante[0].length - 1;
        while (i > 0 && j > 0) {
            int[] posiciones = seleccionarMejorOpcionInversa(i, j);
            i = posiciones[0];
            j = posiciones[1];
        }

        while (i > 0) {
            alinear(5);
        }

        while (j > 0) {
            alinear(4);
        }

    }

    public int seleccionarMejorOpcion(int f, int c) {
        int op1, op2, op3;
        int resultado;
        op1 = objetos.matrizResultante[f - 1][c - 1] + Conversion.consultarValor(objetos.secuencia2.get(f - 1), objetos.secuencia1.get(c - 1));
        op2 = objetos.matrizResultante[f - 1][c] + Conversion.d;
        op3 = objetos.matrizResultante[f][c - 1] + Conversion.d;

        resultado = Math.max(Math.max(op1, op2), op3);
        return resultado;
    }

    public int[] seleccionarMejorOpcionInversa(int f, int c) {
        int op1, op2, op3;
        int resultado = objetos.matrizResultante[f][c];
        int posicion[] = new int[2];

        op1 = objetos.matrizResultante[f - 1][c - 1] + Conversion.consultarValor(objetos.secuencia2.get(f - 1), objetos.secuencia1.get(c - 1));
        op2 = objetos.matrizResultante[f - 1][c] + Conversion.d;
        op3 = objetos.matrizResultante[f][c - 1] + Conversion.d;

        if (resultado == op1) {
            posicion[0] = f - 1;
            posicion[1] = c - 1;
            alinear(1);
        } else if (resultado == op2) {
            posicion[0] = f - 1;
            posicion[1] = c;
            alinear(2);
        } else if (resultado == op3) {
            posicion[0] = f;
            posicion[1] = c - 1;
            alinear(3);
        }
        return posicion;
    }

    public void alinear(int opcion) {
        switch (opcion) {
            case 1:
                objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(j - 1)));
                objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(i - 1)));
                i--;
                j--;

                break;
            case 2:
                objetos.secuenciaAlineada1.add("-");
                objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(i - 1)));
                i--;
                break;
                
            case 3:
                objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(j - 1)));
                objetos.secuenciaAlineada2.add("-");
                j--;
                break;
                
            case 4:

                objetos.secuenciaAlineada2.add("-");
                objetos.secuenciaAlineada1.add(Conversion.transcribirInversa(objetos.secuencia1.get(j - 1)));

                j--;
                break;
            case 5:

                objetos.secuenciaAlineada2.add(Conversion.transcribirInversa(objetos.secuencia2.get(i - 1)));
                objetos.secuenciaAlineada1.add("-");

                i--;
                break;
        }
    }
}
