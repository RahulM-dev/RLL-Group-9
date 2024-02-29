package com.example;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentRequest {
	
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
  public void studentLogin() throws InterruptedException {
	  
	  wd.get("http://localhost:4200/mainlogin");
	  
	  wd.findElement(By.cssSelector("body > app-root > app-mainlogin > div > div.button-container > button:nth-child(2)")).click();
	  Thread.sleep(5000);
	  
	  wd.findElement(By.id("EmailInput")).sendKeys("3133");
	  wd.findElement(By.id("PasswordInput")).sendKeys("3133");
	  wd.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div[2]/form/div/div[1]/button")).click();
	  
	  Thread.sleep(2000);

	  
	  
	  
	  wd.findElement(By.xpath("//span[contains(text(),'Request To Clean')]")).click();
	  Thread.sleep(2000);

	  WebElement dateBox = wd.findElement(By.cssSelector("#inputEmail4"));
	  dateBox.sendKeys("2932024");
	  Thread.sleep(2000);
	 
      //Fill time 
	  WebElement time = wd.findElement(By.cssSelector("#inputEmail"));
	  time.sendKeys("0415AM");
      Thread.sleep(2000);   
      wd.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
  }
	  
	  @AfterTest
		public void  derefer() throws InterruptedException {
			Thread.sleep(2000);
			System.out.println("wd closed");
			wd.close();
  }
  
 
}
