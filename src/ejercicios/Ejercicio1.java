package ejercicios;

import java.util.stream.Stream;

public class Ejercicio1 {
	
	
	public static boolean esPar(Integer a) {
		return a%2==0 ? true : false;
	}

	
	/*
	 * RECURSIVO NO FINAL:
	 */
	
	public static String llamadaRecursivoNoFinal(Integer a, Integer b, Integer c) {
		String s = new String();	//cadena vacía que le pasaremos a la función
		return recursivoNoFinal(a,b,c,s);
	}
	public static String recursivoNoFinal(Integer a, Integer b, Integer c, String s) {
		
		if(a<3 && b<3 && c<3) { //si los 3 números a la vez son menores que 3
			s = String.format("(%s)", a*b*c);
		}else if(a<5 || b<5 || c<5) { //si alguno de los 3 números es menor que 5
			s = String.format("(%s)", a+b+c);
		}else if(esPar(a) && esPar(b) && esPar(c)) { //si los 3 números a la vez son pares
			//modificación + llamada recursiva
			s = String.format("%s", a*b*c) + recursivoNoFinal(a/2, b-2, c/2, s);
		}else {
			//modificación + llamada recursiva
			s = String.format("%s", a+b+c) + recursivoNoFinal(a/3, b-3, c/3, s);
		}
		
		return s;
	}
	
	
	/*
	 * RECURSIVO FINAL:
	 */
	
	public static String llamadaRecursivoFinal(Integer a, Integer b, Integer c) {
		String s = new String(); //String vacío
		return recursivoFinal(a,b,c,s);
	}
	public static String recursivoFinal(Integer a, Integer b, Integer c, String s) {
		
		if(a<3 && b<3 && c<3) { //si los 3 números a la vez son menores que 3
			s = s + String.format("(%s)", a*b*c);
		}else if(a<5 || b<5 || c<5) { //si alguno de los 3 números es menor que 5
			s = s + String.format("(%s)", a+b+c);
		}else if(esPar(a) && esPar(b) && esPar(c)) { //si los 3 números a la vez son pares
			//llamada recursiva con la acumulación de la cadena dentro
			s = recursivoFinal(a/2, b-2, c/2, s+String.format("%s", a*b*c));
		}else {
			//llamada recursiva con la acumulación de la cadena dentro
			s = recursivoFinal(a/3, b-3, c/3, s+String.format("%s", a+b+c));
		}
		return s;
	}
	
	
	
	/*
	 * ITERATIVO:
	 */
	
	public static String iterativo(Integer a, Integer b, Integer c) {
		
		String s = new String(); //cadena vacía
		
		/*
		 * Mientras se cumpla 'a>=5 & b>=5 & c>=5' no se cumplirán:
		 * 	-> 'a<3 && b<3 && c<3': porque los números son mayores que tres.
		 * 	-> 'a<5 || b<5 || c<5': porque los números son mayores o iguales a 5.
		 */
		
		while(a>=5 & b>=5 & c>=5) {
			if(esPar(a) && esPar(b) && esPar(c)) {
				s += String.format("%s", a*b*c);
				a = a/2;
				b = b-2;
				c = c/2;
			}else {
				s += String.format("%s", a+b+c);
				a = a/3;
				b = b-3;
				c = c/3;
			}
		}
		
		if(a<3 && b<3 && c<3) {
			s = s + String.format("(%s)", a*b*c);
		}else if(a<5 || b<5 || c<5) {
			s = s + String.format("(%s)", a+b+c);
		}
		
		return s;
	}
	
	
	
	/*
	 * FUNCIONAL
	 */
	
	public static String funcional(Integer a, Integer b, Integer c) {
		String s = new String();
		Tupla t = Tupla.of(a, b, c, s);
		return Stream
				.iterate(t, x -> Tupla.next(x))
				.filter(x -> (x.a()<3 && x.b()<3 && x.c()<3) || (x.a()<5 || x.b()<5 || x.c()<5))
				.findFirst()
				.map(x -> x.s())
				.get();
	}
	
	public static record Tupla(Integer a, Integer b, Integer c, String s) {
		
		public static Tupla of(Integer a, Integer b, Integer c, String s) {
			return new Tupla(a, b, c, s);
		}
		
		public static Tupla next(Tupla t) {
			
			String x = t.s;
			Tupla r = Tupla.of(null, null, null, x);
			
			if(t.a<3 && t.b<3 && t.c<3) {
				r = Tupla.of(t.a-1, t.b-1, t.c-1, x+String.format("(%s)", t.a*t.b*t.c));
			}else if(t.a<5 || t.b<5 || t.c<5) {
				r = Tupla.of(t.a-1, t.b-1, t.c-1, x+String.format("(%s)", t.a+t.b+t.c));
			}else if(esPar(t.a) && esPar(t.b) && esPar(t.c)) {
				r = Tupla.of(t.a/2, t.b-2, t.c/2, x+String.format("%s", t.a*t.b*t.c));
			}else {
				r = Tupla.of(t.a/3, t.b-3, t.c/3, x+String.format("%s",t.a+t.b+t.c));
			}
			return r;
		}
	}

}