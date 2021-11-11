package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ejercicios.Ejercicio3.Rango;
import ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class Test_ejercicio3 {

	public static void main(String[] args) {
		test("./ficheros/PI2Ej3DatosEntrada.txt");
	}
		
	public static void test(String ruta) {
		
		List<Tupla> t = transformar(ruta);
		
		for(int i = 0; i< t.size(); i++) {
			System.out.println(String.format("Lista: %s", t.get(i).ls().toString()));
			System.out.println(String.format("Rango: [%s,%s)", t.get(i).r().a(), t.get(i).r().b()));
			System.out.println(String.format("Conjunto obtenido: %s", Ejercicio3.llamadaRecursiva( t.get(i).ls(), t.get(i).r() )));
			System.out.println("_________________________________________________________________\n");
		}	
	}
	
	
	public static List<Tupla> transformar(String ruta) {
		List<String> l = Files2.linesFromFile(ruta);
		
		List<String[]> lSplit = l.stream()
				.map(x -> x.replace("#", ","))
				.map(x -> x.split(","))
				.collect(Collectors.toList());
		
		List<List<Integer>> lParseada = lSplit.stream()
				.map(x -> parseoInt(x))
				.collect(Collectors.toList());
		
		return lParseada.stream()
				.map(x -> Tupla.parseoTupla(x))
				.collect(Collectors.toList());
	}
	
	public static List<Integer> parseoInt(String[] array){
		List<Integer> lEnteros = new ArrayList<Integer>();
		for(String s : array) {
			Integer n = Integer.parseInt(s);
			lEnteros.add(n);
		}
		return lEnteros;
	}
	
	public static record Tupla(List<Integer> ls, Rango r) {
		public static Tupla of(List<Integer> ls, Rango r) {
			return new Tupla(ls,r);
		}
		public static Tupla parseoTupla(List<Integer> lEnteros) {
			Rango r = Rango.of(lEnteros.get(11), lEnteros.get(12));
			List<Integer> lInt = new ArrayList<Integer>();
			for(int i = 0; i<11; i++) {
				lInt.add(lEnteros.get(i));
			}
			return Tupla.of(lInt, r);
		}
	}
	

}
