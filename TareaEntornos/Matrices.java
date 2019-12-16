package TareaEntornos;

import java.util.ArrayList;

public class Matrices {

	int[][] matriz1 = new int[10][10];
	int[][] matriz2 = new int[3][3];
	
	//Constructor que genera la matriz 1 que es aleatoria
	public Matrices() {
		for(int i = 0 ; i < matriz1.length; i++) {
			for( int j = 0; j < matriz1.length; j++) {
				matriz1[j][i] = (int) Math.round(Math.random() * (100 - 0)) + 0;
			}
		}
	}
	
	
	//Mostramos la matriz 1
	public void mostrarMatriz1() {
		
		System.out.println("\nMostrando la matriz 1");
		
		for(int i = 0 ; i < matriz1.length; i++) {
			
			for( int j = 0; j < matriz1.length; j++) {
				System.out.print(matriz1[j][i] + " ");
			}
			
		System.out.println();
		
		}
	}
	
	//Método para mostrar la matriz 2
	public void mostrarMatriz2() {
		
		System.out.println("\nMostrando la matriz 2");
		
		for(int j = 0 ; j < matriz2.length; j++) {
			
			for( int i = 0; i < matriz2.length; i++) {
				System.out.print(matriz2[i][j] + " ");
			}
			
			System.out.println();
			
		}
	}
	
	//Método auxiliar para ver que número estamos modificando
	public void mostrarNumModificar(int x, int y) {
		System.out.println("\nEl numero modificado es : " + matriz1[x-1][y-1]);
	}
	
	//Método para sumar la media a la matriz 1 como nos pide el ejercicio
	public void generarMedia(int x, int y) {
		//Suponemos que el usuario no entiende de programación y para el las posiciones de la matriz son del 1-10 (de este modo restamos 1 para trabajar con nuestra matriz)
		x= x-1;
		y= y-1;
		
		//variables usadas para la media
		int celdasUsadas = 0;
		int media = 0;
		
		//Si la posicion que nos da el usuario es valida
		if(x > -1 && x < 10 && y > -1 && y < 10) {
		
		//Llenamos nuestra matriz 2 con la posición elegida por el usuario y los valores que la rodean
		asignarMatriz2(x,y);
		
		for(int j = 0; j < matriz2.length; j++) {
			for(int i = 0; i < matriz2.length; i++) {
				//Si nuestra matriz 2 contiene un valor válido (mayor a -1) lo tenemos en cuenta para la media
				if(matriz2[i][j] != -1) {
					celdasUsadas++;
					media = media + matriz2[i][j];
				}
			}
		}
		
		//Quitamos de la media el valor central ya que vamos a usar los valores que le rodean
		media = media - matriz2[1][1];
		celdasUsadas = celdasUsadas-1;
		
		//Se calcula la media real y se suma a la celda de matriz 1
		media = media/celdasUsadas;
		matriz1[x][y] = matriz1[x][y] + media;	
		
		//Le mostramos al usuario la matriz 2 que se ha generado y la media
		mostrarMatriz2();
		
		System.out.println("\nEl valor a modificar es de : " + matriz2[1][1]);
		System.out.println("\nLa media calculada es de : " + media);
		}
		
		//Si el usuario no introduce valores validos le pedimos que lo haga
		else System.out.println("\nDebe introducir dos posiciones entre 1 y 10");

	}
	
	
	//Método usado para asignar un valor a la matriz 2
	public void asignarMatriz2(int x, int y) {
		
		//variable auxiliar por si la celda que elije el usuario se encuentra en algún borde de la matriz
		int tamanioMax = matriz2.length;
		
		//Primero llenamos nuestra matriz de valores -1 
		for(int j = 0; j < matriz2.length; j++) {
			for(int i = 0; i < matriz2.length; i++) {
				
				matriz2[i][j] = -1;
			}
		}
		
		//Asignamos como posición central la elegida por el usuario
		matriz2[1][1] = matriz1[x][y];
		
		//Si la celda elegida por el usuario no esta en la fila 0 ( la primera de la matriz 1)
		if(y > 0) {
			for(int i = 0; i < tamanioMax; i++) {
				//Se comprueba si existe un valor a la izquierda de la celda que queremos(Si no existe entonces solo tomamos el valor central y de la derecha)
				if(x-1+i < 0) i++;
				
				//Se comprueba si existe un valor a la derecha de la celda que queremos(Si no existe entonces solo tomamos los valores central y de la izquierda)
				if(x == 10) tamanioMax = 2;
				
				matriz2[i][0] = matriz1[x-1+i][y-1];
			}
		}
		
		//Asignamos el valor a la izquierda del elegido por el usuario (Si existe)
		if(x > 0) {
			matriz2[0][1] = matriz1[x-1][y];
		}
		
		//Asignamos el valor a la derecha del elegido por el usuario (Si existe)
		if(x < 10) {
			matriz2[2][1] = matriz1[x+1][y];
		}
		
		//Si la celda elegida por el usuario no esta en la fila 9 ( la última de nuestra matriz 1)
		if(y < 10) {
			for(int i = 0; i < tamanioMax; i++) {
				//Se comprueba si existe un valor a la izquierda de la celda que queremos(Si no existe entonces solo tomamos el valor central y de la derecha)
				if(x-1+i < 0) i++;
				
				//Se comprueba si existe un valor a la derecha de la celda que queremos(Si no existe entonces solo tomamos los valores central y de la izquierda)
				if(x == 10) tamanioMax = 2;
				
				matriz2[i][2] = matriz1[x-1+i][y+1];
			}
		}
		
		
		

	}
}
