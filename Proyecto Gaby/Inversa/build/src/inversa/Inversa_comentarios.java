/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inversa;

/**
 *
 * @author AnS
 */


import java.util.Scanner;  // Importación de la clase Scanner desde el paquete java.util

public class Inversa_comentarios{  // Declaración de la clase principal llamada 'Inversa'

    public static void main(String[] args) {  // Método principal que se ejecuta al iniciar el programa
        Scanner entrada = new Scanner(System.in);  // Creación de un objeto Scanner para leer datos desde la consola

        System.out.println("Ingrese el número de filas y columnas de la matriz:");  // Mensaje solicitando el tamaño de la matriz
        int n = entrada.nextInt();  // Lectura del tamaño de la matriz desde la consola

        if (n != 3) {  // Verificación de que el tamaño de la matriz sea 3x3
            System.out.println("Este programa solo funciona con matrices de 3x3.");  // Mensaje de error si el tamaño no es 3x3
            entrada.close();  // Cierre del objeto Scanner
            return;  // Salida del programa
        }

        double[][] B = new double[n][n];  // Declaración de una matriz bidimensional 'B' de tamaño n x n
        double[][] adjunta = new double[n][n];  // Declaración de otra matriz bidimensional 'adjunta' del mismo tamaño

        System.out.println("Ingrese los valores de la matriz B por columna:");  // Mensaje solicitando los valores de la matriz
        for (int j = 0; j < n; j++) {  // Bucle para recorrer las columnas de la matriz
            System.out.println("Columna " + (j + 1) + ":");  // Mensaje indicando la columna actual
            for (int i = 0; i < n; i++) {  // Bucle para recorrer las filas de la matriz
                B[i][j] = entrada.nextDouble();  // Lectura de valores desde la consola y asignación a la matriz 'B'
            }
        }

        System.out.println("Matriz B:");  // Mensaje indicando que se va a imprimir la matriz B
        imprimirMatriz(B);  // Llamada a la función 'imprimirMatriz' para mostrar la matriz B

        calcularMatrizAdjunta(B, adjunta);  // Llamada a la función 'calcularMatrizAdjunta' para calcular la matriz adjunta
        System.out.println("Matriz adjunta:");  // Mensaje indicando que se va a imprimir la matriz adjunta
        imprimirMatriz(adjunta);  // Llamada a la función 'imprimirMatriz' para mostrar la matriz adjunta

        double determinante = calcularDeterminante(B);  // Llamada a la función 'calcularDeterminante' para obtener el determinante
        System.out.println("Determinante: " + determinante);  // Impresión del valor del determinante

        if (determinante != 0) {  // Verificación de que el determinante no sea cero
            System.out.println("Matriz inversa:");  // Mensaje indicando que se va a imprimir la matriz inversa
            imprimirMatriz(calcularMatrizInversa(adjunta, determinante));  // Llamada a la función 'imprimirMatriz' para mostrar la matriz inversa
        } else {
            System.out.print("Error: la matriz no tiene inversa.");  // Mensaje de error si el determinante es cero
        }

        entrada.close();  // Cierre del objeto Scanner
    }

    // Función privada para calcular el determinante de una matriz
    private static double calcularDeterminante(double[][] B) {
        return B[0][0] * (B[1][1] * B[2][2] - B[1][2] * B[2][1])
                - B[0][1] * (B[1][0] * B[2][2] - B[2][0] * B[1][2])
                + B[0][2] * (B[1][0] * B[2][1] - B[2][0] * B[1][1]);
    }

    // Función privada para calcular la matriz adjunta
    private static void calcularMatrizAdjunta(double[][] B, double[][] adjunta) {
        adjunta[0][0] = (B[1][1] * B[2][2] - B[1][2] * B[2][1]);
        adjunta[0][1] = -(B[1][0] * B[2][2] - B[1][2] * B[2][0]);
        adjunta[0][2] = (B[1][0] * B[2][1] - B[1][1] * B[2][0]);
        adjunta[1][0] = -(B[0][1] * B[2][2] - B[0][2] * B[2][1]);
        adjunta[1][1] = (B[0][0] * B[2][2] - B[0][2] * B[2][0]);
        adjunta[1][2] = -(B[0][0] * B[2][1] - B[0][1] * B[2][0]);
        adjunta[2][0] = (B[0][1] * B[1][2] - B[0][2] * B[1][1]);
        adjunta[2][1] = -(B[0][0] * B[1][2] - B[0][2] * B[1][0]);
        adjunta[2][2] = (B[0][0] * B[1][1] - B[0][1] * B[1][0]);
    }

    // Función privada para calcular la matriz inversa
    private static double[][] calcularMatrizInversa(double[][] adjunta, double determinante) {
        double[][] inversa = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inversa[i][j] = adjunta[i][j] / determinante;
            }
        }
        return inversa;
    }

    // Función privada para imprimir una matriz
    private static void imprimirMatriz(double[][] matriz) {
        for (double[] row : matriz) {
            for (double value : row) {
                System.out.print("|" + value + "|");
            }
            System.out.println();
        }
    }
}
