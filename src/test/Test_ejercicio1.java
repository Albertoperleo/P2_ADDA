package test;

import ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class Test_ejercicio1 {

	public static void main(String[] args) {
		Files2.streamFromFile("./ficheros/PI2Ej1DatosEntrada.txt")
				.forEach(linea -> test(linea));
	}
	
	
	public static void test(String linea) {
		String[] trozos = linea.split(","); //separamos la línea en varios trozos por la coma
		
		String e = String.format("(a, b, c) = (%s, %s, %s)", trozos[0], trozos[1], trozos[2]);
		String rnf = String.format("Rec. No Final: %s", 
						Ejercicio1.llamadaRecursivoNoFinal(Integer.valueOf(trozos[0]),Integer.valueOf(trozos[1]), Integer.valueOf(trozos[2])));
		String rf = String.format("Rec. Final: %s", 
				Ejercicio1.llamadaRecursivoFinal(Integer.valueOf(trozos[0]),Integer.valueOf(trozos[1]), Integer.valueOf(trozos[2])));
		String i = String.format("Iterativo: %s", 
				Ejercicio1.iterativo(Integer.valueOf(trozos[0]),Integer.valueOf(trozos[1]), Integer.valueOf(trozos[2])));
		String f = String.format("Funcional: %s", 
				Ejercicio1.funcional(Integer.valueOf(trozos[0]),Integer.valueOf(trozos[1]), Integer.valueOf(trozos[2])));
		
		impresion(e,rnf,rf,i,f);
	}
	
	public static void impresion(String entrada, String recNoFin, String recFin, String iter, String func) {
		System.out.println(entrada);
		System.out.println(recNoFin);
		System.out.println(recFin);
		System.out.println(iter);
		System.out.println(func);
		System.out.println("__________________________________________________________________________________\n");
	}

}
