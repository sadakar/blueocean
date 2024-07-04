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
package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "classpath:scenarios",

		// tags ="@SignIn or @SignOut",

		tags = "@OrderTwoItems",

		glue = { "hooks", "driverfactory", "pagefactory", "runners", "stepdefs" },

		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumber-report.html" }, monochrome = true)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
