package whitespace;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Stack;

public class whitespace {

	static ArrayList<Integer> li = new ArrayList<Integer>();
	static ArrayList<Integer> temp = new ArrayList<Integer>();
	static Stack<Character> as = new Stack<Character>();
	static int l = -1;

	private static void evaluar() {
		// TODO Auto-generated method stub
		int asc = 0;
		int i = 0;
		while (!li.isEmpty()) {
			int f = li.get(0);
			if (f == 32) {
				while (li.get(0) != 10) {
					temp.add(li.remove(0));
				}
				li.remove(0);
				if (temp.get(1) == 32) {
					temp.remove(0);
					temp.remove(1);
				}
				as.push(ascii());
				l++;
				temp.clear();
			} else if (f == 9) {
				int j = 0;
				while (j <= 4) {
					temp.add(li.remove(0));
					j++;
				}
				tabulador();
				temp.clear();
			}
			i++;
		}

	}

	private static void tabulador() {
		// TODO Auto-generated method stub
		for (int i = 0; i < temp.size() - 1; i++) {
			if (temp.get(i) == 32 && temp.get(i + 1) == 32) {
				if (l != -1) {
					System.out.print(as.get(l).toString());
				}
			}
		}
	}

	private static Character ascii() {
		// TODO Auto-generated method stub
		int asc = 0;
		for (int i = 0; i < temp.size() - 1; i++) {
			if (temp.get(0) == 32) {
				if (temp.get(i) == 32) {
					asc = asc * 2;
				} else if ((temp.get(i)) == 9) {
					asc = (asc * 2) + 1;
				}
			} else {
				if (temp.get(i) == 32) {
					asc = asc * 2;
				} else if (temp.get(i) == 9) {
					asc = (asc * (2)) - 1;
				}
			}
		}
		if (asc == 1) {
			return (char) 49;
		} else {
			return (char) asc;
		}
	}

	public static void leer() {
		try {
			FileInputStream ficheroEntrada2 = new FileInputStream(new File(
					"fichero.bin"));
			int dato;
			while ((dato = ficheroEntrada2.read()) != -1) {
				li.add(dato);
			}
			ficheroEntrada2.close();
		} catch (Exception errorDeFichero) {
			System.out.println("Ha habido problemas: "
					+ errorDeFichero.getMessage());
		}
	}

	public static void main(String[] args) {
		leer();
		evaluar();
	}
}
