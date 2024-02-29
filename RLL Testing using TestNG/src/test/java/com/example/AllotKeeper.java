package com.example;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllotKeeper {
	
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
	  
	  wd.get("http://localhost:4200/Adminlogin");
	  wd.findElement(By.id("EmailInput")).sendKeys("admintesting3@gmail.com");
		wd.findElement(By.id("PasswordInput")).sendKeys("admintesting");
		Thread.sleep(5000);
		wd.findElement(By.cssSelector(".btn.btn-primary.loginButton.w-100")).click();

		Thread.sleep(6000);
	  
	  wd.findElement(By.xpath("/html/body/app-root/app-dashboard/div/table/tbody/tr[1]/th/button")).click();
	  ///html/body/app-root/app-dashboard/div/table/tbody/tr[2]/th/button
	  //Create a record which should have the allot button and it must be at 4th row for above click
	  //to happen
	 
	  //Select the Housekeeper
	  Thread.sleep(5000);
	  
	  //Use to scroll below by 500px
	  JavascriptExecutor js = (JavascriptExecutor) wd;
	  js.executeScript("window.scrollBy(0,500)");
	
	    WebElement dropdownElement = wd.findElement(By.xpath("/html/body/app-root/app-allot/div/form/div[5]/select"));
	    ///html/body/app-root/app-allot/div/form/div[5]/select
	    Select dropdown = new Select(dropdownElement);
	    dropdown.selectByVisibleText("Nunez");
	    wd.findElement(By.xpath("/html/body/app-root/app-allot/div/form/div[6]/button")).click();
	  Thread.sleep(5000);
  }
	  
	  @AfterTest
		public void  derefer() throws InterruptedException {
			Thread.sleep(2000);
			System.out.println("wd closed");
			wd.close();
  }
  
 
}
