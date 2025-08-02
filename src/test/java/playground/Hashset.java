package playground;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Hashset {
	public static String getOut(int numberOfMatches, String squads, int squad1, int squad2) {
		List<Set<String>> setOfplayers = new ArrayList<Set<String>>();
		String finalRes = "";
		String[] teamPlayed = squads.split("#");
		for (int game = 0; game < teamPlayed.length; game++) {
			Set<String> uniquePlayersOfGame = new HashSet<String>();
			for (String players : teamPlayed[game].split(" ")) {
				uniquePlayersOfGame.add(players);
			}
			setOfplayers.add(uniquePlayersOfGame);
		}
		List<String> res = findCommonStrings(setOfplayers);
		for (String player : res) {
			finalRes = finalRes + player + " ";
		}
		finalRes = finalRes.substring(0, finalRes.length() - 1);
		finalRes = finalRes + ",";

		List<String> res2 = findStringsAtXButNotInY(setOfplayers, squad1 - 1, squad2 - 1);
		for (String p : res2) {
			finalRes = finalRes + p + " ";
		}
		finalRes = finalRes.substring(0, finalRes.length() - 1);

		return finalRes;
	}

	public static List<String> findCommonStrings(List<Set<String>> listOfSets) {
		if (listOfSets == null || listOfSets.isEmpty()) {
			return Collections.emptyList();
		}

		Set<String> commonStrings = new HashSet<>(listOfSets.get(0)); // Initialize with the first set

		for (Set<String> set : listOfSets) {
			commonStrings.retainAll(set); // Keep only the common elements
		}

		return new ArrayList<>(commonStrings); // Convert to list for return
	}

	public static List<String> findStringsAtXButNotInY(List<Set<String>> listOfSets, int squad1, int squad2) {
		if (listOfSets == null || listOfSets.size() < 2) {
			return Collections.emptyList();
		}

		Set<String> set1 = listOfSets.get(squad1);
		Set<String> set2 = listOfSets.get(squad2);

		List<String> result = new ArrayList<>();
		for (String str : set2) {
			if (!set1.contains(str)) {
				result.add(str);
			}
		}

		return result;
	}

	public static void testGetOut1() throws IOException {
		String output = Hashset.getOut(4,
				"Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi Paciencia Jota Daniel Patrício Ronaldo Eder Andre Bruma Ricardo Domingos#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira Rafa Renato Ferro Bruma Goncalo Joao Dyego Jose Nelson Pepe Mario Pereira#Ronaldo Eder Andre Bruma Goncalo Jota Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato Ferro Daniel Patrício Nelson Pepe Mario Pereira Rafa Renato#Ronaldo Eder Andre Bruma Goncalo Joao Dyego Jose Ricardo Domingos Semedo Bernardo Pereira Bruno Pizzi",
				1, 4);
		String[] stringArray = output.split(", ");
		System.out.println(stringArray[1]);
		// String actual = sortItOut(stringArray[0])+sortItOut(stringArray[1]);
	}
	
	public static void main(String[] args) throws IOException {
		testGetOut1();
	}

}
