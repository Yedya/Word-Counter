package com.yedya;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.File;


@RunWith(Suite.class)
@SuiteClasses({AppTest.class,WordCounterTest.class, ValidWordsTest.class})
public class TestSuite {
	// Helper function to transform to add root directory for test case files
	static String GetTestFilePath(String fileName) {
		File withTestDir = new File("test_files", fileName);
		return withTestDir.toString();
	}
}
