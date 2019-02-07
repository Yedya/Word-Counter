package com.yedya;

/**
 * Driver program , running from cmd 
 *
 * @author Conor Hynes
 * 
 */
public class App 
{
	public static void main( String[] args )
	{
		if (args.length >= 1) {
			WordCounter w = new WordCounter(args[0]);
			w.countWords();
			int result = w.getCount();
			if (result>=0) {
				System.out.println(result);
			}
		} else {
			System.err.println("Pass file to count words in as a parameter.");
		}
	}
}