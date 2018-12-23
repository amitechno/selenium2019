package com.selenium2019;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleMultipleWindow {
	
	WebDriver driver;
	@Test
	
	public void mulwin(){
		System.out.println("Demo for handling multiple window");
		System.setProperty("webdriver.chrome.driver", "/Users/amitsharma/Documents/workspace/selenium2019/driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//*[@id='social_block']/ul/li[3]/a")).click();
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> itr = windowId.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//*[@id='footer']/div/section[2]/div/div/ul/li/a")).click();
		driver.quit();
		
	}

}
