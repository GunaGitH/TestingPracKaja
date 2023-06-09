package com.guna;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sel_02_LaunchBrowser {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Facebook",Keys.ENTER);
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")).click();
		//driver.quit();
	}

}
