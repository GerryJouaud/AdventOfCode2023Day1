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

		Map<String, String> traducteur = new HashMap<>(); // Création d'une map pour remplacer les nombres en caractères
															// digitaux ! On entoure le caractère digital par sa forme
															// écrite dans le cas ou deux nombres se chevauchent;
															// exemple : gqoneightsevensix94five =
															// gqone1oneight8eightseven7sevensix6six94five5five !

		traducteur.put("one", "one1one");
		traducteur.put("two", "two2two");
		traducteur.put("three", "three3three");
		traducteur.put("four", "four4four");
		traducteur.put("five", "five5five");
		traducteur.put("six", "six6six");
		traducteur.put("seven", "seven7seven");
		traducteur.put("eight", "eight8eight");
		traducteur.put("nine", "nine9nine");

		BufferedReader br = new BufferedReader( // création buffered Reader pour lire le fichier
				new FileReader("D:\\Programmes Pro\\ECLIPSE\\Travaux\\Ressources AdventOfCode\\InputDay1.txt")); // chemin
		while ((ligne = br.readLine()) != null) {

			System.out.println(ligne); // Affichage de la ligne avant traduction

			for (Map.Entry<String, String> entry : traducteur.entrySet()) { // On remplace chaque occurence de Key par
																			// sa Value
				ligne = ligne.replace(entry.getKey(), (entry.getValue()));
			}
			System.out.println(ligne);

			for (char c : ligne.toCharArray()) { // On parcourt chaque caractère de gauche à droite
				// if

				if (Character.isDigit(c)) { // Le premier caractère digital est assigné à la variable First Digit
					firstDigit = c;
					break; // On a trouvé notre First digit, on break
				}
			}

			for (int index = ligne.length() - 1; index >= 0; index--) { // même opération mais en parcourant chaque
																		// ligne de droite à gauche, on décrément à
																		// chaque boucle l'index de 1
				char c = ligne.charAt(index);
				if (Character.isDigit(c)) { // Le premier caractère digital est assigné à la variable Last Digit
					lastDigit = c;
					break; // On a trouvé notre Last digit, on break
				}
			}
			concatDigit = firstDigit + "" + lastDigit; // On concat les deux string
			valeur = Integer.parseInt(concatDigit); // On les convertit en int et on l'assigne à Valeur
			valeurTotale += valeur; // On incrémente ValeurTotale de chaque nouvelle valeur
			System.out.println(valeur);
			System.out.println(valeurTotale);
		}

	}
}
