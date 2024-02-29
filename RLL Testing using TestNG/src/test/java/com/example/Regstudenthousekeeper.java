package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Regstudenthousekeeper {
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
	public void Regstudenthousekeepe() throws InterruptedException {
		System.out.println("test1 intiated ");
		wd.get("http://localhost:4200/Adminlogin");
		wd.findElement(By.id("EmailInput")).sendKeys("admintesting3@gmail.com");
		wd.findElement(By.id("PasswordInput")).sendKeys("admintesting");
		Thread.sleep(5000);
		wd.findElement(By.cssSelector(".btn.btn-primary.loginButton.w-100")).click();

		Thread.sleep(10000);
		

		wd.findElement(By.xpath("//button[contains(.,' Register Student')]")).click();
				
		wd.findElement(By.xpath("//*[@id=\"inputRoll\"]")).sendKeys("3122");
		wd.findElement(By.xpath("//*[@id=\"inputRoom\"]")).sendKeys("104");
	    wd.findElement(By.xpath("//*[@id=\"inputFloor\"]")).sendKeys("4");
		wd.findElement(By.xpath("/html/body/app-root/app-registerstudent/div/form/div[4]/button")).click();
		Thread.sleep(5000);
		
		
		
		wd.findElement(By.xpath("//button[contains(.,' Register Housekeeper')]")).click();
		
		
		wd.findElement(By.xpath("//*[@id=\"inputRoll\"]")).sendKeys("Nunez");
		wd.findElement(By.xpath("//*[@id=\"inputRoom\"]")).sendKeys("110");
		Thread.sleep(7000);
		wd.findElement(By.xpath("/html/body/app-root/app-register-housekeeper/div[1]/form/div[3]/button")).click();
		///html/body/app-root/app-register-housekeeper/div[1]/form/div[3]/button
		
	}
	@AfterTest
	  public void  derefer() {
			System.out.println("wd closed");
			wd.close();
		}

	
	
	
}