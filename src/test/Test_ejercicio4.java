package test;

import java.util.List;
import java.util.stream.Collectors;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;

public class Test_ejercicio4 {

	public static void main(String[] args) {
		test("./ficheros/PI2Ej4DatosEntrada.txt");
	}
	
	public static void test(String ruta) {
		List<Integer> l = parseo(Files2.linesFromFile(ruta));
		
		String patron = "Entero de entrada:        %d\n"
					  + "Sol. Rec. sin memoria:    %d\n"
					  + "Sol. Rec. con memoria:    %d\n"
					  + "Sol. Iterativa:           %d\n"
				+ "______________________________________________________________";
		
		for(int i = 0; i<l.size(); i++) {
			System.out.println(String.format(patron, 
					l.get(i),
					Ejercicio4.llamadaRSM(l.get(i)),
					Ejercicio4.llamadaRM(l.get(i)),
					Ejercicio4.iterativo(l.get(i))));
		}
		
	}
	
	public static List<Integer> parseo(List<String> s){
		return s.stream()
				.map(x -> x.substring(2))
				.map(x -> Integer.valueOf(x))
				.collect(Collectors.toList());
	}
	
	
}
