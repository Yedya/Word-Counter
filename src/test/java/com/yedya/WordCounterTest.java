package com.yedya;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for Word Counter App.
 */
public class WordCounterTest{

	// Tests to check how string is split in words

	/**
	*  Test ID: 05
	*  Description : Pass a string with 2 words in it, into our countWordsInLine function
	*/
	@Test
	public void CountWordsSimpleTest() throws Exception {
		String input = "Hello World";
		assertEquals(2, WordCounter.countWordsInLine(input));
	}

	/**
	*  Test ID: 06
	*  Description : Pass an empty string into our countWordsInLine function
	*/
	@Test
	public void CountWordsEmpty() throws Exception {
		String input = "";
		assertEquals(0, WordCounter.countWordsInLine(input));
	}

	/**
	*  Test ID: 07
	*  Description : Pass a string with spaces into our countWordsInLine function
	*/
	@Test
	public void CountWordsManySpacesAndTabs() throws Exception { //
		String input = "         Hello       World           ";
		assertEquals(2, WordCounter.countWordsInLine(input));
	}

	/**
	*  Test ID: 08
	*  Description : Pass a string with 1 English word and 1 Russian word into our countWordsInLine function
	*/
	@Test
	public void CountWordsTwoLanguages() throws Exception {
		String input = "Hello Мир";
		assertEquals(2, WordCounter.countWordsInLine(input));
	}

	// Tests to check word counting functionality on example files


	/**
	*  Test ID: 09
	*  Description : Pass an empty txt file into our WordCounter constructor and count the words
	*/
	@Test
	public void File_empty() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("empty.txt"));
		wc.countWords();

		assertEquals(0, wc.getCount());
	}

	/**
	*  Test ID: 10
	*  Description : Pass a txt file with 5 words, into our WordCounter constructor and count the words
	*/
	@Test
	public void File_file_Test() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("file_Test.txt"));
		wc.countWords();

		assertEquals(5, wc.getCount());
	}

	/**
	*  Test ID: 11
	*  Description : Pass a txt file with 12 words and multiple lines, into our WordCounter constructor and count the words
	*/
	@Test
	public void File_multiline() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("multiline.txt"));
		wc.countWords();

		assertEquals(12, wc.getCount());
	}

	/**
	*  Test ID: 12
	*  Description : Pass a txt file ,only containing numerics, into our WordCounter constructor and count the words. We don't count numerics so it will return 0
	*/
	@Test
	public void File_Numerics() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("Numerics.txt"));
		wc.countWords();

		assertEquals(0, wc.getCount());
	}

	/**
	*  Test ID: 13
	*  Description : Pass a txt file ,only containing punctuation characters, into our WordCounter constructor and count the words. We don't count punctuation characters on their own so it will return 0
	*/
	@Test
	public void File_punctuationOnly() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("punctuationOnly.txt"));
		wc.countWords();

		assertEquals(0, wc.getCount());
	}

	/**
	*  Test ID: 14
	*  Description : Pass a txt file , containing words with punctuation , into our WordCounter constructor and count the words.
	*/
	@Test
	public void File_punctuationWords() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("punctuationWords.txt"));
		wc.countWords();

		assertEquals(10, wc.getCount());
	}

	/**
	*  Test ID: 15
	*  Description : Pass a txt file , containing  seven words , into our WordCounter constructor and count the words.
	*/
	@Test
	public void File_Seven_Words() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("Seven_Words.txt"));
		wc.countWords();

		assertEquals(7, wc.getCount());
	}

	/**
	*  Test ID: 16
	*  Description : Pass a txt file , containing two words , into our WordCounter constructor and count the words.
	*/
	@Test
	public void File_simple() throws Exception {

		WordCounter wc = new WordCounter(TestSuite.GetTestFilePath("simple.txt"));
		wc.countWords();

		assertEquals(2, wc.getCount());
	}


}