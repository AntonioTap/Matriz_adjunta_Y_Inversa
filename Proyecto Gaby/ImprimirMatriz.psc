Algoritmo Inversa
    Definir n, i, j Como Entero
    Definir B[3][3], adjunta[3][3] Como Real
    Definir determinante Como Real
    
    Escribir "Ingrese el número de filas y columnas de la matriz:"
    Leer n
    
    Si n <> 3 Entonces
        Escribir "Este programa solo funciona con matrices de 3x3."
FinAlgoritmo
FinSi

Para i = 0 Hasta 2 Hacer
	Para j = 0 Hasta 2 Hacer
		B[i][j] = 0
		adjunta[i][j] = 0
	FinPara
FinPara

Escribir "Ingrese los valores de la matriz B por columna:"
Para j = 0 Hasta n-1 Hacer
	Escribir "Columna ", (j + 1), ":"
	Para i = 0 Hasta n-1 Hacer
		Leer B[i][j]
	FinPara
FinPara

Escribir "Matriz B:"
ImprimirMatriz(B)

CalcularMatrizAdjunta(B, adjunta)
Escribir "Matriz adjunta:"
ImprimirMatriz(adjunta)

determinante = CalcularDeterminante(B)
Escribir "Determinante: ", determinante

Si determinante <> 0 Entonces
	Escribir "Matriz inversa:"
	ImprimirMatriz(CalcularMatrizInversa(adjunta, determinante))
Sino
	Escribir "Error: la matriz no tiene inversa."
FinSi
FinAlgoritmo

Funcion CalcularDeterminante(B: Matriz Real) Como Real
		Devolver B[0][0] * (B[1][1] * B[2][2] - B[1][2] * B[2][1])
		- B[0][1] * (B[1][0] * B[2][2] - B[2][0] * B[1][2])
		+ B[0][2] * (B[1][0] * B[2][1] - B[2][0] * B[1][1])
FinFuncion

Proceso CalcularMatrizAdjunta(B: Matriz Real, adjunta: Matriz Real)
			adjunta[0][0] = (B[1][1] * B[2][2] - B[1][2] * B[2][1])
			adjunta[0][1] = -(B[1][0] * B[2][2] - B[1][2] * B[2][0])
			adjunta[0][2] = (B[1][0] * B[2][1] - B[1][1] * B[2][0])
			adjunta[1][0] = -(B[0][1] * B[2][2] - B[0][2] * B[2][1])
			adjunta[1][1] = (B[0][0] * B[2][2] - B[0][2] * B[2][0])
			adjunta[1][2] = -(B[0][0] * B[2][1] - B[0][1] * B[2][0])
			adjunta[2][0] = (B[0][1] * B[1][2] - B[0][2] * B[1][1])
			adjunta[2][1] = -(B[0][0] * B[1][2] - B[0][2] * B[1][0])
			adjunta[2][2] = (B[0][0] * B[1][1] - B[0][1] * B[1][0])
FinProceso

Funcion CalcularMatrizInversa(adjunta: Matriz Real, determinante: Real) Como Matriz Real
			Definir inversa[3][3] Como Real
			Para i = 0 Hasta 2 Hacer
				Para j = 0 Hasta 2 Hacer
					inversa[i][j] = adjunta[i][j] / determinante
				FinPara
			FinPara
			Devolver inversa
FinFuncion

Proceso ImprimirMatriz(matriz: Matriz Real)
		Para i = 0 Hasta 2 Hacer
			Para j = 0 Hasta 2 Hacer
				Escribir "|" + matriz[i][j] + "|"
			FinPara
			Escribir ""
		FinPara
FinProceso
