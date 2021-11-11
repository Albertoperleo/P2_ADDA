package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		System.out.println(llamadaRSM(18));
		System.out.println(llamadaRM(18));
		
		
	}
	
	//ITERATIVO:
	public static Long iterativo(Integer n) {
		Map<Integer, Long> m = new HashMap<Integer, Long>();
		//Casos base
		m.put(2, 6L);
		m.put(1, 4L);
		m.put(0, 2L);
		//n desde el que partiremos siempre
		Integer f = 3;
		Long res = 0L;
		
		while(f <= n) {
			res = 2*m.get(f-1) + 4*m.get(f-2) + 6*m.get(f-3) + 0L;
			m.put(f, res);
			f++;
		}
		return res;	
	}
	
	
	//RECURSIVO SIN MEMORIA:
	public static Long llamadaRSM(Integer n) {
		Long f2 = 6L;
		Long f1 = 4L;
		Long f0 = 2L;
		Integer inicio = 3;
		
		return rsm(n, f2, f1, f0, inicio, 0L);
	}
	
	public static Long rsm(Integer nf, Long f2, Long f1, Long f0, Integer ni, Long res) {
		
		if(ni<=nf) {
			res = 2*f2 + 4*f1 + 6*f0 + 0L; 
			res = rsm(nf, res, f2, f1, ni+1, res);
		}
		
		return res;
	}
	
	
	//RECURSIVO CON MEMORIA:
	public static Long llamadaRM(Integer n) {
		Map<Integer, Long> m = new HashMap<Integer, Long>();
		m.put(2, 6L);
		m.put(1, 4L);
		m.put(0, 2L);
		Integer inicio = 3;
		
		return rm(n, 2, 1, 0, inicio, 0L, m);
	}
	
	public static Long rm(Integer nf, Integer f2, Integer f1, Integer f0, Integer ni, Long res, Map<Integer, Long> m) {
		
		if(ni<=nf) {
			res = 2*m.get(f2) + 4*m.get(f1) + 6*m.get(f0) + 0L;
			if(!m.containsKey(ni)) {
				m.put(ni, res);
			}
			res = rm(nf, f2+1, f2, f1, ni+1, res, m);
		}
		return res;
	}	
	
}
