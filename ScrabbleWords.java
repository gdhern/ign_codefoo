package codeFoo6.ign.www;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleWords {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		boolean valid = false;
		char[] myTiles = null;
		String chosenLetters = null;
		
		while(valid == false){
			System.out.println("Enter your letters (ex. kicquojsl) or -1 to exit: ");
			chosenLetters = kb.nextLine().toUpperCase();
			if(chosenLetters.equalsIgnoreCase("-1"))
				System.exit(0);
			myTiles = chosenLetters.toCharArray();
			valid = isItValid(myTiles);
		}
		
		kb.close();
		
		//Count the number of each character in the word
		int[] myTileCount = count(myTiles);
		
		ArrayList<String> possibleWords = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		//Go through the list of words to find which words can be generated
		try {
			//Read the words off the file and determine if they are possible options for
			//the currently available letters
			FileReader fr = new FileReader("ScrabWords.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()){
				
				String word = br.readLine().toUpperCase();
				char[] nextWord = word.toCharArray();
				
				if(chosenLetters.length() >= word.length()){
					int[] nextWordCount = count(nextWord);
				
				//If the retrieved word is a possible option, it is saved to an ArrayList
					if(compare(myTileCount,nextWordCount)){
						possibleWords.add(word);
						for(int i = 0; i < 26; i++)
							values.add(nextWordCount[i]);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(possibleWords.isEmpty() == false){
			int[] valuesOfWords = new int[possibleWords.size()];
		
			for(int i = 0; i < possibleWords.size(); i++){
				int[] characterNumber = new int[26];
			
				for(int j = 0; j < 26; j++)
					characterNumber[j] = values.remove(0);
			
				valuesOfWords[i] = wordValue(characterNumber);
			}
			int max = 0, location = 0;
		
			for(int i =0; i < possibleWords.size(); i++)
				if(valuesOfWords[i] > max){
					max = valuesOfWords[i];
					location = i;
				}
		
			System.out.println(possibleWords.get(location) + " " +  max);
		}
		else
			System.out.println("No words can be generated");
	}
	
	/**
	 * Counts the number of each letter in a character array and returns an
	 * int array with that information.
	 * @param word A character array 
	 * @return An integer array that holds the number of each character in
	 * the word character array
	 */
	private static int[] count(char[] word){
		
		char[] alphabetLetters = {'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] letter_Count = new int[26];
		
		for(int i = 0; i < word.length; i++)
			for(int j = 0; j < 26;j++)
				if(word[i] == alphabetLetters[j])
					letter_Count[j]++;
		return letter_Count;
	}
	

	/**
	 * Takes two integer arrays that contain the number of each character in the
	 * user's input and a valid word. Compares both arrays, checking if the valid 
	 * word can be created using the user's available letters.
	 * @param originalWord number of each character entered
	 * @param nextWord number of each character in a valid word 
	 * @return True if the word taken from the list can be made using the characters
	 * entered by the user; False otherwise.
	 */
	private static boolean compare(int[] originalWord, int[] nextWord){
		for(int i = 0; i < 26; i++)
			if(nextWord[i]>originalWord[i])
				return false;
		
		return true;
	}

	/**
	 * Sums the value of a valid word based on the number of each character
	 * and the value of those characters.
	 * @param wordArray integer array holding the number of each character in a word.
	 * @return An integer representing the total value of a word.
	 */
	private static int wordValue(int[] wordArray){
		int total = 0;
		
		for(int i = 0; i < 26; i++){
			if(i == 0 || i == 4 || i == 8 || i == 11 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20)
				total = total + wordArray[i];
			else if(i == 3 || i == 6)
				total = total + 2*wordArray[i];
			else if(i == 1 || i == 2 || i == 12 || i == 15)
				total = total + 3*wordArray[i];
			else if(i == 5 || i == 7 || i == 21 || i == 22 || i == 24)
				total = total + 4*wordArray[i];
			else if(i == 10)
				total = total + 5*wordArray[i];
			else if(i == 9 || i == 23)
				total = total + 8*wordArray[i];
			else if(i == 16 || i == 25)
				total = total + 10*wordArray[i];
		}
		
		return total;
	}
	
	/**
	 * Verify that the user's input only consists of alphabetical characters
	 * @param letters Character array made up of the user's input
	 * @return True only if valid characters have been entered.<br>
	 * False if any invalid characters are present.
	 */
	private static boolean isItValid(char[] letters){
		for(int i = 0; i < letters.length; i++){
			if(letters[i] < 'A' || letters[i] > 'Z'){
				System.out.println("Invalid characters have been entered. Please try again.");
				return false;
			}
		}
		return true;
	}
}


