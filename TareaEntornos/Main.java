package TareaEntornos;

public class Main {

	public static void main(String[] args) {
		
		Matrices matriz = new Matrices();
		//Mostramos la matriz que se ha creado
		matriz.mostrarMatriz1();
		
		//Llamamos al método para modificar la matriz
		matriz.generarMedia(1,1);
		
		System.out.println("\nMostrando la matriz modificada");
		matriz.mostrarMatriz1();
	}

}
