package com.sample.auto_selinium_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	public String baseUrl;
	public WebDriver driver;

	@Parameters({ "baseUrl" })
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional("https://weather.com/") String url) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
		baseUrl = url;
		driver.navigate().to(baseUrl);
		System.out.println("Starting test for: " + url);

	}

	@AfterMethod
	public void partitionLine() {
		System.out.println("\n===========================");
	}

}
