package dat102.stud.hvl.no;

import dat102.stud.hvl.no.*;

public class ParantesSjekker {

	public static boolean sjekkParanteser(String s) {
		LenketStabelParentes<Character> stabel = new LenketStabelParentes<>();

		for (char c : s.toCharArray()) {
			if (erStartParantes(c)) {
				stabel.push(c);
			} else if (erSluttParentes(c)) {
				if (stabel.isEmpty()) {
					return false;
				}
				char start = stabel.pop();
				if (!erParentesPar(start, c)) {
					return false;
				}
			}
		}
		return stabel.isEmpty();
	}

	public static boolean erStartParantes(char c) {
		return c == '(' || c == '[' || c == '{';

	}

	public static boolean erSluttParentes(char c) {
		return c == ')' || c == ']' || c == '}';
	}

	public static boolean erParentesPar(char start, char slutt) {
		return start == '(' && slutt == ')' || start == '[' && slutt == ']' || start == '{' && slutt == '}';
	}


	public static void main(String[] args) {
		String korrekt = "{ [ ( ) ] }";
		String feil1 = "{ [ ( ) }";
		String feil2 = "[ ( ) ] }";
		String feil3 = "{ [ ( ] ) }";
		String kode = """
				class HelloWorld {
				public static void main(String[] args) {
				System.out.println("Hello World!");
				}
				}
				""";

		System.out.println(sjekkParanteser(korrekt)); // true
		System.out.println(sjekkParanteser(feil1)); // false
		System.out.println(sjekkParanteser(feil2)); // false
		System.out.println(sjekkParanteser(feil3)); // false
		System.out.println(sjekkParanteser(kode)); // true
	}
}
