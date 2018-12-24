package com.selenium2019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class Example1 {
	WebDriver driver;
	@Test
	public void EnterDataInTextBox(){
		System.out.println("Demo for entering text in textbox");
		String path = System.getProperty("user.dir");
		String driverpath = path + "/driver/chromedriver"; 
		System.setProperty("webdriver.chrome.driver", driverpath);System.setProperty("webdriver.chrome.driver", "/Users/amitsharma/Documents/workspace/selenium2019/driver/chromedriver");	
	 driver = new ChromeDriver();
	 driver.get("https://www.facebook.com/");
	 driver.findElement(By.xpath("//*[@id='email']")).sendKeys("vit.amitsharma@gmail.com");
	//*[@id="u_0_s"]
	
	 WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
	 Select select = new Select(day);
	 select.selectByIndex(10);
	 
	 WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
	 select = new Select(month);
	 select.selectByValue("7");
	 driver.quit();
	 
	 
	}

}
