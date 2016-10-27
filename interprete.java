package whitespace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class interprete {
	/*String[] stack = { "ss", "ses", "set", "see" };
	String[] arit = { "tsss", "tsst", "tsse", "tsts", "tstt" };
	String[] heap = { "tts", "ttt" };
	String[] flow = { "ess", "est", "ese", "ets", "ett", "ete", "eee" };
	String[] io = { "tess", "test", "tets", "tett" };*/
	static ArrayList<String> linea = new ArrayList<String>();
	static Stack<String> temp = new Stack<String>();
	static Stack<Character> as = new Stack<Character>();

	public static void interpretar(String cadena) {
		linea(cadena);
	}

	//Para toar cada línea y enviar al comando con el cual comienza
	private static void linea(String cadena) {
		String c = null;
		int l = 0;
		int n=0;
		for (int i = 0; i < cadena.length(); i++) {
			l=0;
			if (cadena.startsWith("ss")) {
				while (cadena.charAt(l) != 'e') {
					l++;
				}
				c = cadena.substring(i, (l + 1));
				linea.add(c);
				pushNum(cadena);
				n+=1;
				cadena=cadena.substring(l+1, cadena.length());
				i=0;
			} else if(cadena.startsWith("tess")) {
				if(n!=0) {
					System.out.print(as.get(n-1).toString());
				}
				cadena=cadena.substring(3,cadena.length());
				// llamar switch demás comandos
				i=0;
			}
			//i=0;
			l++;
			//cadena=cadena.substring(l, cadena.length());
			
		}
	}
	
	private static void pushNum(String cadena) {
		while (!linea.isEmpty()) {
			String m = linea.get(0).substring(1, linea.get(0).length());
			as.push(ascii(m));
			linea.remove(0);
		}
	}

	private static Character ascii(String temp) {
		// TODO Auto-generated method stub
		int asc = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.startsWith("s")) {
				if ((temp.charAt(i)) == 's') {
					asc = asc * 2;
				} else if ((temp.charAt(i)) == 't') {
					asc = (asc * 2) + 1;
				}
			} else if (i != 0) {
				if ((temp.charAt(i)) == 's') {
					asc = asc * 2;
				} else if ((temp.charAt(i)) == 't') {
					asc = (asc * (2)) - 1;
				}
			}
		}
		return (char) asc;
	}

	public static void main(String[] args) {

		/*Scanner sc = new Scanner(System.in);
		String b = sc.nextLine();
		interpretar(b);*/
		interpretar("sssttttstsetessssstttststetesssssttsttssetesssssttsststetesssssttstsstetesssssttsttstetesssssttstsstetesssssssstsssssetesssssttsststetessssstttssttetessssstttstssetesssssttsststetesssssttssttsetesssssttssttsetesssssttsssstetesssssttstttsetesssssttstttsetesssssttttsstetessssstsssssetesssssttsstttetesssssttsttttetesssssttstttsetesssssttttstsetesssssttsssstetesssssttsttssetesssssttsststetesssssttttstsetessssstsssssetesssssttsttstetessssstttststetesssssttstttsetesssssttstsstetesssssttsttttetesssssttttstsetess");
		//Mi nombre : sssttttstsetessssstttststetesssssttsttssetesssssttsststetesssssttstsstetesssssttsttstetesssssttstsstetesssssssstsssssetesssssttsststetessssstttssttetessssstttstssetesssssttsststetesssssttssttsetesssssttssttsetesssssttsssstetesssssttstttsetesssssttstttsetesssssttttsstetessssstsssssetesssssttsstttetesssssttsttttetesssssttstttsetesssssttttstsetesssssttsssstetesssssttsttssetesssssttsststetesssssttttstsetessssstsssssetesssssttsttstetessssstttststetesssssttstttsetesssssttstsstetesssssttsttttetesssssttttstsetess

	}
}
