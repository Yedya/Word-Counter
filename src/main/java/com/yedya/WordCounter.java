package com.yedya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Simple word counter that counts the number of words in a file
 * @author Conor 
 * 
 */
public class WordCounter {
	private String fileName;
	private int count;
	
	/**
	 * WordCounter constructor
	 * @param fileName the file to count words in
	 */
	public WordCounter(String fileName) {
		this.fileName = fileName;
		this.count = -1;
	}
	
	/**
	 * This function checks if a string is a valid word  
	 * @param word string to check
	 * @return boolean, if a string is a valid
	 */
	static boolean isValidWord(String word) {
		// drop trailing and preceding punctuation ( Hello! => Hello )
		// this is done by replacing one of !@#$%^&*,./?;:"() from beginning or end of the string
		// ?I'm! -> I'm 
		word = word.replaceAll("^[!@#'$%^&*,./?;:\"]+|[!@#'$%^&*,./?;:\"]+$", "");
		

		// prevent double dash or ' inside the word
		if(word.contains("--") || word.contains("''") ) {
			return false;
		}

		// valid word consists with one or more Unicode characters, - and '
		return word.matches("[\\p{L}'-]+");
	}

	/**
	 * This function counts the number of valid words per line
	 * @param line the file to count words in
	 * @return the number of words
	 */
	static int countWordsInLine(String line) {
		int words = 0;	     
		
		for(String word :line.split("\\s+")) { // split string with space-like breaks
			if (isValidWord(word)) {
				words++;
			}
		}

		return words;
	}

	/**
	 * This function counts the number of valid words
	 * 
	 */
	public void countWords() {
		if(fileName == null) {
			// early return if file name is not set
			count = -1;
			System.err.println("File name is not set!");
			return;
		}

		count = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName)); //Reads text from a character-input stream

			String line = br.readLine(); // For reading the file , line by line
			while (line != null) {            
				// increase counter by number of words in this line
				count += countWordsInLine(line);

				line = br.readLine();
			}
			br.close(); //Close the text file
		}
		catch(IOException e)
		{
			count = -1;
			System.err.println("Error had occurred when counting words: " + e.getLocalizedMessage());
		}
	}
	
	/**
	 * This function returns the number of words in the file
	 * @return the number of words in the text file
	 */
	public int getCount() {
		return count;
	}
}
