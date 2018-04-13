package com.sample.auto_selinium_sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageWeb {

	public WebDriver driver;

	public BasePageWeb(WebDriver driver) {
		this.driver = driver;
		this.initPage();
	}

	public void initPage() {
		PageFactory.initElements(driver, this);

	}

	public void pageLoadTimeOut(long time, TimeUnit timeunits) {
		driver.manage().timeouts().pageLoadTimeout(time, timeunits);

	}
}
