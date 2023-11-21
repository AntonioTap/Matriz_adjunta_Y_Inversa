# Matriz_adjunta_Y_Inversa
# Calculadora de Matriz Adjunta e Inversa

Este programa en Java calcula la matriz adjunta e inversa de una matriz cuadrada de tamaño 3x3.

## Uso

1. Ejecuta el programa.
2. Ingresa el número de filas y columnas de la matriz (debe ser 3x3).
3. Ingresa los valores de la matriz por columna.
4. Observa la matriz ingresada.
5. Calcula y muestra la matriz adjunta.
6. Calcula y muestra el determinante de la matriz.
7. Si el determinante no es cero, calcula y muestra la matriz inversa.
8. Si el determinante es cero, muestra un mensaje de error indicando que la matriz no tiene inversa.

## Funciones Principales

- `calcularMatrizAdjunta`: Calcula la matriz adjunta de una matriz cuadrada.
- `calcularDeterminante`: Calcula el determinante de una matriz 3x3.
- `calcularMatrizInversa`: Calcula la matriz inversa de una matriz 3x3.

## Matriz Adjunta e Inversa

### Matriz Adjunta
La matriz adjunta se calcula intercambiando los elementos en la diagonal principal y cambiando el signo de los elementos fuera de la diagonal.

### Matriz Inversa
La matriz inversa se calcula dividiendo cada elemento de la matriz adjunta por el determinante de la matriz original. La matriz tiene inversa solo si el determinante es diferente de cero.

## Requisitos

- Java SDK instalado.

## Ejemplo de Salida

Ingrese el número de filas y columnas de la matriz:
3
Ingrese los valores de la matriz B por columna:
Columna 1:
1
2
3
Columna 2:
4
5
6
Columna 3:
7
8
9
Matriz B:
|1.0||4.0||7.0|
|2.0||5.0||8.0|
|3.0||6.0||9.0|
Matriz adjunta:
|-3.0||6.0||-3.0|
|6.0||-12.0||6.0|
|-3.0||6.0||-3.0|
Determinante: 0.0
Error: la matriz no tiene inversa.
