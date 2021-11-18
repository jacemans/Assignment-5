import java.io.File;
/**
 * Converts Morse code to English
 * 
 * @author Justin Hixson
 */
public class MorseCodeConverter {

	private static MorseCodeTree morseCodeTree = new MorseCodeTree();
	/**
	 * Default constructor
	 */
	public MorseCodeConverter() {
	}
	/**
	 * Returns a string with all the data in the tree in LNR order with a space in between them
	 * @return the data in the tree in LNR order separated by a space
	 */
	public static String printTree() {
		String printTree = "";

		for (String string : morseCodeTree.toArrayList()) {
			printTree += string + " ";
		}
		return printTree;
	}
	/**
	 * Converts Morse code into English
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String english = "";
		String[] word = code.split("/");
		String[][] letter = new String[word.length][];
		for (int i = 0; i < word.length; i++) {
			letter[i] = word[i].split(" ");
		}
		for (int i = 0; i < letter.length; i++) {
			for (int j = 0; j < letter[i].length; j++) {
				english += morseCodeTree.fetch(letter[i][j]);
			}
			if (i < letter.length - 1)
				english += " ";
		}

		return english;
	}
	/**
	 * Converts a file of Morse code into English
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException file not found
	 */
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException {
		java.util.Scanner scan = new java.util.Scanner(codeFile);
		String convertToEnglish = "";

		while (scan.hasNextLine()) {
			convertToEnglish += scan.nextLine();
		}
		scan.close();

		return convertToEnglish(convertToEnglish);
	}
}
