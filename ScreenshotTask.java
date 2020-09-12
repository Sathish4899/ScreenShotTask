package com.test;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTask {
	
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sathish S\\eclipse-workspace\\APITesting\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");	
		driver.manage().window().maximize(); 
		captureScreenshot("BeforeLogin");
		driver.findElement(By.id("email")).sendKeys("Sathish");
		driver.findElement(By.id("pass")).sendKeys("Painkiller");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		captureScreenshot("AfterLogin");


	}
	public static void captureScreenshot(String screenshotName) throws IOException {
		SimpleDateFormat simple= new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		String screenshotNameFormat=screenshotName+" "+ simple.format(date);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("C:\\Selenium Task\\Screenshots\\"+screenshotNameFormat+".png"));
		
	}

}
