package com.Google.threadclasses;

import com.Pages.GooglePage;

public class GoogleFeatureThread extends Thread {

	public String browserName;
	GooglePage googlePage;

	public GoogleFeatureThread(String threadName, String browerName) {
		super(threadName);
		this.browserName = browerName;
		googlePage = new GooglePage();
	}

	@Override
	public void run() {

		System.out.println("thread -- started " + Thread.currentThread().getName());
		System.out.println("thread -- started -- Id : " + Thread.currentThread().getId());

		try {
			Thread.sleep(1000);
			googlePage.setUp(this.browserName);
			googlePage.googleSearchTest();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			googlePage.tearDown();
		}

		System.out.println("thread -- ended " + Thread.currentThread().getName());

	}

}