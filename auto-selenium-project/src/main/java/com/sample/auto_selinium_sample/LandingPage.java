package com.sample.auto_selinium_sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPage extends BasePageWeb {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@classname='theme__inputElement__4bZUj input-gvUyyzTM__inputElement__l7M9C']")
	private WebElement searchtextBox;

	@FindBy(xpath = "//*[@id='APP']/div/div[6]/div[1]/div/div[1]/div/div[2]/div[2]/div/ul/li")
	private List<WebElement> filterList;

	@FindBy(xpath = "//*[@id='APP']/div/div[7]/div[2]/div[2]/div[2]/div[1]/div/section/div[2]/header/p/span[2]")
	private WebElement timeStamp;

	public void enterSearch(String text) {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(searchtextBox)); 

		searchtextBox.click();
		searchtextBox.sendKeys(text);

	}

	public void verifyExitsInFilterList(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(filterList.get(0))); 
		boolean isFound = false;

		for (WebElement webElement : filterList) {
			if (webElement.findElement(By.tagName("a")).getText().equalsIgnoreCase(name)) {
				isFound = true;
				break;
			}
		}

		Assert.assertTrue(isFound);

	}

	public void clickFilterList(String name) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(filterList.get(0))); 
		boolean isCLicked = false;
		for (WebElement webElement : filterList) {
			if (webElement.findElement(By.tagName("a")).getText().equalsIgnoreCase(name)) {
				webElement.click();
				isCLicked = true;
				break;
			}
		}

		Assert.assertTrue(isCLicked);

	}

	public void printTimeZone() {
		System.out.println(timeStamp.getText());
	}

}
