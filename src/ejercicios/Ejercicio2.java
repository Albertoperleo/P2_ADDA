package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Matrix;
import us.lsi.common.View4;

public class Ejercicio2 {
  
	public static List<String> recursivoMatrizLlamada(Matrix<String> m){
		List<String> lista = new ArrayList<String>();
		return recursivoMatriz(m, lista);
	}
	
	public static List<String> recursivoMatriz(Matrix<String> m, List<String> lista) {
		Integer pos = m.nf()-1;
		String s = m.get(0, 0) + m.get(0, pos) + m.get(pos, 0) + m.get(pos, pos);
		lista.add(s);
		if(m.nf()>2) {
			View4<Matrix<String>> subMatrix = m.views4();
			recursivoMatriz(subMatrix.a(), lista);
			recursivoMatriz(subMatrix.b(), lista);
			recursivoMatriz(subMatrix.c(), lista);
			recursivoMatriz(subMatrix.d(), lista);			
		}
		return lista;
	}
}
