package com.test.runner;

import com.Google.threadclasses.GoogleFeatureThread;

public class GoogleTestRunner {

	public static void main(String[] args) {

		Thread t1 = new GoogleFeatureThread("chrome thread", "chrome");
		Thread t2 = new GoogleFeatureThread("firefox thread", "firefox");

		System.out.println("thread started.....");

		t1.start();
		t2.start();

		
		//This below code is excecute in command line using maven 
		
		// We have to run our code in Command Prompt using maven Build:
		// --> mvn compile => Press Enter
		// --> mvn exec:java -Dexec.mainClass="com.GoogleTestRunner.GoogleTestRunner" -Dchrome=2 -Dfirefox=2 => Press Enter
		
		int chromeCount = Integer.parseInt(System.getProperty("chrome"));
		int firefoxCount = Integer.parseInt(System.getProperty("firefox"));

		for (int i = 0, j = 0; i < chromeCount || j < firefoxCount; i++, j++) {
			System.out.println("threads starded.....");

			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();

			System.out.println("thread got ended....");
		}

	}

	
	// Jenkins For Normal freeStyle project we can use In Goals and Options:
	// C:\Users\Prakash\eclipse-workspace\SeleniumWebDriver_With_MultiThreading\pom.xml
	// --> mvn exec:java -Dexec.mainClass="com.test.runner.GoogleTestRunner" -Dchrome=2 -Dfirefox=2

	// In jenkins Parameterized Build In Goals and Options: Don't use 'mvn' for above command
	// Active choices plug-in want to Download in manage plugins in jenkins.
	// C:\Users\Prakash\eclipse-workspace\SeleniumWebDriver_With_MultiThreading\pom.xml
	// --> exec:java -Dexec.mainClass="com.GoogleTestRunner.GoogleTestRunner" -Dchrome=$(chrome) -Dfirefox=$(firefox)

}