package com.selenium2019;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandleMultipleWindow {
	
	WebDriver driver;
	@Test
	
	public void mulwin(){
		System.out.println("Demo for handling multiple window");
		String path = System.getProperty("user.dir");
		String driverpath = path + "/driver/chromedriver"; 
		System.setProperty("webdriver.chrome.driver", driverpath);
		String globalPath = System.getProperty("user.dir");
		System.out.println(globalPath);
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='social_block']/ul/li[3]/a")));
		
		driver.findElement(By.xpath("//*[@id='social_block']/ul/li[3]/a")).click();
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> itr = windowId.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(parentId);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='footer']/div/section[2]/div/div/ul/li/a")));
		
		driver.findElement(By.xpath("//*[@id='footer']/div/section[2]/div/div/ul/li/a")).click();
		driver.quit();
		
	}

}
