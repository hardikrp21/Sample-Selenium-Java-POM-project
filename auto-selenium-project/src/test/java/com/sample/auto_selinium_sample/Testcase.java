package com.sample.auto_selinium_sample;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase extends BaseTest {

	private LandingPage landingPage;

	@BeforeClass
	private void init() {
		landingPage = new LandingPage(driver);

	}

	@Test
	public void test1() {
		landingPage.enterSearch("Seattle");
		landingPage.verifyExitsInFilterList("Seattle, Washington");
	}

	@Test
	public void test2() {
		driver.navigate().refresh();
		landingPage.enterSearch("Seattle");
		landingPage.clickFilterList("Seattle, Washington");
	}

	@Test
	public void test3() {
		driver.navigate().refresh();
		landingPage.enterSearch("Seattle");
		landingPage.clickFilterList("Seattle, Washington");
		landingPage.printTimeZone();
	}
	


}
