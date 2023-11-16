/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inversa;

/**
 *
 * @author AnS
 */
import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el tamaño de la matriz cuadrada:");
        int n = entrada.nextInt();

        double[][] matriz = new double[n][n];
        double[][] adjunta = new double[n][n];

        System.out.println("Ingrese los valores de la matriz por fila:");
        for (int i = 0; i < n; i++) {
            System.out.println("Fila " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                matriz[i][j] = entrada.nextDouble();
            }
        }

        calcularMatrizAdjunta(matriz, adjunta);

        System.out.println("Matriz adjunta:");
        imprimirMatriz(adjunta);

        entrada.close();
    }

    private static void calcularMatrizAdjunta(double[][] matriz, double[][] adjunta) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calcular cofactor y asignar a la matriz adjunta
                adjunta[i][j] = cofactor(matriz, i, j) * Math.pow(-1, i + j);
            }
        }
    }

    private static double cofactor(double[][] matriz, int fila, int columna) {
        int n = matriz.length - 1;
        double[][] submatriz = new double[n][n];
        int subi = 0, subj = 0;

        // Crear submatriz excluyendo la fila y columna dadas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i != fila && j != columna) {
                    submatriz[subi][subj++] = matriz[i][j];

                    // Cambiar de fila al llegar al final de la fila
                    if (subj == n) {
                        subj = 0;
                        subi++;
                    }
                }
            }
        }

        // Calcular el determinante de la submatriz
        double determinanteSubmatriz = calcularDeterminante(submatriz);

        // Devolver el cofactor multiplicado por el determinante de la submatriz
        return determinanteSubmatriz;
    }

    private static double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;

        if (n == 1) {
            return matriz[0][0];
        }

        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        double determinante = 0;

        for (int i = 0; i < n; i++) {
            determinante += matriz[0][i] * cofactor(matriz, 0, i);
        }

        return determinante;
    }

    private static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.print("|" + valor + "|");
            }
            System.out.println();
        }
    }
}

