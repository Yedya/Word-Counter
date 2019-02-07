package com.yedya;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for Word Counter App.
 */
public class AppTest
{
	// Testing input/output
	// Reference -> http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); //Output stream
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream(); // Error/Excpetion stream

	/** 
	 *  Reassign our standard output stream and error output stream before the tests run
	 */
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent)); 
		System.setErr(new PrintStream(errContent));
	}

	/**
	 *  Clear the stream for our standard output stream and error output stream after the tests
	 */
	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
	
	/**
	*  Test ID: 01
	*  Description : Pass empty params into our WordCounter constructor
	*/
	@Test
	public void NoParameter() 
	{
		App.main(new String[]{});
		String out = outContent.toString();
		String err = errContent.toString();

		assertTrue("Output is empty", out.isEmpty());
		assertFalse("Err is not empty", err.isEmpty());
	}

	/**
	*  Test ID: 02
	*  Description : Pass an invalid file  into our WordCounter constructor
	*/
	@Test
	public void InvalidFile()
	{
		App.main(new String[]{"Invalid file name.txt"});
		String out = outContent.toString();
		String err = errContent.toString();

		assertTrue("Output is empty", out.isEmpty());
		assertFalse("Err is not empty", err.isEmpty());
	}

	/**
	*  Test ID: 03
	*  Description : Pass a file with zero words in it, into our WordCounter constructor
	*/
	@Test
	public void EmptyFile()
	{
		App.main(new String[]{TestSuite.GetTestFilePath("empty.txt")});
		String out = outContent.toString();
		String err = errContent.toString();

		assertEquals("Output is 0", out.trim(), "0");
		assertTrue("No error", err.isEmpty());
	}

	/**
	*  Test ID: 04
	*  Description : Pass a file with 2 words in it, into our WordCounter constructor
	*/
	@Test
	public void SimpleCase()
	{
		App.main(new String[]{TestSuite.GetTestFilePath("simple.txt")});
		String out = outContent.toString();
		String err = errContent.toString();

		assertEquals("Output is 2", out.trim(), "2");
		assertTrue("No error", err.isEmpty());
	}

}
