package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws Exception {
		String ligne = "";
		char firstDigit = 0;
		char lastDigit = 0;
		String concatDigit;
		int valeur = 0;
		int valeurTotale = 0;

		Map<String, String> traducteur = new HashMap<>();
		traducteur.put("one", "1");
		traducteur.put("two", "2");
		traducteur.put("three", "3");
		traducteur.put("four", "4");
		traducteur.put("five", "5");
		traducteur.put("six", "6");
		traducteur.put("seven", "7");
		traducteur.put("eight", "8");
		traducteur.put("nine", "9");

		BufferedReader br = new BufferedReader( // création buffered Reader pour lire le fichier
				new FileReader("D:\\Programmes Pro\\ECLIPSE\\Travaux\\Ressources AdventOfCode\\InputDay1.txt")); // chemin
		while ((ligne = br.readLine()) != null) {

			System.out.println(ligne); // Affichage de la ligne avant traduction

			for (Map.Entry<String, String> entry : traducteur.entrySet()) {
				ligne = ligne.replace(entry.getKey(), (entry.getValue()));
			}
			System.out.println(ligne);

			for (char c : ligne.toCharArray()) {
				// if

				if (Character.isDigit(c)) {
					firstDigit = c;
					break;
				}
			}

			for (int index = ligne.length() - 1; index >= 0; index--) {
				char c = ligne.charAt(index);
				if (Character.isDigit(c)) {
					lastDigit = c;
					break;
				}
			}
			concatDigit = firstDigit + "" + lastDigit;
			valeur = Integer.parseInt(concatDigit);
			valeurTotale += valeur;
			System.out.println(valeur);
			System.out.println(valeurTotale);
		}

	}
}
