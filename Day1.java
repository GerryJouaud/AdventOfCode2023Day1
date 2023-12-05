/*
 * L'idée à travers ce programme est de répondre au problème posé dans le Advent of Code Day 1 (https://adventofcode.com/2023/day/1).
 * Pour le résoudre, j'ai d'abord scanné le fichier dans lequel j'ai inserré tous les inputs.
 */

package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fichierLutins = "D:\\Programmes Pro\\ECLIPSE\\Travaux\\Ressources AdventOfCode\\InputDay1.txt"; // chemin
																												// du
																												// fichier
		File donneesLutins = new File(fichierLutins); // instance de la classe File

		List<String> listeDonnees = new ArrayList<>();

		try {

			Scanner analyseDonnees = new Scanner(donneesLutins); // création d'une instance de scanner pour lire le
																	// fichier
			while (analyseDonnees.hasNextLine()) {
				String ligne = analyseDonnees.nextLine(); // chaque ligne est parcourue

				Pattern regexChiffres = Pattern.compile("\\D*(\\d+)\\D*"); // regx qui recherche un ou plusieurs
																			// chiffres
				Matcher triChiffres = regexChiffres.matcher(ligne); // Applique cette regx à chaque ligne

				StringBuilder concatenatedNumbers = new StringBuilder(); // Utiliser StringBuilder pour concaténer les
																			// chiffres

				while (triChiffres.find()) {
					String chiffre = triChiffres.group(1); // Utiliser le groupe 1 pour obtenir le chiffre capturé
					concatenatedNumbers.append(chiffre);
				}

				// Ajouter le résultat (nombre concaténé) à la liste
				listeDonnees.add(concatenatedNumbers.toString());
			}

			analyseDonnees.close(); // on ferme le ficher

			List<Integer> listeDonneesFinale = new ArrayList<>();
			for (String element : listeDonnees) {
				if (element.length() >= 2) { // On trie les elements qui contiennent + de 2 chiffres
					String premierChiffre = element.substring(0, 1);
					String dernierChiffre = element.substring(element.length() - 1);
					String donneeFinale = premierChiffre + dernierChiffre;

					listeDonneesFinale.add(Integer.parseInt(donneeFinale)); // et on convertit en INT
				} else {
					listeDonneesFinale.add(Integer.parseInt(element)); // et on convertit en INT
				}
			}

			int totalDonnees = 0;
			for (int element : listeDonneesFinale) {
				if (element < 10) {
					totalDonnees += element * 11; // Ainsi, si l'élement fait 9, renvoie 99
				} else {
					totalDonnees += element;
				}
			}

			System.out.println(totalDonnees);

		} catch (

		FileNotFoundException e) { // On gère l'exception si le fichier n'est pas trouvé
			System.err.println("Erreur:" + e.getMessage());

		}

	}
}
