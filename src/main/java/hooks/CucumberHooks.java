/*
 * Copyright (c) 2003 - 2023 Inovalon Inc. All Rights Reserved.
 *
 * This computer program is CONFIDENTIAL and a TRADE SECRET of ABILITY Network Inc.
 * The receipt or possession of this program does not convey any rights to use,
 * reproduce or disclose its contents in whole or in part, without the specific
 * written consent of ABILITY Network Inc. Any use, reproduction or disclosure of
 * this program without the express written consent of ABILITY Network Inc. is a
 * violation of the copyright laws and may subject you to criminal prosecution.
 */
package hooks;

import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import driverfactory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class CucumberHooks {

	
	@BeforeAll(order = 0)
	public static void beforeAll() {
		System.out.println("BeforeAll - This cucumber hook run before any scenario is run.");
	}


	@Before(order = 0)
	public void before() throws IOException {
		try {
			WebDriverFactory.setDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Before(order = 1)
	public void before2(Scenario scenario) {
		System.out.println("******Scenario Name:" + scenario.getName() + "******");
	}

	@After(order = 0)
	public void after(Scenario scenario) {
		System.out.println("******Scenario Status:" + scenario.getStatus() + "******");
	}

	 @After(order = 1)
	public void after() throws Exception {
		try {
			WebDriverFactory.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// After hook to get failed scenario screenshot
	@After(order = 2)
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}


	@AfterAll(order = 1) // Cucumber AfterAll hook with order 1
	public static void putFile()  {
		System.out.println("******AfterAll hook execution started to send cucumber or extent report over email******");

		

	}
}