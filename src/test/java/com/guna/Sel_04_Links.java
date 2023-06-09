package com.guna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sel_04_Links {

	public static void main(String[] args) {
		String uRL = "https://leafground.com/link.xhtml;jsessionid=node01vgdnqy0vx15znhn8c4fey94287222.node0";
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(uRL);
		driver.findElement(By.linkText("Go to Dashboard")).click();
	}

}
