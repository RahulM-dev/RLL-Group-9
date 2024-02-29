package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterHousekeeper {
	
	WebDriver wd=null;
	@BeforeTest
	public void intiate() {
		System.out.println("config intiated");
		//register the webdriver =>browser vendor 
				WebDriverManager.chromedriver().setup();
				//creating an object to the object
				 wd=new ChromeDriver();
				//maximize the browser
				wd.manage().window().maximize();
				
	}
  @Test
  public void feedback() throws InterruptedException {
	  
	  

	  wd.get("http://localhost:4200/Adminlogin");
	  wd.findElement(By.id("EmailInput")).sendKeys("admintesting3@gmail.com");
		wd.findElement(By.id("PasswordInput")).sendKeys("admintesting");
		Thread.sleep(5000);
		wd.findElement(By.cssSelector(".btn.btn-primary.loginButton.w-100")).click();

		Thread.sleep(10000);
	  
		wd.findElement(By.xpath("//button[contains(.,' Register Housekeeper')]")).click();
	  wd.findElement(By.xpath("/html/body/app-root/app-register-housekeeper/div[1]/form/div[1]/input")).sendKeys("Gaurav");
	  wd.findElement(By.xpath("//*[@id=\"inputRoom\"]")).sendKeys("2");
	  wd.findElement(By.xpath("/html/body/app-root/app-register-housekeeper/div[1]/form/div[3]/button")).click();
  }
  
  @AfterTest
  public void  derefer() {
		System.out.println("wd closed");
		wd.close();
	}
  
  
}