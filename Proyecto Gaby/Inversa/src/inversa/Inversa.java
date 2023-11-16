package inversa;

import java.util.Scanner;

public class Inversa {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);  // creo entrada para leer los datos de consola 
        System.out.println("Ingrese el número de filas y columnas de la matriz:");
        int n = entrada.nextInt();   // valido el tamaño de la matriz 
        
        if(n != 3) {
            System.out.println("Este programa solo funciona con matrices de 3x3.");
            entrada.close();
            return;
        }

        double[][] B = new double[n][n];  // declaro un arreglo bidimencional B 
        double[][] adjunta = new double[n][n];
        
        System.out.println("Ingrese los valores de la matriz B por columna:");
        for (int j = 0; j < n; j++) {
            System.out.println("Columna " + (j + 1) + ":");
            for (int i = 0; i < n; i++) {
                B[i][j] = entrada.nextDouble();
            }
        }
         // se imprime la matriz de B
        System.out.println("Matriz B:");
        imprimirMatriz(B);

        // Calcula la matriz adjunta para calcular la matriz inversa 
        calcularMatrizAdjunta(B, adjunta);
        System.out.println("Matriz adjunta:");
        imprimirMatriz(adjunta);

        
        double determinante = calcularDeterminante(B); 
        System.out.println("Determinante: " + determinante);
        if (determinante != 0) {
            System.out.println("Matriz inversa:");
            imprimirMatriz(calcularMatrizInversa(adjunta, determinante));
        } else {
            System.out.print("Error: la matriz no tiene inversa.");
        }
        entrada.close();
    }

    
    //uso clases privadas para calcular B  calculo tambien su determinante y 
    private static double calcularDeterminante(double[][] B) {
        return B[0][0] * (B[1][1] * B[2][2] - B[1][2] * B[2][1])
                - B[0][1] * (B[1][0] * B[2][2] - B[2][0] * B[1][2])
                + B[0][2] * (B[1][0] * B[2][1] - B[2][0] * B[1][1]);
    }

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

    
    // clase para calcular la matriz inversa 
    private static double[][] calcularMatrizInversa(double[][] adjunta, double determinante) {
        double[][] inversa = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inversa[i][j] = adjunta[i][j] / determinante;
            }
        }
        return inversa;
    }

    // mando a imprimir la matriz 
    private static void imprimirMatriz(double[][] matriz) {
        for (double[] row : matriz) {
            for (double value : row) {
                System.out.print("|" + value + "|");
            }
            System.out.println();
        }
    }
}
