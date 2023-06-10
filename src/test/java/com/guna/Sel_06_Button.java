package com.guna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.util.BaseClass;

public class Sel_06_Button extends BaseClass {

	private void verifyDisabled() {
		boolean isEnabled = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
		if (isEnabled == false)
			System.out.println("The Button Is Disabled");
		else
			System.out.println("The Button Is Enabled");
	}

	private void btnPosition() {
		int xAxis = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt94']/span[1]")).getLocation().getX();
		int yAxis = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt94']/span[1]")).getLocation().getY();
		System.out.println("xAxis->" + xAxis + " yAxis->" + yAxis);
	}

	private void btnColor() {
		String backgroundColor = driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("background-color");
		System.out.println("backgroundColor->" + backgroundColor);
	}

	private void heightWidth() {
		int btnHeight = driver.findElement(By.id("j_idt88:j_idt98")).getSize().getHeight();
		int btnWidth = driver.findElement(By.id("j_idt88:j_idt98")).getSize().getWidth();
		System.out.println("btnHeight-> "+btnHeight+"\t"+"btnWidth-> "+btnWidth);
	}
	
	private void mouseOver() {
		WebElement btnEle = driver.findElement(By.id("j_idt88:j_idt100"));
		String oldColor = btnEle.getCssValue("background-color");
		Actions action = new Actions(driver);
		action.moveToElement(btnEle).perform();
		String newColor = btnEle.getCssValue("background-color");
		System.out.println("oldColor-> "+oldColor+"\t"+"newColor-> "+newColor);
		if(oldColor==newColor)
			System.out.println("Colors are same");
		else
			System.out.println("Colors are not same");
	}

	private void imgBtn() {
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();	
	}
	
	private void countBtn() {
		//*[@id='j_idt88']/div/div[2]/div[4]
		List<WebElement> btnEleList = driver.findElements(By.xpath("(//*[@class='card'])[7]/button"));
		int size = btnEleList.size();
		System.out.println("Number of Buttons : "+size);
	}
	
	private void confirmTitle() {
		String oldTitle = driver.getTitle();
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String newTitle = driver.getTitle();
		System.out.println("oldTitle-> "+oldTitle+"\t"+"newTitle-> "+newTitle);
		if(oldTitle==newTitle)
			System.out.println("Same Title");
		else
			System.out.println("Different Title");
	}
	
	public static void main(String[] args) {
		BaseClass bcl = new BaseClass();
		Sel_06_Button sel = new Sel_06_Button();
		String uRL = "https://leafground.com/button.xhtml";
		bcl.openURL(uRL);
		// Confirm if the button is disabled.
		sel.verifyDisabled();

		// Find the position of the Submit button
		sel.btnPosition();

		// Find the Save button color
		sel.btnColor();

		// Find the height and width of this button
		sel.heightWidth();
		
		//Mouse over and confirm the color changed
		sel.mouseOver();
		
		//Click Image Button and Click on any hidden button
		sel.imgBtn();
		
		//How many rounded buttons are there?
		sel.countBtn();
		
		//Click and Confirm title.
		sel.confirmTitle();
		
		driver.close();
	}
}
