package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGrid {
	public WebDriver wd=null;
	@BeforeTest
	public void beforeSuite() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.WINDOWS);
		caps.setBrowserName("chrome");
		
		try {
			wd = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"), caps);
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void adminLogin() throws InterruptedException {
		  
		  wd.get("http://localhost:4200/Adminlogin");
		  wd.findElement(By.cssSelector("#EmailInput")).sendKeys("admintest2@gmail.com");
		  wd.findElement(By.cssSelector("#PasswordInput")).sendKeys("adminpassword");
		  
		  wd.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div/div[1]/button")).click();
		  Thread.sleep(5000);
		  wd.findElement(By.xpath("//button[contains(.,' Register Housekeeper')]")).click();
		  Thread.sleep(5000);
		  wd.findElement(By.xpath("//button[contains(.,' Register Student')]")).click();
		  Thread.sleep(5000);		
	}
	@AfterTest
	public void  derefer() {
		System.out.println("wd closed");
		wd.close();
	}

}
