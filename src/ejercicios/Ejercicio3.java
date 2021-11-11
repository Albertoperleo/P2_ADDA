package ejercicios;

import java.util.List;

import us.lsi.common.IntegerSet;

public class Ejercicio3 {

	
	/*
	 * Llamada de la función recursiva
	 */
	public static IntegerSet llamadaRecursiva(List<Integer> lista, Rango r){
		IntegerSet s = IntegerSet.empty();
		return aux(lista, r, s, Record.of(0, lista.size(), lista.size()/2), 0);
	}
	
	/*
	 * FUNCIÓN RECURSIVA:
	 * 
	 * CotaInferior: posición que ocupa el valor a del rango [a,b)
	 */
	public static IntegerSet aux(List<Integer> lista, Rango r, IntegerSet s, Record t, 
			Integer cotaInf){

		if(lista.get(cotaInf)<r.a()) {
			return s; //Si el rango está fuera de la lista devolvemos el conjunto vacío.
		}else if(lista.get(cotaInf)!=r.a()) {
			if(lista.get(t.k())<r.a()) {
				s = aux(lista, r, s, Record.of(t.i(), t.k(), (t.k()+t.i())/2 ), cotaInf);
			}else if(lista.get(t.k())>r.a()) {
				s = aux(lista, r, s, Record.of(t.k(), t.j(), (t.k()+t.j())/2 ), cotaInf);
			}else { //Hemos encontrado la cotaInferior:
				s = aux(lista, r, s, Record.of(t.k(), 0, 0), t.k());
			}	
		}else if(lista.get(cotaInf)==r.a() && lista.size()-1 >= r.b() && lista.get(t.i()) < r.b()) { 
			s.add(lista.get(t.i()));
			s = aux(lista, r, s, Record.of(t.i()-1, t.j(), t.k()), cotaInf);
		}else if(lista.get(cotaInf)==r.a() && lista.size()-1 < r.b() && t.i() > -1) {
			s.add(lista.get(t.i()));
			s = aux(lista, r, s, Record.of(t.i()-1, t.j(), t.k()), cotaInf);
		}
		
		return s;		
	}
	
	
	/*
	 * Esta será la tupla que guarde el rango dado por lista
	 */
	public static record Rango(Integer a, Integer b) {
		public static Rango of(Integer a, Integer b) {
			return new Rango(a,b);
		}
	}
	
	/*
	 * Esta será la tupla que guarde los valores de la búsqueda binaria
	 */
	public static record Record(Integer i, Integer j, Integer k) {
		public static Record of(Integer i, Integer j, Integer k) {
			return new Record(i,j,k);
		}
	}
	
}

