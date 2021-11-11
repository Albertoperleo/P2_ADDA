package test;

import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.Matrix;
import ejercicios.Ejercicio2;

public class Test_ejercicio2 {

	public static void main(String[] args) {
		test();
	}
	
	public static Matrix<String> creacionMatrix(String ruta){
		List<String> l = Files2.linesFromFile(ruta);
		Integer filas = l.size();
		Integer columnas = filas; //va a ser una matriz cuadrada
		String[][] array = new String[filas][columnas];
		
		for(int i = 0; i<filas; i++) {
			for(int j = 0; j<columnas; j++) {
				//separamos las palabras por los espacios
				String[] linea = l.get(i).split(" ");
				//introducimos cada palabra en su posición en la matriz
				array[i][j] = linea[j];
			}
		}
		return Matrix.of(array);
	}
	
	public static void test() {
		for(int i = 1; i<=2; i++) {
			Matrix<String> m = creacionMatrix("./ficheros/PI2Ej2DatosEntrada"+i+".txt");
			List<String> l = Ejercicio2.recursivoMatrizLlamada(m);
			
			System.out.println("ENTRADA "+i);
			System.out.println("Lista de caracteres obtenida:");
			for(int j = 0; j<l.size(); j++) {
				System.out.println(String.format("%s)  %s", j+1, l.get(j)));
			}
			System.out.println("______________________________________________________________\n");
		}
	}
	

}
