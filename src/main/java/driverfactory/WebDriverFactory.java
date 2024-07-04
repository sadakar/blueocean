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

package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.HashMap;
import java.util.Map;


public class WebDriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	// set driver
	public static synchronized void setDriver() throws Exception {


				System.setProperty("webdriver.chrome.driver", "C:\\Tests\\chromedriver.exe");

				// Set Chrome preferences

				HashMap<String, Object> chromePrefs = new HashMap<>();

				System.out.println(chromePrefs.get("download.default_directory"));
				ChromeOptions options = new ChromeOptions();

				options.setExperimentalOption("prefs", chromePrefs);
				options.setCapability("acceptInsecureCerts", true);
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--remote-debugging-port=9222");
				// options.addArguments("--incognito");
				//options.addArguments("--headless=old");
				options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
				options.addArguments("--ignore-ssl-errors=yes");
				options.addArguments("--ignore-certificate-errors");

				options.addArguments("--proxy-server='direct://'");
				options.addArguments("--proxy-bypass-list=*");
				options.addArguments("--disable-gpu");
				// options.addArguments("--no-sandbox");
				// options.addArguments("window-size=1024,768");
				// options.addArguments("--disable-notifications");
				// options.addArguments("--disable-extensions");
				// WebDriverManager.chromedriver().setup()
				// options.setBinary("C:\\Program
				// Files\\Google\\Chrome\\Application\\chrome.exe");
				driver.set(new ChromeDriver(options));
				getDriver().manage().window().maximize();
				getDriver().manage().deleteAllCookies();


	}

	// get driver
	public static synchronized WebDriver getDriver() {

		try {
			return driver.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// quit driver and remove references for ThreadLocal
	public static synchronized void closeDriver() {

		if (null != driver.get()) {
			try {
				// First quit WebDriver session gracefully
				driver.get().quit();
				// Remove WebDriver reference from the ThreadLocal variable.
				driver.remove();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
}
