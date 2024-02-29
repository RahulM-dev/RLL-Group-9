package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentRegistrationAndLogin {
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
	public void test1() throws InterruptedException {
		System.out.println("test1 intiated");
		wd.get("http://localhost:4200/mainlogin");
		  //supply any data
		
		wd.findElement(By.cssSelector("body > app-root > app-mainlogin > div > div.button-container > button:nth-child(2)")).click();
		//body > app-root > app-mainlogin > div > div.button-container > button:nth-child(2)
		wd.findElement(By.cssSelector("body > app-root > app-login-user > div > div > div.formDiv > form > div > div:nth-child(2) > button")).click();
		//body > app-root > app-login-user > div > div > div.formDiv > form > div > div:nth-child(2) > button
		
		//body > app-root > app-mainlogin > div > div.button-container > button:nth-child(2)
		//body > app-root > app-mainlogin > div > div.button-container > button:nth-child(2)
		 wd.findElement(By.id("rollnumber")).sendKeys("4111");
		 wd.findElement(By.id("password")).sendKeys("User3002");
		 wd.findElement(By.id("hostel")).sendKeys("mphasis");
		 wd.findElement(By.id("floor")).sendKeys("4");
		 wd.findElement(By.id("room")).sendKeys("102");


		 wd.findElement(By.xpath("/html/body/app-root/app-userregister/div/div/div[2]/form/div/button")).click();
		 //body > app-root > app-userregister > div > div > div.formDiv > form > div > button
		 
	        Thread.sleep(10000);



		
	}
	
	@Test
	public void test2() throws InterruptedException {
		System.out.println("test1 intiated");
		  //supply any data
		 wd.findElement(By.id("EmailInput")).sendKeys("4111");
		 wd.findElement(By.id("PasswordInput")).sendKeys("User3002");

		 wd.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div[2]/form/div/div[1]/button/strong")).click();

	        Thread.sleep(5000);

	
	}
	
	@AfterTest
	public void  derefer() {
		System.out.println("wd closed");
		wd.close();
	}
}