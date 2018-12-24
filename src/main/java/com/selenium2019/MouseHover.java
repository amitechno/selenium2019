package com.selenium2019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	@Test
	public void UseMouseHover(){
		System.out.println("Demo for mouse hover function");
		String path = System.getProperty("user.dir");
		String driverpath = path + "/driver/chromedriver"; 
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver =new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		WebElement more = driver.findElement(By.xpath("//*[@id='ch_funnel_more']"));
		 Actions action = new Actions(driver);
		 action.moveToElement(more).build().perform();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		 new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ch_funnel_more']")));
			
		 driver.findElement(By.linkText("International Flights")).click();
		 driver.quit();
	}
	
	 

}
