package com.yedya;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Testing the functionality of the isValidWord() function
 */
public class ValidWordsTest {
	
	/**
	*  Test ID: 17
	*  Description : Check the validity of the words within the words Array by passing them into the isValidWord function
	*  In this case, they will all be good(Valid) words.
	*/
	@Test
	public void SimpleGoodWords() {
		String[] words = new String[] {
				"hello"
				,"русский"
				,"官话"
		};

		for(String word : words) {
			assertTrue("Good Word: '" + word + "'", WordCounter.isValidWord(word));
		}
	}

	/**
	*  Test ID: 18
	*  Description : Check the validity of the words within the words Array by passing them into the isValidWord function
	*  In this case, they will all be bad(invalid) words.
	*/
	@Test
	public void SimpleBadWords() {
		String[] words = new String[] {
				"no8go" // digit inside
				,"no?go" // punctuation inside
				,"" // empty word
				,"123" // a number
				,"℃" // unicode symbol
		};

		for(String word : words) {
			assertFalse("Bad Word: '" + word + "'", WordCounter.isValidWord(word));
		}
	}

	/**
	*  Test ID: 19
	*  Description : Check the validity of the words with possessives and contractions by passing them into the isValidWord function
	*  In this case, they will all be valid words.
	*/
	@Test
	public void ContractionsAndPossessives() {
		String[] words = new String[] {
				"Conor's" // possessive
				,"it's" // contraction
				,"Anna-Maria" // dashed name
		};

		for(String word : words) {
			assertTrue("Word: '" + word + "'", WordCounter.isValidWord(word));
		}
	}

	/**
	*  Test ID: 20
	*  Description : Check the validity of the words with valid punctuation by passing them into the isValidWord function
	*  In this case, they will all be valid words.
	*/
	@Test
	public void ValidPunctuation() {
		String[] words = new String[] {
				"hey?!" // possessive
				,"\"Hello" // contraction
		};

		for(String word : words) {
			assertTrue("Word: '" + word + "'", WordCounter.isValidWord(word));
		}
	}
	
	/**
	*  Test ID: 21
	*  Description : Check the validity of the words with invalid punctuation by passing them into the isValidWord function
	*  In this case, they will all be invalid words.
	*/
	@Test
	public void InvalidPunctuation() {
		String[] words = new String[] {
				"?!" // possessive
				,"Anna--Maria" // contraction
		};

		for(String word : words) {
			assertFalse("Bad Word: '" + word + "'", WordCounter.isValidWord(word));
		}
	}
	
}
