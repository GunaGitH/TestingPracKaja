package com.kaja;

import java.awt.Button;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPractice {
	public static WebDriver driver;

	private void disableButton() {

		boolean btnCheck = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
		if (btnCheck == false)
			System.out.println("Button is disabled");
		else
			System.out.println("Button is enable");
	}

	private void submitButton() {
		WebElement btnElem = driver.findElement(By.id("j_idt88:j_idt94"));
		int btnxAxis = btnElem.getLocation().getX();
		int btnYAxis = btnElem.getLocation().getY();
		System.out.println("Button XAxis" + btnxAxis + "  Button YAxis " + btnYAxis);

	}

	private void findButtonColour() {
		String btnClr = driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("background");
		System.out.println("Button Colour " + btnClr);

	}

	private void buttonHeightWidth() {
		WebElement btnSize = driver.findElement(By.id("j_idt88:j_idt98"));
		int btnHeight = btnSize.getSize().getHeight();
		System.out.println("Button Height " + btnHeight);

		int btnWidth = btnSize.getSize().getWidth();
		System.out.println("Button Width " + btnWidth);

	}

	private void colourChangeBtn() {
		WebElement btnElem = driver.findElement(By.id("j_idt88:j_idt100"));
		String oldClr = btnElem.getCssValue("background");
		Actions actions = new Actions(driver);
		actions.moveToElement(btnElem).perform();
		String newClr = btnElem.getCssValue("background");
		if (oldClr == newClr)
			System.out.println("Colour is not changed");
		else
			System.out.println("Colour is changed");

	}
	
	private void clickImageBtn() {
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();

	}
	
	private void numofButtons() {
		List<WebElement> btnElems = driver.findElements(By.xpath("//*[@id='j_idt88']/div/div[2]/div[4]/button"));
		int btnSize = btnElems.size();
		System.out.println("Number of Buttons "+btnSize);

	}

	public static void main(String[] args) {
		ButtonPractice btp = new ButtonPractice();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/button.xhtml;jsessionid=node0o6xqaq0s3jdel3kfiulixwa8296797.node0");

		// Disable Button
		btp.disableButton();

		// Position of subbit button
		btp.submitButton();

		// Button Colour
		btp.findButtonColour();

		// Button Height and Width
		btp.buttonHeightWidth();

		// Confrim Colour Change
		btp.colourChangeBtn();
		
		// Click Image Button
		btp.clickImageBtn();
		
		// Number of Buttons
		btp.numofButtons();
	}
	

}
